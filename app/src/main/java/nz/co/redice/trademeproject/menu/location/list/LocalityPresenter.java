package nz.co.redice.trademeproject.menu.location.list;

public class LocalityPresenter implements LocalityContract.Presenter {

    private LocalityContract.View mView;
    private LocalityContract.Model mModel;
    private LocalityCursor mCursor;


    public LocalityPresenter(LocalityContract.View view) {
        mView = view;
        mModel = new LocalityService(this);
        mCursor = new LocalityCursor();
    }

    @Override
    public void inflateMenu() {
        mView.updateUI(mModel.getRegionList());
    }

//    private void saveRegion(int position) {
//        if (mCursor.getRegion() == null)
//            mCursor.setRegion((Region) mModel.getRegionList().get(position));
//        if (mCursor.getDistrict() == null) {
//            District district = mCursor.getRegion().getDistricts().get(position);
//            mCursor.setDistrict(district);
//        }
//        if (mCursor.getSuburb()==null) {
//            Suburb suburb = mCursor.getDistrict().getSuburbs().get(position);
//            mCursor.setSuburb(suburb);
//        }
//    }

    @Override
    public void reInflateMenu(int position) {
//        saveRegion(position);
        mView.updateUI(mModel.getSubLocalityList(position));
    }


}
