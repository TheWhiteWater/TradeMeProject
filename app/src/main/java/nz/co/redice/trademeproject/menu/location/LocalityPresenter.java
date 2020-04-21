package nz.co.redice.trademeproject.menu.location;

import android.util.Log;

import nz.co.redice.trademeproject.menu.common.LocalityCursor;
import nz.co.redice.trademeproject.models.localities.District;
import nz.co.redice.trademeproject.models.localities.LocalityEntry;
import nz.co.redice.trademeproject.models.localities.Region;
import nz.co.redice.trademeproject.models.localities.Suburb;

public class LocalityPresenter implements LocalityContract.Presenter {

    private LocalityContract.View mView;
    private LocalityContract.Model mModel;
    private LocalityCursor mCursor;
    private static LocalityPresenter instance;

    private static final String TAG = "App";

    private LocalityPresenter() {
        mCursor = new LocalityCursor();
        mModel = new LocalityService(this);
    }

    public static LocalityPresenter getInstance() {
        if (instance == null) {
            instance = new LocalityPresenter();
        }
        return instance;
    }

    public void attachView(LocalityContract.View view) {
        mView = view;
    }

    @Override
    public void inflateMenu() {
        if (mView != null)
            mView.updateUI(mModel.getRegionList());
    }

    @Override
    public void saveLocality(LocalityEntry entry) {

        if (entry instanceof Region) {
            mCursor.setRegion((Region) entry);
            mView.updateUI(mModel.getSubLocalityList(entry));
        }
        if (entry instanceof District) {
            mCursor.setDistrict((District) entry);
          mView.updateUI(mModel.getSubLocalityList(entry));
        }
        if (entry instanceof Suburb){
            mCursor.setSuburb((Suburb) entry);
            mView.updateUI(mModel.getSubLocalityList(entry));
        }
        Log.d(TAG, "saveLocality: " + entry.getEntryName());
    }

    @Override
    public void detachView() {
        mView = null;
    }
}
