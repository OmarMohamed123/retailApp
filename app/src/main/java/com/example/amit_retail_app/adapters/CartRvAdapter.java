package com.example.amit_retail_app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.amit_retail_app.R;
import com.example.amit_retail_app.models.CategoriesModel;
import com.example.amit_retail_app.models.ProductsModel;

import java.util.List;



public class CartRvAdapter extends RecyclerView.Adapter<CartRvAdapter.CartViewHolder> {
    List<ProductsModel>productsList;
    Context context;

    public CartRvAdapter(List<ProductsModel> productsList, Context context) {
        this.productsList = productsList;
        this.context = context;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_rv_item,parent,false);

        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {

        ProductsModel productsModel=productsList.get(position);
        holder.titleTv.setText(productsModel.getTitle());
        holder.detailsTv.setText(productsModel.getDetails());
        holder.priceTv.setText(productsModel.getFinalPriceText());
        //holder.quantityTv.setText(productsModel.getTitle());


       // Glide.with(context).load(productsModel.getPhoto()).into(holder.productIv);

    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }

    class CartViewHolder extends RecyclerView.ViewHolder{

        ImageView productIv;
        TextView titleTv;
        TextView detailsTv;
        TextView priceTv;
        ImageButton incIb;
        ImageButton decIb;
        TextView quantityTv;
        public CartViewHolder(@Nullable View itemView){

            super(itemView);
//            categoryIv=itemView.findViewById(R.id.category_iv);
//            categoryNameTv=itemView.findViewById(R.id.category_name_tv);
             productIv=itemView.findViewById(R.id.product_cart_iv);
             titleTv=itemView.findViewById(R.id.product_cart_title_tv);
             detailsTv=itemView.findViewById(R.id.product_cart_details_tv);
             priceTv=itemView.findViewById(R.id.product_cart_price_tv);
             incIb=itemView.findViewById(R.id.inc_cart_ib);
             decIb=itemView.findViewById(R.id.dec_cart_ib);
             quantityTv=itemView.findViewById(R.id.quantity_cart_tv);
        }

    }
}
