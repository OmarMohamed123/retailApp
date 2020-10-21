package com.example.amit_retail_app;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductsResponse {
    @SerializedName("products")
    private List<ProductsModel> productslist;

    public List<ProductsModel>getProductsList(){
        return productslist;
    }

    public void setProductslist(List<ProductsModel>productslist){
        this.productslist=productslist;
    }
}
