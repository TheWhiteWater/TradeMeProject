package nz.co.redice.trademeproject.networking;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkClient {

    private static Retrofit.Builder mRetrofit;

    private static HttpLoggingInterceptor connectionLogger = new HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.HEADERS);

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
            .addInterceptor(connectionLogger);


    private NetworkClient() {
        mRetrofit = new Retrofit.Builder()
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create());

    }

    public static Retrofit.Builder getRetrofitBuilder() {
        if (mRetrofit == null) {
            mRetrofit = new Retrofit.Builder();
        }
        return mRetrofit;
    }
}
