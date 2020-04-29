package nz.co.redice.trademeproject.menu.property;

import android.content.Context;

import java.util.List;

import nz.co.redice.trademeproject.models.properties.Listing;
import nz.co.redice.trademeproject.models.properties.Property;

public interface PropertyContract {

    interface Presenter {
        String getAuthHeader();
        void attachView(PropertyContract.View view);
        void onSearchButtonPressed();
        void onRespondReady(Listing listing);
    }

    interface View {
        Context getContext();
        void updateUi(List<Property> properties);
    }

    interface Model {
        void requestPropertyList();
    }
}
