package nz.co.redice.trademeproject.auth.mvp;

import android.webkit.WebView;

import nz.co.redice.trademeproject.auth.services.AuthService;

public class AuthPresenter implements AuthContract.Presenter, AuthContract.OnAuthFinishedListener {


    private WebView mWebView;
    private AuthContract.View mView;
    private AuthService mAuthService;

    public AuthPresenter(AuthContract.View view) {
        mView = view;
        mWebView = view.getWebView();
    }


    @Override
    public void launchAuthorization() {
        mAuthService = new AuthService(mWebView, this);
        mAuthService.authenticate();
    }

    @Override
    public void unsubscribe() {
        mView = null;
        mWebView = null;
    }

    @Override
    public void getHeader(String header) {
        mView.onAuthenticated(header);
    }

}
