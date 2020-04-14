package nz.co.redice.trademeproject.networkservices;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import nz.co.redice.trademeproject.AuthActivity;
import nz.co.redice.trademeproject.model.search.rental.Properties;
import nz.co.redice.trademeproject.model.search.rental.Property;
import nz.co.redice.trademeproject.networkservices.client.TradeMeApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SearchService {

    private static final String SAND_BOX_URL = "https://api.tmsandbox.co.nz/v1/";
    private TradeMeApi mTradeMeApi;
    private Context mContext;
    private String authorizationHeader;


    public SearchService(Context context, Retrofit.Builder retrofit) {
        mContext = context;
        mTradeMeApi = retrofit
                .baseUrl(SAND_BOX_URL)
                .build()
                .create(TradeMeApi.class);
        authorizationHeader = getAuthHeader();
        if (authorizationHeader.isEmpty() || authorizationHeader == null)
            launchReAuthentication();
    }

    /**
     * This method KILLS THE CURRENT SCREEN and (re)launches authentication process due to
     * A) request header absence situation {@link #} or B) 401 code (authentication failure )
     * response.  DON"T FORGET TO SAVE YOUR STATE !!!
     */
    private void launchReAuthentication() {
        mContext.startActivity(new Intent(mContext, AuthActivity.class));
        ((Activity) mContext).finish();
    }

    @NotNull
    public String getAuthHeader() {
        SharedPreferences pref = mContext.getSharedPreferences("MyPref", 0);
        return pref.getString(AuthService.HEADER_KEY, "");
    }


    private List<Property> getSearchResults(Map<String, String> searchParameters) {
        List<Property> searchResults = new ArrayList<>();
        mTradeMeApi.getSearchResults(authorizationHeader, searchParameters)
                .enqueue(new Callback<Properties>() {
                    @Override
                    public void onResponse(Call<Properties> call, Response<Properties> response) {
                        Log.d("Logger", "onResponse: call.header " + call.request().header("Authorization"));
                        Log.d("Logger", "onResponse: response.code " + response.code());
                        Log.d("Logger", "onResponse: response.errorBody " + response.errorBody());
                        Log.d("Logger", "onResponse: response.raw " + response.raw());
                        if (response.body() != null) {
                            searchResults.addAll(response.body().getPropertyList());
                        }
                        Log.d("Logger", "onResponse: response.SIZE " + searchResults.size());
                    }

                    @Override
                    public void onFailure(Call<Properties> call, Throwable t) {
                        Log.d("Logger", "onFailure: " + t.getMessage());
                        Log.d("Logger", "onFailure: " + t.toString());
                    }
                });

        return searchResults;
    }


}
