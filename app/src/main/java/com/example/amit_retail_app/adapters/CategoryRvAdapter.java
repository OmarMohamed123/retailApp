package com.example.amit_retail_app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.amit_retail_app.R;
import com.example.amit_retail_app.models.CategoriesModel;

import java.util.List;

public class CategoryRvAdapter extends RecyclerView.Adapter<CategoryRvAdapter.CategoryViewHolder> {
    List<CategoriesModel>categoriesList;
    Context context;

    public CategoryRvAdapter(List<CategoriesModel> categoriesList, Context context) {
        this.categoriesList = categoriesList;
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_rv_item,parent,false);

        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {

        CategoriesModel categoriesModel=categoriesList.get(position);
        holder.categoryNameTv.setText(categoriesModel.getName());
        Glide.with(context).load(categoriesModel.getCategoryImage()).into(holder.categoryIv);

    }

    @Override
    public int getItemCount() {
        return categoriesList.size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder{

        ImageView categoryIv;
        TextView categoryNameTv;
        public CategoryViewHolder(@Nullable View itemView){

            super(itemView);
            categoryIv=itemView.findViewById(R.id.category_iv);
            categoryNameTv=itemView.findViewById(R.id.category_name_tv);
        }

    }
}
