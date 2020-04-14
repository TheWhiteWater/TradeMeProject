package nz.co.redice.trademeproject;

import android.app.Application;

import nz.co.redice.trademeproject.networkservices.AuthService;
import nz.co.redice.trademeproject.networkservices.SearchService;
import nz.co.redice.trademeproject.networkservices.client.NetworkClient;
import retrofit2.Retrofit;

public class MyApplication extends Application {

    private Retrofit.Builder mRetrofitBuilder;
    private AuthService mAuthService;
    private SearchService mSearchService;
    public AuthService getAuthService() {
        return mAuthService;
    }
    public SearchService getSearchService() {return mSearchService;}

    @Override
    public void onCreate() {
        super.onCreate();
        mRetrofitBuilder = new NetworkClient().getRetrofit();
        mAuthService = new AuthService(this, mRetrofitBuilder);
        mSearchService = new SearchService(this, mRetrofitBuilder);
    }
}
