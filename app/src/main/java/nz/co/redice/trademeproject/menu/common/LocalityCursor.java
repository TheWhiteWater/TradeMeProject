package nz.co.redice.trademeproject.menu.common;

import java.util.ArrayList;
import java.util.List;

import nz.co.redice.trademeproject.models.localities.District;
import nz.co.redice.trademeproject.models.localities.Region;
import nz.co.redice.trademeproject.models.localities.Suburb;

public class LocalityCursor {
    private Region mRegion;
    private District mDistrict;
    private Suburb mSuburb;
    private List<Long> mAdjacentSuburbs;

    public Region getRegion() {
        return mRegion;
    }

    public void setRegion(Region region) {
        mRegion = region;
        mDistrict = null;
        mSuburb = null;
        mAdjacentSuburbs = null;
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
