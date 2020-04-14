package nz.co.redice.trademeproject;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import nz.co.redice.trademeproject.networkservices.SearchService;

public class SearchActivity extends AppCompatActivity {

    @BindView(R.id.textView) TextView mTextView;
    private SearchService mSearchService;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        mSearchService = ((MyApplication)getApplication()).getSearchService();
        mTextView.setText(mSearchService.getAuthHeader());

    }



}
