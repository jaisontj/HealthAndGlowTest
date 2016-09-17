package com.jaison.healthandglowproductlisting.ui.view;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Toast;

import com.jaison.healthandglowproductlisting.R;
import com.jaison.healthandglowproductlisting.enums.ServerError;
import com.jaison.healthandglowproductlisting.model.Response.SkuItemData;
import com.jaison.healthandglowproductlisting.ui.presenter.ProductListingPresenter;
import com.jaison.healthandglowproductlisting.ui.presenter.ProductListingPresenterImpl;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ProductListingActivity extends AppCompatActivity implements ProductListingView {

    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    @Bind(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    ProductListingPresenter presenter;
    ProductListAdapter productListAdapter;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.appbar)
    AppBarLayout appbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_listing);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Nail Polishes");

        //Setting up the recyclerview
        productListAdapter = new ProductListAdapter();
        recyclerView.setAdapter(productListAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        presenter = new ProductListingPresenterImpl(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void showLoadingIndicator() {
        swipeRefreshLayout.setEnabled(true);
        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideLoadingIndicator() {
        swipeRefreshLayout.setEnabled(false);
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void setDataToRecyclerView(List<SkuItemData> dataList) {
        productListAdapter.setData(dataList);
    }

    @Override
    public void addDataToRecyclerView(List<SkuItemData> dataList) {
        productListAdapter.addData(dataList);
    }

    @Override
    public void showError(ServerError error, String message) {
        //Handle error whichever way you like
        Toast.makeText(this, "Error: " + error.toString() + " Message: " + message, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
