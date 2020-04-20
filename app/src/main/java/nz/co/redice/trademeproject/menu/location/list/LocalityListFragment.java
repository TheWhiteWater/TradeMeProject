package nz.co.redice.trademeproject.menu.location.list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import nz.co.redice.trademeproject.R;


public class LocalityListFragment extends Fragment implements LocalityContract.View {

    private RecyclerView mLocalityListRecyclerView;
    private LocalityAdapter mAdapter;
    private LocalityContract.Presenter mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new LocalityPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_for_recyclerview, container, false);
        mLocalityListRecyclerView = view.findViewById(R.id.recyclerview);
        mLocalityListRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mPresenter.inflateMenu();
        return view;
    }

    @Override
    public void updateUI(List<LocalityEntry> localityEntryList) {
        mAdapter = new LocalityAdapter(this, localityEntryList);
        mLocalityListRecyclerView.setAdapter(mAdapter);
    }


    @Override
    public void onLocalitySelected(int position) {
        mPresenter.reInflateMenu(position);
    }




    private class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mTextView;
        private LocalityAdapter mAdapter;

        public Holder(View view, LocalityAdapter adapter) {
            super(view);
            mTextView = itemView.findViewById(R.id.item_textview);
            mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getLayoutPosition();
            mAdapter.onHolderClicked(position);
        }
    }


    private class LocalityAdapter extends RecyclerView.Adapter<Holder> {

        private List<LocalityEntry> mLocalities;
        private LocalityContract.View mView;

        public LocalityAdapter(LocalityContract.View view, List<LocalityEntry> localities) {
            mView = view;
            mLocalities = localities;
        }

        @NonNull
        @Override
        public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.item_locality, parent, false);
            return new Holder(view, this);
        }

        @Override
        public void onBindViewHolder(@NonNull Holder holder, int position) {
            LocalityEntry localityEntry = mLocalities.get(position);
            holder.mTextView.setText(localityEntry.getEntryName());
        }

        @Override
        public int getItemCount() {
            return mLocalities.size();
        }

        public void onHolderClicked(int position) {
            mView.onLocalitySelected(position);
        }


    }

}
