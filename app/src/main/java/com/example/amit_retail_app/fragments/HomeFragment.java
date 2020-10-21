package com.example.amit_retail_app.fragments;

import android.app.ProgressDialog;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.amit_retail_app.ProductsModel;
import com.example.amit_retail_app.ProductsResponse;
import com.example.amit_retail_app.ProductsRvAdapter;
import com.example.amit_retail_app.R;
import com.example.amit_retail_app.RetrofitFactory;
import com.example.amit_retail_app.WebServices;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomeFragment extends Fragment {

RecyclerView productRv;
ProductsRvAdapter adapter;
List<ProductsModel>productsList=new ArrayList<>();

WebServices webServices;
ProgressDialog progressDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view=inflater.inflate(R.layout.fragment_home, container, false);
       productRv=view.findViewById(R.id.products_rv);
       return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

setUpProgressDialog();
progressDialog.show();
        setUpRecyclerView();

    getProducts();
    }

    private void setUpProgressDialog() {
    progressDialog=new ProgressDialog(requireContext());
    progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
    }

    private void getProducts() {

        webServices = RetrofitFactory.getRetrofit().create(WebServices.class);
        Call<ProductsResponse> getProducts=webServices.getProducts();
        getProducts.enqueue(new Callback<ProductsResponse>() {
            @Override
            public void onResponse(Call<ProductsResponse> call, Response<ProductsResponse> response) {
            progressDialog.dismiss();
            productsList.clear();
            productsList.addAll(response.body().getProductsList());
            adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ProductsResponse> call, Throwable t) {
            progressDialog.dismiss();
                Toast.makeText(requireContext(),"Error!!",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setUpRecyclerView()
    {
RecyclerView.LayoutManager layoutManager=new GridLayoutManager(requireContext(),2);
productRv.setLayoutManager(layoutManager);
productRv.addItemDecoration(new GridSpacingItemDecoration(2,dpToPx(16),true));
productRv.setItemAnimator(new DefaultItemAnimator());
adapter=new ProductsRvAdapter(productsList,requireContext());
productRv.setAdapter(adapter);

    }



    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    private int dpToPx(int dp){
        Resources r=getResources(); return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dp,r.getDisplayMetrics()));}
}