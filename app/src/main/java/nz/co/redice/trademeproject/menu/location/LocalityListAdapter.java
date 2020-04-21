package nz.co.redice.trademeproject.menu.location;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import nz.co.redice.trademeproject.R;
import nz.co.redice.trademeproject.menu.location.LocalityListAdapter.Holder;
import nz.co.redice.trademeproject.models.localities.LocalityEntry;

public class LocalityListAdapter extends RecyclerView.Adapter<Holder> {

    private List<LocalityEntry> mLocalities = new ArrayList<>();
    private LocalityContract.Presenter mPresenter;
    private static LocalityListAdapter instance;


    LocalityListAdapter(LocalityContract.Presenter presenter, List<LocalityEntry> localities) {
        mPresenter = presenter;
        mLocalities.addAll(localities);
        notifyDataSetChanged();
    }

    public static LocalityListAdapter getInstance(LocalityContract.Presenter presenter, List<LocalityEntry> localities) {
        if (instance == null)
            instance = new LocalityListAdapter(presenter, localities);
        else {
            instance.mPresenter = presenter;
            instance.mLocalities = localities;
        }
        return instance;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_locality, parent, false);
        return new Holder(view, mPresenter);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.bind(mLocalities.get(position));
    }

    @Override
    public int getItemCount() {
        return mLocalities.size();
    }


    class Holder extends ViewHolder {

        @BindView(R.id.item_textview) TextView mTextView;
        private LocalityContract.Presenter mPresenter;
        private LocalityEntry mEntry;

        public Holder(View itemView, LocalityContract.Presenter presenter) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mPresenter = presenter;
            itemView.setOnClickListener(v -> mPresenter.saveLocality(mEntry));
        }

        void bind(LocalityEntry entry) {
            mEntry = entry;
            mTextView.setText(entry.getEntryName());
        }
    }

}

