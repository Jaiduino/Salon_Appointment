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
import com.example.saloon_version_0.dbHelper.cartItemsDB;
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
 // Products p = new Products();
 public static  List<Products> productIdsOfCart = new ArrayList<>();
 public static  List<Products> productIdsOfCartfromDB = new ArrayList<>();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view =  inflater.inflate(R.layout.fragment_cart, container, false);
      //  Bundle bundle = new Bundle();
      //  productIdsOfCart = (List<Products>) getActivity().getIntent().getSerializableExtra("oj");
        productIdsOfCart = (List<Products>) getArguments().getSerializable("oj");
       Products p = new Products();
        cartItemsDB ca = new cartItemsDB(getActivity());
//        try {
//            Log.e("cart","ID List "+productIdsOfCart);
//            for (int i = 0; i<productIdsOfCart.size()-1;i++){
//                p.setProduct_Id(productIdsOfCart.get(i).getProduct_Id());
//                p.setProduct_Name(productIdsOfCart.get(i).getProduct_Name());
//                p.setPrice(productIdsOfCart.get(i).getPrice());
//                p.setGender(productIdsOfCart.get(i).getGender());
//                p.setDescription(productIdsOfCart.get(i).getDescription());
//
//                ca.additem(p);
//
//
//            }
//            Log.e("cart","p "+p);
//
//        }catch (Exception e){
//            Log.e("cart","productIdEmpty");
//
//        }

            Log.e("CartFragment","ID List cart fragment "+productIdsOfCart);
            for (int i = 0; i<productIdsOfCart.size();i++){
                p.setProduct_Id(productIdsOfCart.get(i).getProduct_Id());            p.setProduct_Name(productIdsOfCart.get(i).getProduct_Name());
                p.setPrice(productIdsOfCart.get(i).getPrice());
                p.setGender(productIdsOfCart.get(i).getGender());
                p.setDescription(productIdsOfCart.get(i).getDescription());
                Log.e("cart","p "+p);
                ca.additem(p);

            }


       // cartItemsDB ca = new cartItemsDB(null);

        Log.e("CartFragment","from db to cart"+ ca.getAllItems());
         productIdsOfCartfromDB = ca.getAllItems();

        btn = view.findViewById(R.id.btnProccedOut);
        btn.setOnClickListener(v ->
        {
            Intent intent = new Intent(getActivity(), BookAppointementActivity.class);
            startActivity(intent);
        });

        recyclerView = view.findViewById(R.id.recyclerView);

        Log.e("CartFragment","from cart fragment "+ productIdsOfCart);


        cartAdapter = new CartAdapter(getContext(), productIdsOfCartfromDB);
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

