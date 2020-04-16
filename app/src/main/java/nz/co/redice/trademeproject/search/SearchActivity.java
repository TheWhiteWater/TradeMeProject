package nz.co.redice.trademeproject.search;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
import nz.co.redice.trademeproject.R;

public class SearchActivity extends AppCompatActivity {

    private SearchService mSearchService;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);

    }



}
