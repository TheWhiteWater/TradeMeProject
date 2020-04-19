package nz.co.redice.trademeproject.auth.mvp;

public class AuthPresenter implements AuthContract.Presenter {


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
    public void onTokensExtracted(String token) {
        mView.getUserVerifier(token);
    }

    @Override
    public void onVerifierReceived(String verifier) {
        mModel.requestFinalTokens(verifier);
    }

    @Override
    public void onTestRequestSuccessful(String header) {
        mView.onAuthenticationSuccessful(header);
    }


}
