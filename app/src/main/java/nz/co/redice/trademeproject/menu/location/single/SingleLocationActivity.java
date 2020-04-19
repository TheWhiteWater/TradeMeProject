package nz.co.redice.trademeproject.menu.location.single;

import androidx.fragment.app.Fragment;

import nz.co.redice.trademeproject.menu.location.SingleFragmentActivity;

public class SingleLocationActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new SingleLocationFragment();
    }
}
