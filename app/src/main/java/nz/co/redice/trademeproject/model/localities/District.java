
package nz.co.redice.trademeproject.model.localities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class District {

    @SerializedName("DistrictId")
    @Expose
    private Long districtId;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Suburbs")
    @Expose
    private List<Suburb> suburbs = null;
    @SerializedName("Count")
    @Expose
    private Long count;

    /**
     * No args constructor for use in serialization
     * 
     */
    public District() {
    }

    /**
     * 
     * @param suburbs
     * @param districtId
     * @param name
     * @param count
     */
    public District(Long districtId, String name, List<Suburb> suburbs, Long count) {
        super();
        this.districtId = districtId;
        this.name = name;
        this.suburbs = suburbs;
        this.count = count;
    }

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Suburb> getSuburbs() {
        return suburbs;
    }

    public void setSuburbs(List<Suburb> suburbs) {
        this.suburbs = suburbs;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

}
