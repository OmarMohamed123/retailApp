package com.example.amit_retail_app.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.amit_retail_app.models.ProductsModel;

import java.util.List;

@Dao
public interface ProductDAO {

    @Query("SELECT * FROM product")
    List<ProductsModel> getAllProducts();

    @Insert
    void insertProducts(ProductsModel productsModel);

    @Query("DELETE FROM product")
    void deleteAllProducts();
}
