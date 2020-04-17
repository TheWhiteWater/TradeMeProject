package nz.co.redice.trademeproject.auth.mvp;

import android.webkit.WebView;

import nz.co.redice.trademeproject.auth.services.AuthService;

public class AuthPresenter implements AuthContract.Presenter, AuthContract.ModelListener {


    private AuthContract.View mView;
    private AuthContract.Model mModel;

    public AuthPresenter(AuthContract.View view) {
        mView = view;
    }

    @Override
    public void launchAuthorization() {
        mModel = new AuthService(this);
        mModel.requestTempTokens();
    }

    @Override
    public void unsubscribe() {
        mView = null;
    }

    @Override
    public void getHeader(String header) {
        mView.onAuthenticated(header);
    }

    @Override
    public void onTokensExtracted(String token) {
        mView.getUserVerifier(token);
    }


}
