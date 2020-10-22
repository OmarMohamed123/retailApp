package com.example.amit_retail_app.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ProductsModel implements Serializable {
    @SerializedName("id")
    private int productId;

    @SerializedName("name")
    private String details;

    @SerializedName("title")
    private String title;

    @SerializedName("category_id")
    private int categoryId;

    @SerializedName("description")
    private String description;

    @SerializedName("price")
    private int price;

    @SerializedName("discount")
    private int discount;

    @SerializedName("discount_type")
    private String discountType;

    @SerializedName("currency")
    private String currency;

    @SerializedName("in_stock")
    private int inStock;

    @SerializedName("avatar")
    private String photo;

    @SerializedName("price_final")
    private double priceFinal;

    @SerializedName("price_final_text")
    private String finalPriceText;

    public ProductsModel(String details, String title, String photo, String finalPriceText) {
        this.details = details;
        this.title = title;
        this.photo = photo;
        this.finalPriceText = finalPriceText;
    }


    public ProductsModel(String details, String title, String finalPriceText) {
        this.details = details;
        this.title = title;
        this.finalPriceText = finalPriceText;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public double getPriceFinal() {
        return priceFinal;
    }

    public void setPriceFinal(double priceFinal) {
        this.priceFinal = priceFinal;
    }

    public String getFinalPriceText() {
        return finalPriceText;
    }

    public void setFinalPriceText(String finalPriceText) {
        this.finalPriceText = finalPriceText;
    }
}
