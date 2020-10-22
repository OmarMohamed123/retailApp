package com.example.amit_retail_app;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.amit_retail_app.models.ProductsModel;
import com.example.amit_retail_app.room.ProductDAO;

@Database(entities = {ProductsModel.class},version = 1,exportSchema = false)
public abstract class ProductDatabase extends RoomDatabase {

public abstract ProductDAO getProductDao();
}
