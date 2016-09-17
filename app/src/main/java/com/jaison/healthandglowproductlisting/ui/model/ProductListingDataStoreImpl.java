package com.jaison.healthandglowproductlisting.ui.model;

import com.jaison.healthandglowproductlisting.enums.ServerError;
import com.jaison.healthandglowproductlisting.model.Request.FilterRequest;
import com.jaison.healthandglowproductlisting.model.Request.ProductListingRequest;
import com.jaison.healthandglowproductlisting.model.Request.SortRequest;
import com.jaison.healthandglowproductlisting.model.Response.ProductListingData;
import com.jaison.healthandglowproductlisting.model.Response.ProductListingResponse;
import com.jaison.healthandglowproductlisting.network.NetworkManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Jaison on 17/09/16.
 */
public class ProductListingDataStoreImpl implements ProductListingDataStore {

    ProductListingDataStore.Listener listener;

    private static final String CATEGORYID = "NAILPOLISH";

    public ProductListingDataStoreImpl(ProductListingDataStore.Listener listener) {
        this.listener = listener;
    }

    @Override
    public void fetchProducts() {
        final ProductListingRequest request = new ProductListingRequest();
        request.setCategoryId(CATEGORYID);
        request.setLastItemCount("0");
        request.setFilter(new FilterRequest());
        request.setSort(new SortRequest());
        Call<ProductListingResponse> productListingResponseCall = NetworkManager.getApiInterface().getProductListing(request);
        productListingResponseCall.enqueue(new Callback<ProductListingResponse>() {
            @Override
            public void onResponse(Call<ProductListingResponse> call, Response<ProductListingResponse> response) {
                if (response.isSuccessful()) {
                    ProductListingResponse res = response.body();
                    if (res.getStatus().equals("Success")) {
                        broadcastData(res.getData());
                    } else {
                        broadcastError(ServerError.UNEXPECTED,res.getMessage());
                    }

                } else {
                    broadcastError(ServerError.UNEXPECTED,"Unexpected");
                }
            }

            @Override
            public void onFailure(Call<ProductListingResponse> call, Throwable t) {
                broadcastError(ServerError.CONNECTION_ERROR,"No Internet connection");
            }
        });

    }

    private void broadcastError(ServerError error, String message) {
        if (listener != null)
            listener.onProductListDataError(error,message);
    }

    private void broadcastData(ProductListingData data) {
        if (listener != null)
            listener.onProductListDataArrived(data);
    }
}
