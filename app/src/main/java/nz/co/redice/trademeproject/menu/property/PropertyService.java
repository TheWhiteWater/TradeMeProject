package nz.co.redice.trademeproject.menu.property;

import android.util.Log;

import nz.co.redice.trademeproject.models.properties.Listing;
import nz.co.redice.trademeproject.models.properties.Property;
import nz.co.redice.trademeproject.networking.TradeMeApi;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PropertyService implements PropertyContract.Model {
    private PropertyContract.Presenter mPresenter;
    private Listing mResult = new Listing();
    private Retrofit mRetrofit;

    public PropertyService(PropertyContract.Presenter presenter) {

        HttpLoggingInterceptor connectionLogger = new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .addInterceptor(connectionLogger);

        mRetrofit = new Retrofit.Builder()
                .baseUrl("https://api.tmsandbox.co.nz/v1/")
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mPresenter = presenter;
    }

    @Override
    public Listing requestPropertyList() {
        mRetrofit.create(TradeMeApi.class)
                .getProperties(mPresenter.getAuthHeader())
                .enqueue(new Callback<Listing>() {
                    @Override
                    public void onResponse(Call<Listing> call, Response<Listing> response) {
                        if (response.isSuccessful()) {
                            response.body().getList();
                            for (Property p : response.body().getList()) {
                                Log.d("App", "onResponse: " + p.getTitle());
                            }
                        }

                    }

                    @Override
                    public void onFailure(Call<Listing> call, Throwable t) {

                    }
                });
        return mResult;
    }


}
