package nz.co.redice.trademeproject.menu.location;

import java.util.ArrayList;
import java.util.List;

import nz.co.redice.trademeproject.models.localities.District;
import nz.co.redice.trademeproject.models.localities.LocalityEntry;
import nz.co.redice.trademeproject.models.localities.Region;
import nz.co.redice.trademeproject.models.localities.Suburb;

public class LocalityService implements LocalityContract.Model {

    private LocalityContract.Presenter mPresenter;
    private List<Region> mRegions;
    private List<District> mDistricts;
    private List<Suburb> mSuburbs;


    public LocalityService(LocalityContract.Presenter presenter) {
        mPresenter = presenter;
        createMockRegions();
    }

    public void createMockRegions() {
        List<Region> regions = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Region reg = new Region("region" + i);
            List<District> districtList = new ArrayList<>();

            for (int j = 0; j < 3; j++) {
                District dis = new District("district" + i);
                List<Suburb> suburbList = new ArrayList<>();

                for (int k = 0; k < 4; k++) {
                    suburbList.add(new Suburb("suburb" + i));
                }

                dis.setSuburbs(suburbList);
                districtList.add(dis);
            }

            reg.setDistricts(districtList);
            regions.add(reg);
        }

        mRegions = regions;
    }

    @Override
    public List<LocalityEntry> getRegionList() {
        List<? extends LocalityEntry> list = mRegions;
        return (List<LocalityEntry>) list;
    }


    @Override
    public List<LocalityEntry> getSubLocalityList(LocalityEntry entry) {
        List<? extends LocalityEntry> list = null;
        if (entry instanceof Region) {
            for (int i = 0; i < mRegions.size(); i++) {
                if (mRegions.get(i).getName().equals(entry.getEntryName())) {
                    mDistricts = mRegions.get(i).getDistricts();
                    list = mDistricts;
                }
            }
        }
        if (entry instanceof District) {
            for (int i = 0; i < mDistricts.size(); i++) {
                if (mDistricts.get(i).getName().equals(entry.getEntryName())) {
                    mSuburbs = mDistricts.get(i).getSuburbs();
                    list = mSuburbs;
                }
            }
        } if (entry instanceof Suburb){
            list = mSuburbs;
        }

        return (List<LocalityEntry>) list;
    }


}