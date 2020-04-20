package nz.co.redice.trademeproject.menu.location.list;

import java.util.List;

public interface LocalityContract {

    interface Presenter {
        void inflateMenu();
        void reInflateMenu(int position);
    }

    interface Model {
        List<LocalityEntry> getRegionList();
        List<LocalityEntry> getSubLocalityList(int position);
    }

    interface View {
        void updateUI(List<LocalityEntry> localityEntryList);
        void onLocalitySelected(int position);
    }
}
