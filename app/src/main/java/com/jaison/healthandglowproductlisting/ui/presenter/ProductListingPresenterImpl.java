package com.jaison.healthandglowproductlisting.ui.presenter;

import com.jaison.healthandglowproductlisting.enums.ServerError;
import com.jaison.healthandglowproductlisting.model.Response.ProductListingData;
import com.jaison.healthandglowproductlisting.ui.model.ProductListingDataStore;
import com.jaison.healthandglowproductlisting.ui.model.ProductListingDataStoreImpl;
import com.jaison.healthandglowproductlisting.ui.view.ProductListingView;

/**
 * Created by Jaison on 17/09/16.
 */
public class ProductListingPresenterImpl implements ProductListingPresenter {

    ProductListingView view;
    ProductListingDataStore dataStore;

    public ProductListingPresenterImpl(ProductListingView view) {
        this.view = view;
        this.dataStore = new ProductListingDataStoreImpl(dataStoreListener);
    }

    @Override
    public void onResume() {
        view.showLoadingIndicator();
        //Fetch again on resume to update the records
        dataStore.fetchProducts();
    }

    @Override
    public void onDestroy() {

    }

    private ProductListingDataStore.Listener dataStoreListener = new ProductListingDataStore.Listener() {
        @Override
        public void onProductListDataArrived(ProductListingData data) {
            view.setDataToRecyclerView(data.getSkuItems());
            view.hideLoadingIndicator();
        }

        @Override
        public void onProductListDataError(ServerError error, String message) {
            view.showError(error,message);
        }
    };

}
