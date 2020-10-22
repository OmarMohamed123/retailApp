package com.example.amit_retail_app.asyncTasks;

import android.os.AsyncTask;

import com.example.amit_retail_app.room.ProductDAO;

public class DeleteProductsAsyncTask extends AsyncTask <Void,Void,Void>{

private ProductDAO productDAO;

    public DeleteProductsAsyncTask(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        return null;
    }
}
