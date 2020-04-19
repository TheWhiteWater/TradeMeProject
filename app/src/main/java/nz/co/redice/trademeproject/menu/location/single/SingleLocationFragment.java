package nz.co.redice.trademeproject.menu.location.single;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import nz.co.redice.trademeproject.R;
import nz.co.redice.trademeproject.menu.location.list.LocalityCursor;

public class SingleLocationFragment extends Fragment {

    private LocalityCursor mCursor;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCursor = new LocalityCursor();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_single_locality, container, false);

        return view;
    }
}
