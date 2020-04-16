package nz.co.redice.trademeproject.auth.services;

import android.graphics.Bitmap;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.io.IOException;

import nz.co.redice.trademeproject.auth.mvp.AuthContract;
import nz.co.redice.trademeproject.networking.NetworkClient;
import nz.co.redice.trademeproject.networking.TradeMeApi;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static nz.co.redice.trademeproject.auth.services.AuthConstants.*;

public class AuthService {

    private static String sOauthToken;
    private static String sOauthTokenSecret;
    private static String sOauthVerifier;
    private AuthContract.OnAuthFinishedListener mListener;

    private TradeMeApi mTradeMeApi;
    private WebView mWebView;

    public AuthService(WebView webView, AuthContract.OnAuthFinishedListener listener) {
        mTradeMeApi = NetworkClient.getRetrofitBuilder()
                .baseUrl(OAUTH_URL)
                .build()
                .create(TradeMeApi.class);
        mWebView = webView;
        mListener = listener;
    }

    private static String getStageOneHeader() {
        return "OAuth oauth_consumer_key=" + CONSUMER_KEY + "," +
                "oauth_signature_method=" + SIGNATURE_METHOD + "," +
                "oauth_signature=" + CONSUMER_SECRET;
    }

    private static String getStageThreeHeader() {
        return "OAuth oauth_verifier=" + sOauthVerifier + "," +
                "oauth_consumer_key=" + CONSUMER_KEY + "," +
                "oauth_token=" + sOauthToken + "," +
                "oauth_signature_method=" + SIGNATURE_METHOD + "," +
                "oauth_signature=" + CONSUMER_SECRET + "" + sOauthTokenSecret;
    }

    private static String getRequestHeader() {
        return "OAuth " +
                "oauth_consumer_key=" + CONSUMER_KEY + "," +
                "oauth_token=" + sOauthToken + "," +
                "oauth_signature_method=" + SIGNATURE_METHOD + "," +
                "oauth_signature=" + CONSUMER_SECRET + "" + sOauthTokenSecret;
    }

    public void authenticate() {
        launchStageOne();
    }

    /**
     * Stage 1.
     * Generates a temporary token by making a request to this
     * URL: https://secure.trademe.co.nz/Oauth/RequestToken?scope=<scope>.
     * The request is a valid OAuth request (with a consumer key,
     * a signature and optionally a callback, but without a token).
     * The scope parameter is optional but if supplied must be a comma-separated
     * list of these possible values: MyTradeMeRead, MyTradeMeWrite, BiddingAndBuying.
     */

    public void launchStageOne() {
        mTradeMeApi.requestToken(SCOPE, getStageOneHeader())
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        setResponseLog("Stage1 ", response);
                        extractTokens(response);
                        if (response.isSuccessful())
                            launchStageTwo();
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        setFailureLog("Stage1 ", t.getMessage());
                    }
                });

    }


    /**
     * @param response Extracts tokens from response.body
     */
    private void extractTokens(Response<ResponseBody> response) {
        if (response.isSuccessful() && response.body() != null) {
            try {
                String[] result = response.body().string().split("&");
                sOauthToken = result[0].substring((result[0].indexOf('=') + 1));
                sOauthTokenSecret = result[1].substring((result[1].indexOf('=') + 1));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else
            setFailureLog("Stage2 ", response.message());
    }


    /**
     * Stage 2.
     * Redirects user to: https://secure.trademe.co.nz/Oauth/Authorize?oauth_token=<token>.
     * User is expected to log in and then grant access to their account. Once that is done,
     * the user will be redirected to a callback URL. Where granted verifier is being stored.
     */

    private void launchStageTwo() {
        final String userAuthorizationUrl = AuthConstants.USER_AUTHORIZATION_URL + sOauthToken;
        mWebView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return false;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                if (url.contains("oauth_verifier")) {
                    sOauthVerifier = url.substring(url.lastIndexOf('=') + 1);
                    if (sOauthVerifier.equals(url.substring(url.lastIndexOf('=') + 1)) || sOauthVerifier.isEmpty())
                        launchStageThree();
                    else
                        Log.d("Stage2", "onPageStarted: Verifier substring ERROR");
                }
                super.onPageStarted(view, url, favicon);
            }
        });
        Log.d("stage2", "url: " + userAuthorizationUrl);
        mWebView.loadUrl(userAuthorizationUrl);
    }


    /**
     * Stage 3.
     * Swaps request token with a long-lived access token by making a request to:
     * https://secure.trademe.co.nz/Oauth/AccessToken You will need to include the request token
     * (which you obtained in step 1) and a verifier (which you can get from the redirect URL)
     * among the OAuth parameters.
     */
    private void launchStageThree() {
        mTradeMeApi.accessToken(getStageThreeHeader())
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        setResponseLog("Stage3 ", response);
                        extractTokens(response);
                        makeTestRequest();
                    }
                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        setFailureLog("Stage3 ", t.getMessage());
                    }
                });
    }


    private void makeTestRequest() {
        mTradeMeApi.testRequest(getRequestHeader())
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        setResponseLog("test", response);
                        if (response.isSuccessful())
                            mListener.getHeader(getRequestHeader());
                    }
                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });
    }


    /**
     * Logging
     *
     * @param tag      Whatever helps identify method. Usually method name.
     * @param response retrofit response to log in.
     */
    private void setResponseLog(String tag, Response<ResponseBody> response) {

        if (response.isSuccessful()) {
            Log.d(tag + "LogTag", "responseProcessing: code ==" + response.code());

        } else {
            Log.d(tag, "responseProcessing:  code == " + response.code());
            Log.d(tag, "responseProcessing:  message == " + response.message());
            try {
                Log.d(tag, "responseProcessing: errorBody == " + response.errorBody().string());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * Logging
     *
     * @param tag     tag
     * @param message error message
     */
    private void setFailureLog(String tag, String message) {
        Log.d(tag, message);
    }


}