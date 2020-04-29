package nz.co.redice.trademeproject.menu.property;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import nz.co.redice.trademeproject.R;
import nz.co.redice.trademeproject.models.properties.Property;

class PropertyAdapter extends RecyclerView.Adapter<PropertyAdapter.Holder> {

    private List<Property> showList = new ArrayList<>();


    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_property, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.bind(showList.get(position));
    }

    @Override
    public int getItemCount() {
        return showList.size();
    }

    void updateListing(List<Property> newList) {
        showList.clear();
        showList.addAll(newList);
        notifyDataSetChanged();
    }

    class Holder extends RecyclerView.ViewHolder {

        TextView nameView;

        public Holder(@NonNull View itemView) {
            super(itemView);
            nameView = itemView.findViewById(R.id.item_name);
        }

        void bind(Property property) {
            nameView.setText(property.getTitle());
        }
    }
}
