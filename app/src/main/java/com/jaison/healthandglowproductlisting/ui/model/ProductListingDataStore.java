package com.jaison.healthandglowproductlisting.ui.model;

import com.jaison.healthandglowproductlisting.enums.ServerError;
import com.jaison.healthandglowproductlisting.model.Response.ProductListingData;

/**
 * Created by Jaison on 17/09/16.
 */
public interface ProductListingDataStore {

    interface Listener {
        void onProductListDataArrived(ProductListingData data);
        void onProductListDataError(ServerError error, String message);
    }

    void fetchProducts();
}
