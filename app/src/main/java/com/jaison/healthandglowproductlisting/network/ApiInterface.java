package com.jaison.healthandglowproductlisting.network;


import com.jaison.healthandglowproductlisting.model.Request.ProductListingRequest;
import com.jaison.healthandglowproductlisting.model.Response.ProductListingResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Jaison on 19/07/16.
 */
public interface ApiInterface {

    @POST("product/categoryNew")
    Call<ProductListingResponse> getProductListing(@Body ProductListingRequest request);
}
