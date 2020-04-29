package nz.co.redice.trademeproject.models.properties;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Category {

    @SerializedName("Count")
    @Expose
    private Long count;
    @SerializedName("Category")
    @Expose
    private String category;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("IsRestricted")
    @Expose
    private Boolean isRestricted;
    @SerializedName("CategoryId")
    @Expose
    private Long categoryId;
    @SerializedName("IsLeaf")
    @Expose
    private Boolean isLeaf;

    public Category(Long count, String category, String name, Boolean isRestricted, Long categoryId, Boolean isLeaf) {
        this.count = count;
        this.category = category;
        this.name = name;
        this.isRestricted = isRestricted;
        this.categoryId = categoryId;
        this.isLeaf = isLeaf;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getRestricted() {
        return isRestricted;
    }

    public void setRestricted(Boolean restricted) {
        isRestricted = restricted;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Boolean getLeaf() {
        return isLeaf;
    }

    public void setLeaf(Boolean leaf) {
        isLeaf = leaf;
    }
}
