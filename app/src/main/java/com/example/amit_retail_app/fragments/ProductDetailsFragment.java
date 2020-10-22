package com.example.amit_retail_app.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.amit_retail_app.ProductsModel;
import com.example.amit_retail_app.R;
import com.google.android.material.button.MaterialButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProductDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProductDetailsFragment extends Fragment {
    private ImageView productIv;
    private TextView titleTv;
    private TextView detailsTv;
    private TextView descriptionTv;
    private TextView priceTv;
    private TextView quantityTv;
    private Button addToCartBtn;

    ProductsModel productsModel;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_product_details, container, false);
        productIv=view.findViewById(R.id.product_details_iv);
        titleTv=view.findViewById(R.id.product_tile_details_tv);;
        detailsTv=view.findViewById(R.id.product_details_details_tv);;
        descriptionTv=view.findViewById(R.id.product_description_tv);;
        priceTv=view.findViewById(R.id.product_details_price_tv);
        quantityTv=view.findViewById(R.id.quantity_details_tv);;
        addToCartBtn=view.findViewById(R.id.add_to_cart_btn);;
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getClickedProductFromHomeFragment();
        setUpClickListener();
    }

    private void setUpClickListener() {
        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: after room implementation
            }
        });
    }

    private void getClickedProductFromHomeFragment() {
        Bundle arguments=getArguments();
        if(arguments!=null){
            productsModel=(ProductsModel)arguments.getSerializable("clickedProduct");
            Glide.with(requireContext()).load(productsModel.getPhoto()).into(productIv);
            titleTv.setText(productsModel.getTitle());
            descriptionTv.setText(productsModel.getDescription());
            detailsTv.setText(productsModel.getDetails());
            priceTv.setText(productsModel.getFinalPriceText());
        }
    }
}