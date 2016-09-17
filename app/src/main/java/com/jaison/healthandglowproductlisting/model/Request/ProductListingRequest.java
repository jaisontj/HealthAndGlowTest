package com.jaison.healthandglowproductlisting.model.Request;

import com.jaison.healthandglowproductlisting.dataHandlers.AppDataHandler;
import com.jaison.healthandglowproductlisting.dataHandlers.UserDataHandler;

/**
 * Created by Jaison on 17/09/16.
 */
public class ProductListingRequest {
    String appType;
    String appVersion;
    String batchSize;
    String categoryId;
    String lastItemCount;
    String pinNumber;

    FilterRequest filter;
    SortRequest sort;

    public ProductListingRequest() {
        setAppType(AppDataHandler.getAppType());
        setAppVersion(AppDataHandler.getAppVersion());
        setBatchSize(AppDataHandler.getBatchSize());
        setPinNumber(UserDataHandler.getUserPincode());
    }

    public void setAppType(String appType) {
        this.appType = appType;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public void setBatchSize(String batchSize) {
        this.batchSize = batchSize;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public void setLastItemCount(String lastItemCount) {
        this.lastItemCount = lastItemCount;
    }

    public void setPinNumber(String pinNumber) {
        this.pinNumber = pinNumber;
    }

    public void setFilter(FilterRequest filter) {
        this.filter = filter;
    }

    public void setSort(SortRequest sort) {
        this.sort = sort;
    }
}
