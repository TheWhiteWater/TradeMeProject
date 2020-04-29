package nz.co.redice.trademeproject.menu.property;

import android.content.Context;

import java.util.List;

import nz.co.redice.trademeproject.models.properties.Property;

public interface PropertyContract {

    interface Presenter {
        String getAuthHeader();
        void attachView(PropertyContract.View view);
        Context provideContext();
        void onSearchButtonPressed();
    }

    interface View {
        Context getContext();
        void updateUi(List<Property> properties);
    }

    interface Model {
        List<Property> requestPropertyList();
    }
}
