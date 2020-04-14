
package nz.co.redice.trademeproject.model.search;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchResult {

    @SerializedName("TotalCount")
    @Expose
    private long mTotalCount;
    @SerializedName("Page")
    @Expose
    private long mPage;
    @SerializedName("PageSize")
    @Expose
    private long mPageSize;
    @SerializedName("List")
    @Expose
    private List<SearchEntry> mSearchEntryList = null;
    @SerializedName("FoundCategories")
    @Expose
    private List<Object> mFoundCategories = null;

    /**
     * No args constructor for use in serialization
     */
    public SearchResult() {
    }

    /**
     * @param foundCategories
     * @param pageSize
     * @param page
     * @param totalCount
     * @param searchEntryList
     */
    public SearchResult(long totalCount, long page, long pageSize, java.util.List<SearchEntry> searchEntryList, java.util.List<Object> foundCategories) {
        super();
        this.mTotalCount = totalCount;
        this.mPage = page;
        this.mPageSize = pageSize;
        this.mSearchEntryList = searchEntryList;
        this.mFoundCategories = foundCategories;
    }

    public long getTotalCount() {
        return mTotalCount;
    }

    public void setTotalCount(long totalCount) {
        this.mTotalCount = totalCount;
    }

    public long getPage() {
        return mPage;
    }

    public void setPage(long page) {
        this.mPage = page;
    }

    public long getPageSize() {
        return mPageSize;
    }

    public void setPageSize(long pageSize) {
        this.mPageSize = pageSize;
    }

    public java.util.List<SearchEntry> getSearchEntryList() {
        return mSearchEntryList;
    }

    public void setSearchEntryList(java.util.List<SearchEntry> searchEntryList) {
        this.mSearchEntryList = searchEntryList;
    }

    public java.util.List<Object> getFoundCategories() {
        return mFoundCategories;
    }

    public void setFoundCategories(java.util.List<Object> foundCategories) {
        this.mFoundCategories = foundCategories;
    }

}
