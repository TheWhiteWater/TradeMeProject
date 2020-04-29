package nz.co.redice.trademeproject.menu.property;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import org.jetbrains.annotations.NotNull;

import nz.co.redice.trademeproject.auth.AuthConstants;
import nz.co.redice.trademeproject.models.properties.Listing;
import nz.co.redice.trademeproject.networking.NetworkClient;
import nz.co.redice.trademeproject.networking.TradeMeApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PropertyService implements PropertyContract.Model {
    private TradeMeApi mTradeMeApi;
    private PropertyContract.Presenter mPresenter;
    private Context mContext;
    private Listing mListingResult;

    public PropertyService(PropertyContract.Presenter presenter) {
        mTradeMeApi = NetworkClient.getRetrofitBuilder()
                .build()
                .create(TradeMeApi.class);
        mPresenter = presenter;
        mContext = mPresenter.provideContext();
    }

    @Override
    public Listing requestPropertyList() {
        mTradeMeApi.getProperties(getAuthHeader()).enqueue(new Callback<Listing>() {
            @Override
            public void onResponse(Call<Listing> call, Response<Listing> response) {
                if (response.isSuccessful()) {
                    mListingResult = new Listing(response.body().getList(),
                            response.body().getFoundCategories());
                    Log.d("App", "onResponse: " + mListingResult.getList().size());
                }
            }

            @Override
            public void onFailure(Call<Listing> call, Throwable t) {
                Log.d("App", "onFailure: Something went wrong" );
            }
        });
        return mListingResult;
    }

    @NotNull
    public String getAuthHeader() {
        SharedPreferences pref = mContext.getSharedPreferences("MyPref", 0);
        return pref.getString(AuthConstants.HEADER_KEY, "");
    }
}
