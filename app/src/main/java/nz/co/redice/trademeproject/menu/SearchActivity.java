package nz.co.redice.trademeproject.menu;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import nz.co.redice.trademeproject.R;
import nz.co.redice.trademeproject.menu.location.LocalityListActivity;

public class SearchActivity extends AppCompatActivity {


    @BindView(R.id.location_card) CardView locationCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.location_card)
    public void onViewClicked() {
        Intent intent = new Intent(this, LocalityListActivity.class);
        startActivity(intent);
    }
}
