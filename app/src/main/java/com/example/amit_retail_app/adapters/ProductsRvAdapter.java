package com.example.amit_retail_app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.amit_retail_app.models.ProductsModel;
import com.example.amit_retail_app.R;

import java.util.List;

public class ProductsRvAdapter extends RecyclerView.Adapter<ProductsRvAdapter.ProductsRvViewHolder> {

    private List<ProductsModel> productsList;
    private Context context;
    private OnProductClickListener onProductClickListener;
    private onAddProductClickListener onAddProductClickListener;

    public ProductsRvAdapter(List<ProductsModel> productsList, Context context, OnProductClickListener onProductClickListener, ProductsRvAdapter.onAddProductClickListener onAddProductClickListener) {
        this.productsList = productsList;
        this.context = context;
        this.onProductClickListener = onProductClickListener;
        this.onAddProductClickListener = onAddProductClickListener;
    }

    public interface onAddProductClickListener{
        void onAddProductClickListener(View view, int position);
    }

    public interface OnProductClickListener{
        void onProductClick(View view, int position);
    }



    @NonNull
    @Override
    public ProductsRvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

     View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.products_rv_item,parent,false);
     return new ProductsRvViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductsRvViewHolder holder, int position) {

        ProductsModel productsModel=productsList.get(position);
        holder.titleTv.setText(productsModel.getTitle());
        holder.priceTv.setText(productsModel.getPrice()+"");
        holder.detailsTv.setText(productsModel.getDetails());
        Glide.with(context).load(productsModel.getPhoto()).into(holder.productIv);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onProductClickListener.onProductClick(view,holder.getAdapterPosition());
            }
        });

        holder.addProductIb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onAddProductClickListener.onAddProductClickListener(view,holder.getAdapterPosition());
            }
        });
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
        ImageButton addProductIb;

        public ProductsRvViewHolder(@NonNull View itemView) {
            super(itemView);
            productIv=itemView.findViewById(R.id.product_iv);
            titleTv=itemView.findViewById(R.id.product_title_tv);
            detailsTv=itemView.findViewById(R.id.product_details_tv);
            priceTv=itemView.findViewById(R.id.product_price_tv);
            addProductIb=itemView.findViewById(R.id.add_product_ib);

        }
    }
}
