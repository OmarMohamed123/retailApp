package com.example.amit_retail_app.asyncTasks;

import android.os.AsyncTask;

import com.example.amit_retail_app.models.ProductsModel;
import com.example.amit_retail_app.room.ProductDAO;

import java.util.List;

public class GetProductAsyncTask extends AsyncTask<Void,Void, List<ProductsModel>> {
    private ProductDAO productDAO;
    public GetProductAsyncTask(ProductDAO productDAO){
        this.productDAO=productDAO;
    }

    @Override
    protected List<ProductsModel> doInBackground(Void... voids) {
        return productDAO.getAllProducts();
    }
}
