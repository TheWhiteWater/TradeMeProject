package nz.co.redice.trademeproject.menu;

import java.util.ArrayList;
import java.util.List;

import nz.co.redice.trademeproject.model.localities.District;
import nz.co.redice.trademeproject.model.localities.Region;
import nz.co.redice.trademeproject.model.localities.Suburb;

public class LocationCursor {
    private Region mRegion;
    private District mDistrict;
    private Suburb mSuburb;
    private List<Long> mAdjacentSuburbs;
    private static LocationCursor instance;

    public Region getRegion() {
        return mRegion;
    }

    private void setRegion(Region region) {
        mRegion = region;
        mDistrict = null;
        mSuburb = null;
        mAdjacentSuburbs = null;
    }

    public LocationCursor getInstance() {
        if (instance == null)
            instance = new LocationCursor();
        return instance;
    }

    public District getDistrict() {
        return mDistrict;

    }

    public void setDistrict(District district) {
        mDistrict = district;
        mSuburb = null;
        mAdjacentSuburbs = null;
    }

    public Suburb getSuburb() {
        return mSuburb;
    }

    public void setSuburb(Suburb suburb) {
        mSuburb = suburb;
        mAdjacentSuburbs = null;
    }

    public List<Long> getAdjacentSuburbs() {
        return mAdjacentSuburbs;
    }

    public void setAdjacentSuburbs(List<Long> adjacentSuburbs) {
        if (mAdjacentSuburbs == null) {
            mAdjacentSuburbs = new ArrayList<>();
        }
        mAdjacentSuburbs.addAll(adjacentSuburbs);
    }
}
