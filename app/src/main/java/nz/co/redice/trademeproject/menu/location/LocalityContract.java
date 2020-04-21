package nz.co.redice.trademeproject.menu.location;

import java.util.List;

import nz.co.redice.trademeproject.models.localities.LocalityEntry;

public interface LocalityContract {

    interface Presenter {
        void attachView(LocalityContract.View view);
        void inflateMenu();
        void saveLocality(LocalityEntry entry);
        void detachView();
    }

    interface Model {
        List<LocalityEntry> getRegionList();
        List<LocalityEntry> getSubLocalityList(LocalityEntry entry);
    }

    interface View {
        void updateUI(List<LocalityEntry> localityEntryList);
    }
}
