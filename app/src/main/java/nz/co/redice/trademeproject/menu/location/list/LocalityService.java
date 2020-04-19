package nz.co.redice.trademeproject.menu.location.list;

import java.util.ArrayList;
import java.util.List;

import nz.co.redice.trademeproject.model.localities.District;
import nz.co.redice.trademeproject.model.localities.Region;
import nz.co.redice.trademeproject.model.localities.Suburb;

public class LocalityService implements LocalityContract.Model {

    private LocalityContract.Presenter mPresenter;
    private List<Region> mRegions;
    private List<District> mDistricts;
    private List<Suburb> mSuburbs;

    boolean regionDone;
    boolean districtDone;
    boolean suburbDone;


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
        regionDone = true;
        return (List<LocalityEntry>) list;
    }

    @Override
    public List<LocalityEntry> getSubLocalityList(int position) {
        if (districtDone == false) {
            mDistricts = mRegions.get(position).getDistricts();
            List<? extends LocalityEntry> list = mDistricts;
            districtDone = true;
            return (List<LocalityEntry>) list;
        } else {
            mSuburbs = mDistricts.get(position).getSuburbs();
            List<? extends LocalityEntry> list = mSuburbs;
            return (List<LocalityEntry>) list;
        }
    }




}
