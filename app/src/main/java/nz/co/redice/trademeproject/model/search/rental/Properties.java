
package nz.co.redice.trademeproject.model.search.rental;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Properties {

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
    private List<Property> mPropertyList = null;
    @SerializedName("FoundCategories")
    @Expose
    private List<Object> mFoundCategories = null;

    /**
     * No args constructor for use in serialization
     */
    public Properties() {
    }

    /**
     * @param foundCategories
     * @param pageSize
     * @param page
     * @param totalCount
     * @param propertyList
     */
    public Properties(long totalCount, long page, long pageSize, java.util.List<Property> propertyList, java.util.List<Object> foundCategories) {
        super();
        this.mTotalCount = totalCount;
        this.mPage = page;
        this.mPageSize = pageSize;
        this.mPropertyList = propertyList;
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

    public java.util.List<Property> getPropertyList() {
        return mPropertyList;
    }

    public void setPropertyList(java.util.List<Property> propertyList) {
        this.mPropertyList = propertyList;
    }

    public java.util.List<Object> getFoundCategories() {
        return mFoundCategories;
    }

    public void setFoundCategories(java.util.List<Object> foundCategories) {
        this.mFoundCategories = foundCategories;
    }

}
