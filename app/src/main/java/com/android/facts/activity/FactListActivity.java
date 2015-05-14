package com.android.facts.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.ListView;

import com.android.facts.R;
import com.android.facts.adapter.FactListAdapter;
import com.android.facts.entity.FactsWrapper;
import com.android.facts.listener.FactServiceModelListener;
import com.android.facts.servicemodel.FactServiceModel;


public class FactListActivity extends BaseActivity implements FactServiceModelListener, SwipeRefreshLayout.OnRefreshListener {

    FactServiceModel mFactServiceModel;
    FactListAdapter mFactListAdapter;
    FactsWrapper mFactsWrapperObject;

    SwipeRefreshLayout mSwipeRefreshLayout;
    ListView mListViewFacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setupUI();
        setupServiceModel();
        loadData();
    }

    private void setupUI() {

        setContentView(R.layout.activity_fact_list);

        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        mSwipeRefreshLayout.setOnRefreshListener(this);

        mListViewFacts = (ListView) findViewById(R.id.list_view_facts);
    }

    private void setupServiceModel() {

        mFactServiceModel = new FactServiceModel(this);
    }

    private void loadData() {

        mFactServiceModel.fetchAllFacts();
    }

    private void updateUI() {

        getSupportActionBar().setTitle(mFactsWrapperObject.getTitle());

        if (mFactListAdapter == null) {
            mFactListAdapter = new FactListAdapter(mFactsWrapperObject.getFacts(), this);
            mListViewFacts.setAdapter(mFactListAdapter);
        } else {
            mFactListAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onFactsFetchSuccess(FactsWrapper factsWrapperObject) {

        mSwipeRefreshLayout.setRefreshing(false);
        mFactsWrapperObject = factsWrapperObject;

        updateUI();
    }

    @Override
    public void onFactsFetchError(String error) {

        mSwipeRefreshLayout.setRefreshing(false);
        super.showNetworkError();
    }

    @Override
    public void onRefresh() {

        mSwipeRefreshLayout.setRefreshing(true);
        loadData();
    }
}
