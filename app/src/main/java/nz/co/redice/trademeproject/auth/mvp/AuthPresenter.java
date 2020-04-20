package nz.co.redice.trademeproject.auth.mvp;

import android.content.SharedPreferences;

import static nz.co.redice.trademeproject.auth.mvp.AuthConstants.HEADER_KEY;

public class AuthPresenter implements AuthContract.Presenter {


    private AuthContract.View mView;
    private AuthContract.Model mModel;
    public static AuthPresenter instance;
    private String retainedToken;
    private boolean isActivityStopping;

    public static AuthPresenter getInstance() {
        if (instance == null) {
            instance = new AuthPresenter();
        }
        return instance;
    }


    @Override
    public void attachView(AuthContract.View view) {
        mView = view;
    }

    @Override
    public void launchAuthorization() {
        if (retainedToken == null) {
            mModel = new AuthService(this);
            mModel.requestTempTokens();
        } else {
            onTokensExtracted(retainedToken);
        }
    }

    @Override
    public void onTokensExtracted(String token) {
        if (mView != null && !isActivityStopping) {
            mView.getUserVerifier(token);
        } else {
            retainedToken = token;
        }
    }

    @Override
    public void onVerifierReceived(String verifier) {
        mModel.requestFinalTokens(verifier);
    }

    @Override
    public void onTestRequestSuccessful(String header) {
        SharedPreferences pref = mView.getContext().getSharedPreferences(AuthConstants.REQUEST_HEADER, 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(HEADER_KEY, header);
        editor.commit();
        mView.onAuthenticationComplete();
    }

    @Override
    public void onActivityStopping(boolean flag) {
        isActivityStopping = flag;
    }

}
