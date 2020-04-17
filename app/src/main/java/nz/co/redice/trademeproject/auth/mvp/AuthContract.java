package nz.co.redice.trademeproject.auth.mvp;

public interface AuthContract {

    interface Presenter {
        void launchAuthorization();
        void onTokensExtracted(String token);
        void onVerifierReceived (String verifier);
        void onTestRequestSuccessful(String header);
    }

    interface View {
        void onAuthenticationSuccessful(String header);
        void getUserVerifier(String token);
    }

    interface Model {
        void requestTempTokens();
        void requestFinalTokens(String verifier);
    }


}
