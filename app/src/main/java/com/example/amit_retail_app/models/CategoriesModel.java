package com.example.amit_retail_app.models;

import com.google.gson.annotations.SerializedName;

public class CategoriesModel {

    @SerializedName("id")
    private int categoryId;
    @SerializedName("name")
    private String name;
    @SerializedName("avatar")
    private String categoryImage;

    public CategoriesModel() {
    }

    public CategoriesModel( String name, String categoryImage) {
        this.name = name;
        this.categoryImage = categoryImage;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(String categoryImage) {
        this.categoryImage = categoryImage;
    }
}
