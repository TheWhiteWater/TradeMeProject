package nz.co.redice.trademeproject.menu.location;

import androidx.fragment.app.Fragment;

import nz.co.redice.trademeproject.menu.common.SingleFragmentActivity;

public class LocalityListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new LocalityListFragment();
    }
}
