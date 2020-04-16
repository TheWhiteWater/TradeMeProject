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
    }

    interface OnAuthFinishedListener {
        void getHeader(String header);
    }
}
