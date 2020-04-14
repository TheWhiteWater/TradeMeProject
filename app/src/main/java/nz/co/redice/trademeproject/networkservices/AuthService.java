package nz.co.redice.trademeproject.networkservices;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.io.IOException;

import nz.co.redice.trademeproject.SearchActivity;
import nz.co.redice.trademeproject.networkservices.client.TradeMeApi;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AuthService {

    private static final String OAUTH_URL = "https://secure.tmsandbox.co.nz/Oauth/";

    private static final String SIGNATURE_METHOD = "PLAINTEXT";
    static final String HEADER_KEY = "header_key";
    private static final String SCOPE = "MyTradeMeRead,MyTradeMeWrite";

    private static final String CONSUMER_KEY = "30548980993F4C6DBBC29869DB28F1FA";
    private static final String CONSUMER_SECRET = "FC503D3AE07F64E3B9A023C2FF08BA33%26";
    private static String sOauthToken;
    private static String sOauthTokenSecret;
    private static String sOauthVerifier;

    private Context mContext;
    private TradeMeApi mTradeMeApi;
    private WebView mWebView;

    public AuthService(Context context, Retrofit.Builder client) {
        mContext = context;
        mTradeMeApi = client
                .baseUrl(OAUTH_URL)
                .build()
                .create(TradeMeApi.class);
    }

    public void setWebView(WebView webView) {
        mWebView = webView;
    }

    private static String getHeaderForStageOne() {
        return "OAuth oauth_consumer_key=" + CONSUMER_KEY + "," +
                "oauth_signature_method=" + SIGNATURE_METHOD + "," +
                "oauth_signature=" + CONSUMER_SECRET;
    }

    private static String getHeaderForStageThree() {
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

    private void launchStageOne() {
        mTradeMeApi.requestToken(SCOPE, getHeaderForStageOne())
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        getResponseLogged("Stage1", response);
                        try {
                            String respond = response.body().string();
                            String[] result = respond.split("&");
                            sOauthToken = result[0].substring((result[0].indexOf('=') + 1));
                            sOauthTokenSecret = result[1].substring((result[1].indexOf('=') + 1));
                            launchStageTwo();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.d("Stage1", "onCallFailure: " + t.getMessage());
                    }
                });

    }


    /**
     * Stage 2.
     * Redirects user to: https://secure.trademe.co.nz/Oauth/Authorize?oauth_token=<token>.
     * User is expected to log in and then grant access to their account. Once that is done,
     * the user will be redirected to a callback URL. Where granted verifier is being stored.
     */


    private void launchStageTwo() {
        final String userAuthorizationUrl = "https://secure.tmsandbox.co.nz/Oauth/Authorize?oauth_token=" + sOauthToken;
        mWebView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return false;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                if (url.contains("oauth_verifier")) {
                    Log.d("Stage2", "url: " + url);
                    sOauthVerifier = url.substring(url.lastIndexOf('=') + 1);
                    Log.d("Stage2", "OauthVerifier: " + sOauthVerifier);
                    if (sOauthVerifier.equals(url.substring(url.lastIndexOf('=') + 1)) || sOauthVerifier.isEmpty())
                        launchStageThree();
                    else
                        Log.d("Stage2", "onPageStarted: Verifier substring ERROR");
                }
                super.onPageStarted(view, url, favicon);
            }
        });

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
        mTradeMeApi.accessToken(getHeaderForStageThree())
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        getResponseLogged("Stage3", response);
                        try {
                            String respond = response.body().string();
                            String[] result = respond.split("&");
                            sOauthToken = result[0].substring(result[0].indexOf("=") + 1);
                            sOauthTokenSecret = result[1].substring(result[1].indexOf("=") + 1);
                            performTestRequest();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });
    }


    private void saveHeader() {
        SharedPreferences pref = mContext.getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(HEADER_KEY, getRequestHeader());
        Log.d("App", "saveHeader: " + getRequestHeader());
        editor.commit();
    }

    private void launchRequests() {
        saveHeader();
        Intent intent = new Intent(mContext, SearchActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);
        ((Activity) mContext).finish();
    }

    private void performTestRequest() {
        mTradeMeApi.testRequest(getRequestHeader())
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        getResponseLogged("testRequest", response);
                        if (response.isSuccessful())
                            launchRequests();
                        // TODO: 4/15/2020
                        //  else
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });
    }

    /**
     * @param tag      Whatever helps identify method. Usually method name.
     * @param response retrofit response to log in.
     */
    private void getResponseLogged(String tag, Response<ResponseBody> response) {

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


}
