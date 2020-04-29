package nz.co.redice.trademeproject.menu.property;

import java.util.ArrayList;
import java.util.List;

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
    private List<Property> mResult = new ArrayList<>();
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
    public List<Property> requestPropertyList() {
        mRetrofit.create(TradeMeApi.class).getProperties(mPresenter.getAuthHeader())
                .enqueue(new Callback<List<Property>>() {
                    @Override
                    public void onResponse(Call<List<Property>> call, Response<List<Property>> response) {
                        mResult.addAll(response.body());
                    }

                    @Override
                    public void onFailure(Call<List<Property>> call, Throwable t) {

                    }
                });
        return mResult;
    }


}
