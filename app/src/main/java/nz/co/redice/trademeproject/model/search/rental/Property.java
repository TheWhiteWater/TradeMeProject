
package nz.co.redice.trademeproject.model.search.rental;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Property {

    @SerializedName("ListingId")
    @Expose
    private long listingId;
    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("Category")
    @Expose
    private String category;
    @SerializedName("StartPrice")
    @Expose
    private long startPrice;
    @SerializedName("StartDate")
    @Expose
    private String startDate;
    @SerializedName("EndDate")
    @Expose
    private String endDate;
    @SerializedName("ListingLength")
    @Expose
    private Object listingLength;
    @SerializedName("HasGallery")
    @Expose
    private boolean hasGallery;
    @SerializedName("AsAt")
    @Expose
    private String asAt;
    @SerializedName("CategoryPath")
    @Expose
    private String categoryPath;
    @SerializedName("PictureHref")
    @Expose
    private String pictureHref;
    @SerializedName("RegionId")
    @Expose
    private long regionId;
    @SerializedName("Region")
    @Expose
    private String region;
    @SerializedName("SuburbId")
    @Expose
    private long suburbId;
    @SerializedName("Suburb")
    @Expose
    private String suburb;
    @SerializedName("NoteDate")
    @Expose
    private String noteDate;
    @SerializedName("ReserveState")
    @Expose
    private long reserveState;
    @SerializedName("IsClassified")
    @Expose
    private boolean isClassified;
    @SerializedName("OpenHomes")
    @Expose
    private java.util.List<Object> openHomes = null;
    @SerializedName("PriceDisplay")
    @Expose
    private String priceDisplay;
    @SerializedName("PhotoUrls")
    @Expose
    private java.util.List<String> photoUrls = null;

    @SerializedName("MemberId")
    @Expose
    private long memberId;
    @SerializedName("Address")
    @Expose
    private String address;
    @SerializedName("District")
    @Expose
    private String district;
    @SerializedName("AgencyReference")
    @Expose
    private String agencyReference;
    @SerializedName("AvailableFrom")
    @Expose
    private String availableFrom;
    @SerializedName("Bathrooms")
    @Expose
    private long bathrooms;
    @SerializedName("Bedrooms")
    @Expose
    private long bedrooms;
    @SerializedName("ListingGroup")
    @Expose
    private String listingGroup;
    @SerializedName("Parking")
    @Expose
    private String parking;
    @SerializedName("PropertyType")
    @Expose
    private String propertyType;
    @SerializedName("RentPerWeek")
    @Expose
    private long rentPerWeek;
    @SerializedName("AdjacentSuburbNames")
    @Expose
    private java.util.List<String> adjacentSuburbNames = null;
    @SerializedName("AdjacentSuburbIds")
    @Expose
    private java.util.List<Long> adjacentSuburbIds = null;
    @SerializedName("DistrictId")
    @Expose
    private long districtId;
    @SerializedName("PetsOkay")
    @Expose
    private long petsOkay;
    @SerializedName("SmokersOkay")
    @Expose
    private long smokersOkay;
    @SerializedName("Whiteware")
    @Expose
    private String whiteware;
    @SerializedName("MaxTenants")
    @Expose
    private long maxTenants;
    @SerializedName("PropertyId")
    @Expose
    private String propertyId;

    /**
     * No args constructor for use in serialization
     */
    public Property() {
    }

    /**
     * @param parking
     * @param photoUrls
     * @param listingLength
     * @param rentPerWeek
     * @param endDate
     * @param smokersOkay
     * @param title
     * @param availableFrom
     * @param adjacentSuburbIds
     * @param propertyType
     * @param whiteware
     * @param adjacentSuburbNames
     * @param agencyReference
     * @param propertyId
     * @param memberId
     * @param startPrice
     * @param suburbId
     * @param priceDisplay
     * @param address
     * @param maxTenants
     * @param categoryPath
     * @param hasGallery
     * @param asAt
     * @param pictureHref
     * @param listingId
     * @param bathrooms
     * @param petsOkay
     * @param openHomes
     * @param reserveState
     * @param bedrooms
     * @param listingGroup
     * @param districtId
     * @param regionId
     * @param noteDate
     * @param district
     * @param suburb
     * @param isClassified
     * @param category
     * @param region
     * @param startDate
     */
    public Property(long listingId, String title, String category, long startPrice, String startDate,
                    String endDate, Object listingLength, boolean hasGallery, String asAt, String categoryPath,
                    String pictureHref, long regionId, String region, long suburbId, String suburb,
                    String noteDate, long reserveState, boolean isClassified, java.util.List<Object> openHomes,
                    String priceDisplay, java.util.List<String> photoUrls, long memberId, String address,
                    String district, String agencyReference, String availableFrom, long bathrooms,
                    long bedrooms, String listingGroup, String parking, String propertyType,
                    long rentPerWeek, java.util.List<String> adjacentSuburbNames,
                    java.util.List<Long> adjacentSuburbIds, long districtId, long petsOkay, long smokersOkay,
                    String whiteware, long maxTenants, String propertyId) {
        super();
        this.listingId = listingId;
        this.title = title;
        this.category = category;
        this.startPrice = startPrice;
        this.startDate = startDate;
        this.endDate = endDate;
        this.listingLength = listingLength;
        this.hasGallery = hasGallery;
        this.asAt = asAt;
        this.categoryPath = categoryPath;
        this.pictureHref = pictureHref;
        this.regionId = regionId;
        this.region = region;
        this.suburbId = suburbId;
        this.suburb = suburb;
        this.noteDate = noteDate;
        this.reserveState = reserveState;
        this.isClassified = isClassified;
        this.openHomes = openHomes;
        this.priceDisplay = priceDisplay;
        this.photoUrls = photoUrls;
        this.memberId = memberId;
        this.address = address;
        this.district = district;
        this.agencyReference = agencyReference;
        this.availableFrom = availableFrom;
        this.bathrooms = bathrooms;
        this.bedrooms = bedrooms;
        this.listingGroup = listingGroup;
        this.parking = parking;
        this.propertyType = propertyType;
        this.rentPerWeek = rentPerWeek;
        this.adjacentSuburbNames = adjacentSuburbNames;
        this.adjacentSuburbIds = adjacentSuburbIds;
        this.districtId = districtId;
        this.petsOkay = petsOkay;
        this.smokersOkay = smokersOkay;
        this.whiteware = whiteware;
        this.maxTenants = maxTenants;
        this.propertyId = propertyId;
    }

    public long getListingId() {
        return listingId;
    }

    public void setListingId(long listingId) {
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

    public long getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(long startPrice) {
        this.startPrice = startPrice;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Object getListingLength() {
        return listingLength;
    }

    public void setListingLength(Object listingLength) {
        this.listingLength = listingLength;
    }

    public boolean isHasGallery() {
        return hasGallery;
    }

    public void setHasGallery(boolean hasGallery) {
        this.hasGallery = hasGallery;
    }

    public String getAsAt() {
        return asAt;
    }

    public void setAsAt(String asAt) {
        this.asAt = asAt;
    }

    public String getCategoryPath() {
        return categoryPath;
    }

    public void setCategoryPath(String categoryPath) {
        this.categoryPath = categoryPath;
    }

    public String getPictureHref() {
        return pictureHref;
    }

    public void setPictureHref(String pictureHref) {
        this.pictureHref = pictureHref;
    }

    public long getRegionId() {
        return regionId;
    }

    public void setRegionId(long regionId) {
        this.regionId = regionId;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public long getSuburbId() {
        return suburbId;
    }

    public void setSuburbId(long suburbId) {
        this.suburbId = suburbId;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getNoteDate() {
        return noteDate;
    }

    public void setNoteDate(String noteDate) {
        this.noteDate = noteDate;
    }

    public long getReserveState() {
        return reserveState;
    }

    public void setReserveState(long reserveState) {
        this.reserveState = reserveState;
    }

    public boolean isIsClassified() {
        return isClassified;
    }

    public void setIsClassified(boolean isClassified) {
        this.isClassified = isClassified;
    }

    public java.util.List<Object> getOpenHomes() {
        return openHomes;
    }

    public void setOpenHomes(java.util.List<Object> openHomes) {
        this.openHomes = openHomes;
    }

    public String getPriceDisplay() {
        return priceDisplay;
    }

    public void setPriceDisplay(String priceDisplay) {
        this.priceDisplay = priceDisplay;
    }

    public java.util.List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(java.util.List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
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

    public String getAgencyReference() {
        return agencyReference;
    }

    public void setAgencyReference(String agencyReference) {
        this.agencyReference = agencyReference;
    }

    public String getAvailableFrom() {
        return availableFrom;
    }

    public void setAvailableFrom(String availableFrom) {
        this.availableFrom = availableFrom;
    }

    public long getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(long bathrooms) {
        this.bathrooms = bathrooms;
    }

    public long getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(long bedrooms) {
        this.bedrooms = bedrooms;
    }

    public String getListingGroup() {
        return listingGroup;
    }

    public void setListingGroup(String listingGroup) {
        this.listingGroup = listingGroup;
    }

    public String getParking() {
        return parking;
    }

    public void setParking(String parking) {
        this.parking = parking;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public long getRentPerWeek() {
        return rentPerWeek;
    }

    public void setRentPerWeek(long rentPerWeek) {
        this.rentPerWeek = rentPerWeek;
    }

    public java.util.List<String> getAdjacentSuburbNames() {
        return adjacentSuburbNames;
    }

    public void setAdjacentSuburbNames(java.util.List<String> adjacentSuburbNames) {
        this.adjacentSuburbNames = adjacentSuburbNames;
    }

    public java.util.List<Long> getAdjacentSuburbIds() {
        return adjacentSuburbIds;
    }

    public void setAdjacentSuburbIds(java.util.List<Long> adjacentSuburbIds) {
        this.adjacentSuburbIds = adjacentSuburbIds;
    }
    public long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(long districtId) {
        this.districtId = districtId;
    }

    public long getPetsOkay() {
        return petsOkay;
    }

    public void setPetsOkay(long petsOkay) {
        this.petsOkay = petsOkay;
    }

    public long getSmokersOkay() {
        return smokersOkay;
    }

    public void setSmokersOkay(long smokersOkay) {
        this.smokersOkay = smokersOkay;
    }

    public String getWhiteware() {
        return whiteware;
    }

    public void setWhiteware(String whiteware) {
        this.whiteware = whiteware;
    }

    public long getMaxTenants() {
        return maxTenants;
    }

    public void setMaxTenants(long maxTenants) {
        this.maxTenants = maxTenants;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

}
