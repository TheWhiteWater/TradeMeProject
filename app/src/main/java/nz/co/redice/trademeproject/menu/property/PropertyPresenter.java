package nz.co.redice.trademeproject.menu.property;

import android.content.Context;

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


    public void attachView(PropertyContract.View view) {
        mView = view;
    }

    @Override
    public Context provideContext() {
        return mView.getContext();
    }


    @Override
    public void onSearchButtonPressed() {
        mModel.requestPropertyList();
    }


}
