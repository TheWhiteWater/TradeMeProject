package nz.co.redice.trademeproject.models.properties;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Property {

    @SerializedName("ListingId")
    @Expose
    private Long listingId;
    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("Category")
    @Expose
    private String category;
    @SerializedName("StartPrice")
    @Expose
    private Float startPrice;

    @SerializedName("HasGallery")
    @Expose
    private Boolean hasGallery;
    @SerializedName("RegionId")
    @Expose
    private Long regionId;
    @SerializedName("Region")
    @Expose
    private String region;
    @SerializedName("SuburbId")
    @Expose
    private Long suburbId;
    @SerializedName("Suburb")
    @Expose
    private String suburb;

    private String priceDisplay;
    @SerializedName("TotalReviewCount")
    @Expose
    private Long totalReviewCount;
    @SerializedName("PositiveReviewCount")
    @Expose
    private Long positiveReviewCount;
    @SerializedName("ShortDescription")
    @Expose
    private String shortDescription;
    @SerializedName("PhotoUrls")
    @Expose
    private java.util.List<String> photoUrls = null;
    @SerializedName("Address")
    @Expose
    private String address;
    @SerializedName("District")
    @Expose
    private String district;
    @SerializedName("Bathrooms")
    @Expose
    private Long bathrooms;
    @SerializedName("Bedrooms")
    @Expose
    private Long bedrooms;
    @SerializedName("BestContactTime")
    @Expose
    private String bestContactTime;

    public Property(Long listingId, String title, String category, Float startPrice, Boolean hasGallery, Long regionId, String region, Long suburbId, String suburb, String priceDisplay, Long totalReviewCount, Long positiveReviewCount, String shortDescription, List<String> photoUrls, String address, String district, Long bathrooms, Long bedrooms, String bestContactTime) {
        this.listingId = listingId;
        this.title = title;
        this.category = category;
        this.startPrice = startPrice;
        this.hasGallery = hasGallery;
        this.regionId = regionId;
        this.region = region;
        this.suburbId = suburbId;
        this.suburb = suburb;
        this.priceDisplay = priceDisplay;
        this.totalReviewCount = totalReviewCount;
        this.positiveReviewCount = positiveReviewCount;
        this.shortDescription = shortDescription;
        this.photoUrls = photoUrls;
        this.address = address;
        this.district = district;
        this.bathrooms = bathrooms;
        this.bedrooms = bedrooms;
        this.bestContactTime = bestContactTime;
    }


    public Long getListingId() {
        return listingId;
    }

    public void setListingId(Long listingId) {
        this.listingId = listingId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Float getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(Float startPrice) {
        this.startPrice = startPrice;
    }

    public Boolean getHasGallery() {
        return hasGallery;
    }

    public void setHasGallery(Boolean hasGallery) {
        this.hasGallery = hasGallery;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Long getSuburbId() {
        return suburbId;
    }

    public void setSuburbId(Long suburbId) {
        this.suburbId = suburbId;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getPriceDisplay() {
        return priceDisplay;
    }

    public void setPriceDisplay(String priceDisplay) {
        this.priceDisplay = priceDisplay;
    }

    public Long getTotalReviewCount() {
        return totalReviewCount;
    }

    public void setTotalReviewCount(Long totalReviewCount) {
        this.totalReviewCount = totalReviewCount;
    }

    public Long getPositiveReviewCount() {
        return positiveReviewCount;
    }

    public void setPositiveReviewCount(Long positiveReviewCount) {
        this.positiveReviewCount = positiveReviewCount;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Long getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(Long bathrooms) {
        this.bathrooms = bathrooms;
    }

    public Long getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(Long bedrooms) {
        this.bedrooms = bedrooms;
    }

    public String getBestContactTime() {
        return bestContactTime;
    }

    public void setBestContactTime(String bestContactTime) {
        this.bestContactTime = bestContactTime;
    }
}