package com.example.amit_retail_app.webServices;

import com.example.amit_retail_app.responses.CategoriesResponse;
import com.example.amit_retail_app.responses.ProductsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WebServices {
    @GET("products")
    Call<ProductsResponse> getProducts();

    @GET("categories")
    Call<CategoriesResponse>getCategories();
}
