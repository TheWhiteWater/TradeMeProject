package nz.co.redice.trademeproject.auth.mvp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import nz.co.redice.trademeproject.R;
import nz.co.redice.trademeproject.search.SearchActivity;

import static nz.co.redice.trademeproject.auth.services.AuthConstants.HEADER_KEY;

public class AuthActivity extends AppCompatActivity implements AuthContract.View {

    @BindView(R.id.webView) WebView mWebView;
    AuthContract.Presenter mAuthPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        ButterKnife.bind(this);
        mAuthPresenter = new AuthPresenter(this);
        mAuthPresenter.launchAuthorization();
    }


    @Override
    public WebView getWebView() {
        return mWebView;
    }

    @Override
    public void onAuthenticated(String header) {
        storeHeader(header);
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
        finish();
    }

    private void storeHeader(String header) {
        SharedPreferences pref = getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(HEADER_KEY, header);
        editor.commit();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mAuthPresenter.unsubscribe();
    }
}
