package com.jaison.healthandglowproductlisting.model.Response;

import java.util.List;

/**
 * Created by Jaison on 17/09/16.
 */
public class SkuItemData {

    String skuName;
    String skuId;
    String skuPrice;
    String skuOfferPrice;
    String skuTotalPrice;
    String skuCurrency;
    List<String> skuImageUrls;
    String skuAverageRating;

    public String getSkuName() {
        return skuName;
    }

    public String getSkuId() {
        return skuId;
    }

    public String getSkuPrice() {
        return skuPrice;
    }

    public String getSkuOfferPrice() {
        return skuOfferPrice;
    }

    public String getSkuTotalPrice() {
        return skuTotalPrice;
    }

    public String getSkuCurrency() {
        return skuCurrency;
    }

    public List<String> getSkuImageUrls() {
        return skuImageUrls;
    }

    public String getSkuAverageRating() {
        return skuAverageRating;
    }
}

