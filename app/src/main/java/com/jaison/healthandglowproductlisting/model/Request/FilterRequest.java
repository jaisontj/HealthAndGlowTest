package com.jaison.healthandglowproductlisting.model.Request;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jaison on 17/09/16.
 */
public class FilterRequest {
    List<String> selectedBrand = new ArrayList<>();
    List<String> selectedPrice = new ArrayList<>();
    List<String> selectedCategory = new ArrayList<>();

    public void setSelectedBrand(List<String> selectedBrand) {
        this.selectedBrand = selectedBrand;
    }

    public void setSelectedPrice(List<String> selectedPrice) {
        this.selectedPrice = selectedPrice;
    }

    public void setSelectedCategory(List<String> selectedCategory) {
        this.selectedCategory = selectedCategory;
    }
}
