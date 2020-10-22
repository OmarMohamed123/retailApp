package com.example.amit_retail_app.responses;

import com.example.amit_retail_app.models.CategoriesModel;
import com.example.amit_retail_app.models.ProductsModel;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoriesResponse {
    @SerializedName("categories")
    private List<CategoriesModel> productslist;

    public List<CategoriesModel> getCategorieslist() {
        return productslist;
    }

    public void setProductslist(List<CategoriesModel> productslist) {
        this.productslist = productslist;
    }
}
