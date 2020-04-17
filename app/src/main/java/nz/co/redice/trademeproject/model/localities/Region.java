
package nz.co.redice.trademeproject.model.localities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Region {

    @SerializedName("LocalityId")
    @Expose
    private Long localityId;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Districts")
    @Expose
    private List<District> districts = null;
    @SerializedName("Count")
    @Expose
    private Long count;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Region() {
    }

    /**
     * 
     * @param name
     * @param districts
     * @param count
     * @param localityId
     */
    public Region(Long localityId, String name, List<District> districts, Long count) {
        super();
        this.localityId = localityId;
        this.name = name;
        this.districts = districts;
        this.count = count;
    }

    public Long getLocalityId() {
        return localityId;
    }

    public void setLocalityId(Long localityId) {
        this.localityId = localityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<District> getDistricts() {
        return districts;
    }

    public void setDistricts(List<District> districts) {
        this.districts = districts;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

}
