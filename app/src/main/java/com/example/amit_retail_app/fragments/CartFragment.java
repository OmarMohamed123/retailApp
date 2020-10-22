package com.example.amit_retail_app.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.amit_retail_app.R;
import com.example.amit_retail_app.adapters.CartRvAdapter;
import com.example.amit_retail_app.models.ProductsModel;

import java.util.ArrayList;
import java.util.List;


public class CartFragment extends Fragment {
RecyclerView cartRv;
CartRvAdapter cartAdapter;
List<ProductsModel>productList=new ArrayList<>();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_cart, container, false);
        cartRv=view.findViewById(R.id.cart_rv);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        ProductsModel productsModel=new ProductsModel("caaadaeeeeeeeeeddddddddddddeeeeeee","sssssssssssssssssss","14 EGP");
productList.add(productsModel);
        productList.add(productsModel);
        productList.add(productsModel);
        productList.add(productsModel);
        productList.add(productsModel);
        productList.add(productsModel);
        productList.add(productsModel);
        productList.add(productsModel);
        productList.add(productsModel);
        productList.add(productsModel);



        cartAdapter=new CartRvAdapter(productList,requireContext());
        cartRv.setLayoutManager(new LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false));
        cartRv.addItemDecoration(new DividerItemDecoration(requireContext(),LinearLayoutManager.VERTICAL));
        cartRv.setAdapter(cartAdapter);

    }
}