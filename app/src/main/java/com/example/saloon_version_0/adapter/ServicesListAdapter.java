package com.example.saloon_version_0.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saloon_version_0.R;
import com.example.saloon_version_0.pojo.Products;
import com.example.saloon_version_0.pojo.ServicesList;

import java.util.ArrayList;
import java.util.List;


public class ServicesListAdapter extends RecyclerView.Adapter<ServicesListAdapter.ViewHolder>
{
    public Context context;
   public List<Products> productsList = new ArrayList<>();
    public AddCartInterface addCartInterface;

    public ServicesListAdapter(Context context, List<Products> productsList) {
        this.context = context;
        this.productsList = productsList;
      //  this.addCartInterface = addCartInterface;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.list_of_services,parent,false);
        return new ViewHolder(view,addCartInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        Products products = productsList.get(position);
       // final ServicesList servicesList = serviceList[position];
        holder.ServiceName.setText(products.getProduct_Name());
        holder.ServicePrice.setText(""+products.getPrice());

    }

    @Override
    public int getItemCount() {
        if(productsList==null) return 0;
        return productsList.size();
       // return productsList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView ServiceName,ServicePrice;
        Button Add;
        AddCartInterface addCartInterface;
        public ViewHolder(@NonNull View itemView, AddCartInterface addCartInterface )
        {
            super(itemView);
            ServiceName = itemView.findViewById(R.id.tvServiceName);
            ServicePrice = itemView.findViewById(R.id.tvServicePrice);
            Add = itemView.findViewById(R.id.btnAdd);
            this.addCartInterface = addCartInterface;

            Add.setOnClickListener((v -> {
                Log.e("viewholder","add is presed");
            }));
        }


    }
}
