package nz.co.redice.trademeproject.networkservices.client;

import java.util.Map;

import nz.co.redice.trademeproject.model.search.SearchResult;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

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

    @GET("Search/Property/Rental.json")
    Call<SearchResult> getSearchResults(
            @Header("Authorization") String param,
            @QueryMap Map<String, String> map
    );

}
