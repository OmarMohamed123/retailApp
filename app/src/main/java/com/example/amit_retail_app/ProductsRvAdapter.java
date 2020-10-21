package com.example.amit_retail_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ProductsRvAdapter extends RecyclerView.Adapter<ProductsRvAdapter.ProductsRvViewHolder> {

    private List<ProductsModel> productsList;
    private Context context;

    public ProductsRvAdapter(List<ProductsModel> productsList, Context context) {
        this.productsList = productsList;
        this.context = context;
    }

    @NonNull
    @Override
    public ProductsRvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

     View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.products_rv_item,parent,false);
     return new ProductsRvViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsRvViewHolder holder, int position) {

        ProductsModel productsModel=productsList.get(position);
        holder.titleTv.setText(productsModel.getTitle());
        holder.priceTv.setText(productsModel.getPrice()+"");
        holder.detailsTv.setText(productsModel.getDetails());
        Glide.with(context).load(productsModel.getPhoto()).into(holder.productIv);

    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }

    class ProductsRvViewHolder extends RecyclerView.ViewHolder{

        ImageView productIv;
        TextView titleTv;
        TextView detailsTv;
        TextView priceTv;

        public ProductsRvViewHolder(@NonNull View itemView) {
            super(itemView);
            productIv=itemView.findViewById(R.id.product_iv);
            titleTv=itemView.findViewById(R.id.product_title_tv);
            detailsTv=itemView.findViewById(R.id.product_details_tv);
            priceTv=itemView.findViewById(R.id.product_price_tv);
        }
    }
}
