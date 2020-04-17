package nz.co.redice.trademeproject.auth.mvp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import nz.co.redice.trademeproject.R;
import nz.co.redice.trademeproject.auth.services.AuthConstants;
import nz.co.redice.trademeproject.menu.SearchMenuActivity;

import static nz.co.redice.trademeproject.auth.services.AuthConstants.HEADER_KEY;

public class AuthActivity extends AppCompatActivity implements AuthContract.View {

    @BindView(R.id.webView) WebView mWebView;
    AuthContract.Presenter mAuthPresenter;
    private static String mUrl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        ButterKnife.bind(this);
        mAuthPresenter = new AuthPresenter(this);
        mAuthPresenter.launchAuthorization();
    }


    @Override
    public WebView getWebView() {
        return mWebView;
    }

    @Override
    public void onAuthenticated(String header) {
        storeHeader(header);
        Intent intent = new Intent(this, SearchMenuActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public String getUserVerifier(String token) {
        final String userAuthorizationUrl = AuthConstants.USER_AUTHORIZATION_URL + token;
        mWebView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return false;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                if (url.contains("oauth_verifier")) {
                    mUrl = url;
                }
                super.onPageStarted(view, url, favicon);
            }
        });
        Log.d("stage2", "url: " + userAuthorizationUrl);
        mWebView.loadUrl(userAuthorizationUrl);
        return mUrl;
    }

    private void storeHeader(String header) {
        SharedPreferences pref = getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(HEADER_KEY, header);
        editor.commit();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mAuthPresenter.unsubscribe();
    }

}