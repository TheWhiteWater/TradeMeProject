package nz.co.redice.trademeproject.models.properties;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Listing {
    @SerializedName("TotalCount")
    @Expose
    private Long totalCount;
    @SerializedName("TotalCountTruncated")
    @Expose
    private Boolean totalCountTruncated;
    @SerializedName("Page")
    @Expose
    private Long page;
    @SerializedName("PageSize")
    @Expose
    private Long pageSize;
    @SerializedName("List")
    @Expose
    private java.util.List<Property> list = null;
    @SerializedName("DidYouMean")
    @Expose
    private String didYouMean;

    @SerializedName("FavouriteId")
    @Expose
    private Long favouriteId;
    @SerializedName("FavouriteType")
    @Expose
    private Long favouriteType;

    @SerializedName("SearchQueryId")
    @Expose
    private String searchQueryId;

    /**
     * No args constructor for use in serialization
     *
     */
    public Listing() {
    }

    public Listing(Long totalCount, Boolean totalCountTruncated, Long page, Long pageSize, List<Property> list, String didYouMean, Long favouriteId, Long favouriteType, String searchQueryId) {
        this.totalCount = totalCount;
        this.totalCountTruncated = totalCountTruncated;
        this.page = page;
        this.pageSize = pageSize;
        this.list = list;
        this.didYouMean = didYouMean;
        this.favouriteId = favouriteId;
        this.favouriteType = favouriteType;
        this.searchQueryId = searchQueryId;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Boolean getTotalCountTruncated() {
        return totalCountTruncated;
    }

    public void setTotalCountTruncated(Boolean totalCountTruncated) {
        this.totalCountTruncated = totalCountTruncated;
    }

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public List<Property> getList() {
        return list;
    }

    public void setList(List<Property> list) {
        this.list = list;
    }

    public String getDidYouMean() {
        return didYouMean;
    }

    public void setDidYouMean(String didYouMean) {
        this.didYouMean = didYouMean;
    }

    public Long getFavouriteId() {
        return favouriteId;
    }

    public void setFavouriteId(Long favouriteId) {
        this.favouriteId = favouriteId;
    }

    public Long getFavouriteType() {
        return favouriteType;
    }

    public void setFavouriteType(Long favouriteType) {
        this.favouriteType = favouriteType;
    }

    public String getSearchQueryId() {
        return searchQueryId;
    }

    public void setSearchQueryId(String searchQueryId) {
        this.searchQueryId = searchQueryId;
    }
}