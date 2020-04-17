package nz.co.redice.trademeproject.auth.mvp;

import android.webkit.WebView;

public interface AuthContract {

    interface Presenter {
        void launchAuthorization();
        void unsubscribe();
    }

    interface View {
        WebView getWebView();
        void onAuthenticated(String header);
        String getUserVerifier(String token);
    }

    interface Model {
        void requestTempTokens();
        void requestFinalTokens(String verifier);
    }

    interface ModelListener {
        void getHeader(String header);
        void onTokensExtracted(String token);

    }
}
