package nz.co.redice.trademeproject.menu.location.list;

import androidx.fragment.app.Fragment;

import nz.co.redice.trademeproject.menu.location.SingleFragmentActivity;

public class LocalityListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new LocalityListFragment();
    }
}
