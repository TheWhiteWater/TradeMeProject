package nz.co.redice.trademeproject.auth;


import android.content.Context;

public interface AuthContract {

    interface Presenter {
        void attachView(AuthContract.View view);
        void launchAuthorization();
        void onTokensExtracted(String token);
        void onVerifierReceived (String verifier);
        void onTestRequestSuccessful(String header);
        void onActivityStopping(boolean flag);
    }

    interface View  {
        Context getContext();
        void onAuthenticationComplete();
        void getUserVerifier(String token);
    }

    interface Model {
        void requestTempTokens();
        void requestFinalTokens(String verifier);
    }


}
