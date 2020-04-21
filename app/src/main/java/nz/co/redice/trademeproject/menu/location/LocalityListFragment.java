package nz.co.redice.trademeproject.menu.location;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import nz.co.redice.trademeproject.R;
import nz.co.redice.trademeproject.models.localities.LocalityEntry;

public class LocalityListFragment extends Fragment implements LocalityContract.View {

    @BindView(R.id.recyclerview) RecyclerView mLocalityListRecyclerView;
    private LocalityListAdapter mAdapter;
    private LocalityContract.Presenter mPresenter;
    private Unbinder mUnbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = LocalityPresenter.getInstance();
        mPresenter.attachView(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_for_recyclerview, container, false);
        mUnbinder = ButterKnife.bind(this, view);
        mLocalityListRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.inflateMenu();
    }

    @Override
    public void updateUI(List<LocalityEntry> localityEntryList) {
        mAdapter = LocalityListAdapter.getInstance(mPresenter, localityEntryList);
        mLocalityListRecyclerView.setAdapter(mAdapter);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null) {
            mUnbinder.unbind();
            mUnbinder = null;
        }
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
        }
    }
}
