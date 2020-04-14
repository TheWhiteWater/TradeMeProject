package nz.co.redice.trademeproject.networkservices.client;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkClient {

    private Retrofit.Builder mRetrofit;

    private static HttpLoggingInterceptor connectionLogger = new HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.HEADERS);

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
            .addInterceptor(connectionLogger);


    public NetworkClient() {
        mRetrofit = new Retrofit.Builder()
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create());

    }

    public Retrofit.Builder getRetrofit() {
        return mRetrofit;
    }
}
