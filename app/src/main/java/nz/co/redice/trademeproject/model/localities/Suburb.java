
package nz.co.redice.trademeproject.model.localities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Suburb {

    @SerializedName("SuburbId")
    @Expose
    private Long suburbId;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("AdjacentSuburbs")
    @Expose
    private List<Long> adjacentSuburbs = null;
    @SerializedName("Count")
    @Expose
    private Long count;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Suburb() {
    }

    /**
     * 
     * @param suburbId
     * @param adjacentSuburbs
     * @param name
     * @param count
     */
    public Suburb(Long suburbId, String name, List<Long> adjacentSuburbs, Long count) {
        super();
        this.suburbId = suburbId;
        this.name = name;
        this.adjacentSuburbs = adjacentSuburbs;
        this.count = count;
    }

    public Long getSuburbId() {
        return suburbId;
    }

    public void setSuburbId(Long suburbId) {
        this.suburbId = suburbId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getAdjacentSuburbs() {
        return adjacentSuburbs;
    }

    public void setAdjacentSuburbs(List<Long> adjacentSuburbs) {
        this.adjacentSuburbs = adjacentSuburbs;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

}
