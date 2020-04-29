package nz.co.redice.trademeproject.menu.property;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import org.jetbrains.annotations.NotNull;

import nz.co.redice.trademeproject.auth.AuthConstants;

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
        Log.d("App", "getAuthHeader: " + header);
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
    public Context provideContext() {
        return mView.getContext();
    }


    @Override
    public void onSearchButtonPressed() {
        getAuthHeader();
        mModel = new PropertyService(this);
        mView.updateUi(mModel.requestPropertyList());
    }


}
