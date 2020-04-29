package nz.co.redice.trademeproject.menu.property;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import nz.co.redice.trademeproject.R;
import nz.co.redice.trademeproject.models.properties.Property;

public class PropertyActivity extends AppCompatActivity
        implements PropertyContract.View {

    private PropertyAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private PropertyContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property);

        mAdapter = new PropertyAdapter();
        mRecyclerView = findViewById(R.id.property_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);

        mPresenter = PropertyPresenter.getInstance();
        mPresenter.attachView(this);
        mPresenter.onSearchButtonPressed();
    }


    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    @Override
    public void updateUi(List<Property> properties) {
        mAdapter.updateListing(properties);
        for (int i = 0; i < properties.size(); i++) {
            Log.d("App", "updateUi: "+ properties.get(i).getTitle());
        }
    }
}
