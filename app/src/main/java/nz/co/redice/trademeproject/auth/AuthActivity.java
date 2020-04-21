package nz.co.redice.trademeproject.auth;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import nz.co.redice.trademeproject.R;
import nz.co.redice.trademeproject.menu.SearchActivity;

public class AuthActivity extends AppCompatActivity implements AuthContract.View {

    @BindView(R.id.webView) WebView mWebView;
    AuthContract.Presenter mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        ButterKnife.bind(this);
        mPresenter = AuthPresenter.getInstance();
        mPresenter.attachView(this);
        mPresenter.launchAuthorization();
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    @Override
    public void onAuthenticationComplete() {
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
        finish();
    }

    public void getUserVerifier(String token) {
        final String userAuthorizationUrl = AuthConstants.USER_AUTHORIZATION_URL + token;
        mWebView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return false;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                if (url.contains(AuthConstants.VERIFIER_KEY)) {
                    mPresenter.onVerifierReceived(url);
                }
                super.onPageStarted(view, url, favicon);
            }
        });
        mWebView.loadUrl(userAuthorizationUrl);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter = null;
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.onActivityStopping(true);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.onActivityStopping(false);
        mPresenter.launchAuthorization();
    }
}