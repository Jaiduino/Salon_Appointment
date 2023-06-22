package com.example.saloon_version_0.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saloon_version_0.R;
import com.example.saloon_version_0.activity.BookAppointementActivity;
import com.example.saloon_version_0.adapter.AddCartInterface;
import com.example.saloon_version_0.adapter.AppointementAdapter;
import com.example.saloon_version_0.adapter.CartAdapter;
import com.example.saloon_version_0.adapter.ServicesListAdapter;
import com.example.saloon_version_0.pojo.Appointements;
import com.example.saloon_version_0.pojo.CartItem;
import com.example.saloon_version_0.pojo.Products;
import com.example.saloon_version_0.pojo.ServicesList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CartFragment extends Fragment implements AddCartInterface
{
    Button btn;
    RecyclerView recyclerView;
    CartAdapter cartAdapter;
  //  CartItem[] cartItems;
  List<Products> productIdsOfCart = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view =  inflater.inflate(R.layout.fragment_cart, container, false);
        Bundle bundle = new Bundle();
        productIdsOfCart = (List<Products>) getArguments().getSerializable("oj");
        btn = view.findViewById(R.id.btnProccedOut);
        btn.setOnClickListener(v ->
        {
            Intent intent = new Intent(getActivity(), BookAppointementActivity.class);
            startActivity(intent);
        });

        recyclerView = view.findViewById(R.id.recyclerView);

        Log.e("cart","from cart fragment "+ productIdsOfCart);


         cartAdapter = new CartAdapter(getContext(), productIdsOfCart);
        recyclerView.setAdapter(cartAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        cartAdapter.notifyDataSetChanged();
        return view;
    }


    @Override
    public void addProducts(List<Products> pList) {

    }
}

