package nz.co.redice.trademeproject.models.properties;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Listing {

    @SerializedName("List")
    @Expose
    private java.util.List<Property> list = null;
    @SerializedName("FoundCategories")
    @Expose
    private java.util.List<Category> foundCategories = null;


    public Listing(List<Property> list, List<Category> foundCategories) {
        this.list = list;
        this.foundCategories = foundCategories;
    }

    public List<Property> getList() {
        return list;
    }

    public void setList(List<Property> list) {
        this.list = list;
    }

    public List<Category> getFoundCategories() {
        return foundCategories;
    }

    public void setFoundCategories(List<Category> foundCategories) {
        this.foundCategories = foundCategories;
    }
}