package nz.co.redice.trademeproject.menu.property;

import android.content.SharedPreferences;
import android.util.Log;

import org.jetbrains.annotations.NotNull;

import nz.co.redice.trademeproject.auth.AuthConstants;
import nz.co.redice.trademeproject.models.properties.Listing;

public class PropertyPresenter implements PropertyContract.Presenter {


    private PropertyContract.View mView;
    private PropertyContract.Model mModel;
    public static PropertyPresenter instance;
    private boolean isActivityStopping;


    public static PropertyPresenter getInstance() {
        if (instance == null) {
            instance = new PropertyPresenter();
        }
        return instance;
    }

    @NotNull
    public String getAuthHeader() {
        SharedPreferences pref = mView.getContext().getSharedPreferences(AuthConstants.REQUEST_HEADER, 0);
        String header = pref.getString(AuthConstants.HEADER_KEY, "");
        if (header.isEmpty())
            getNewAuthentication();
        return header;
    }

    private void getNewAuthentication() {
        // TODO: 4/29/2020 new AuthActivity launch
        Log.d("App", "launchAuthActivity: started");
    }

    public void attachView(PropertyContract.View view) {
        mView = view;
    }



    @Override
    public void onSearchButtonPressed() {
        mModel = new PropertyService(this);
        mModel.requestPropertyList();

    }

    @Override
    public void onRespondReady(Listing listing) {
        mView.updateUi(listing.getList());
    }


}
