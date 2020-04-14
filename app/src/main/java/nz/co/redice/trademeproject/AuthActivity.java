package nz.co.redice.trademeproject;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import nz.co.redice.trademeproject.networkservices.AuthService;

public class AuthActivity extends AppCompatActivity {

    @BindView(R.id.webView) WebView mWebView;
    AuthService mAuthService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        ButterKnife.bind(this);
        mAuthService = ((MyApplication)getApplication()).getAuthService();
        mAuthService.setWebView(mWebView);
        mAuthService.authenticate();
    }


}
