package com.jaison.healthandglowproductlisting.ui.view;

import com.jaison.healthandglowproductlisting.enums.ServerError;
import com.jaison.healthandglowproductlisting.model.Response.SkuItemData;

import java.util.List;

/**
 * Created by Jaison on 17/09/16.
 */
public interface ProductListingView {
    void showLoadingIndicator();
    void hideLoadingIndicator();
    void setDataToRecyclerView(List<SkuItemData> dataList);
    void addDataToRecyclerView(List<SkuItemData> dataList);
    void showError(ServerError error, String message);
}
