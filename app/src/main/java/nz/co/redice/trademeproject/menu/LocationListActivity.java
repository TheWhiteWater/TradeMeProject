package nz.co.redice.trademeproject.menu;

import androidx.fragment.app.Fragment;

public class LocationListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new LocationListFragment();
    }
}
