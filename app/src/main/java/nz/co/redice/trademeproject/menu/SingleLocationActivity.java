package nz.co.redice.trademeproject.menu;

import androidx.fragment.app.Fragment;

public class SingleLocationActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new SingleLocationFragment();
    }
}
