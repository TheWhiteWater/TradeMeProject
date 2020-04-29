package nz.co.redice.trademeproject.networking;

import nz.co.redice.trademeproject.models.properties.Listing;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface TradeMeApi {

    @POST("RequestToken")
    Call<ResponseBody> requestToken(
            @Query("scope") String scope
            , @Header("Authorization") String param
    );

    @POST("AccessToken")
    Call<ResponseBody> accessToken(
            @Header("Authorization") String param
    );

    @GET("https://api.tmsandbox.co.nz/v1/MyTradeMe/Watchlist/All.json")
    Call<ResponseBody> testRequest(
            @Header("Authorization") String param
    );

    @GET("Search/Property/CommercialSale.json")
    Call <Listing> getProperties(
            @Header("Authorization") String param
    );

}
