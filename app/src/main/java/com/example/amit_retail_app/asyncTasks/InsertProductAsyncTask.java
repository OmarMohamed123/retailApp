package com.example.amit_retail_app.asyncTasks;

import android.os.AsyncTask;

import com.example.amit_retail_app.models.ProductsModel;
import com.example.amit_retail_app.room.ProductDAO;

public class InsertProductAsyncTask extends AsyncTask<ProductsModel,Void,Void> {

private ProductDAO productDAO;

public InsertProductAsyncTask(ProductDAO productDAO){
    this.productDAO=productDAO;
}

    @Override
    protected Void doInBackground(ProductsModel... productsModels) {
productDAO.insertProducts(productsModels[0]);
        return null;
    }
}
