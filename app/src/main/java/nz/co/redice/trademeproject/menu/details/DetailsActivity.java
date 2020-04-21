package nz.co.redice.trademeproject.menu.details;

import androidx.fragment.app.Fragment;

import nz.co.redice.trademeproject.menu.common.SingleFragmentActivity;

public class DetailsActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new DetailsFragment();
    }
}
