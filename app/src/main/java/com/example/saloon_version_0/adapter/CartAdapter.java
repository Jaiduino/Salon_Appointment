package com.example.saloon_version_0.adapter;

import android.content.Context;
import android.os.Handler;
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
import com.example.saloon_version_0.dbHelper.cartItemsDB;
import com.example.saloon_version_0.fragment.CartFragment;
import com.example.saloon_version_0.pojo.CartItem;
import com.example.saloon_version_0.pojo.Products;
import com.example.saloon_version_0.pojo.ServicesList;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends RecyclerView .Adapter<CartAdapter.ViewHolder>
{

    public Context context;
   public List<Products> productsList = new ArrayList<>();

    public CartAdapter(Context context, List<Products> productsList)
    {
       this.context = context;
        this.productsList = productsList;
        Log.e("cartAdapter","productLIst from cart "+productsList);
    }

    public CartAdapter() {

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.list_cart,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
//        final CartItem cartItem = cartItems[position];
//        holder.SrNo.setText("" + cartItem.getSrNo());
//        holder.ServiceName.setText(cartItem.getServiceName());
//        holder.ServicePrice.setText(cartItem.getServicePrice());
//        holder.remove.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                holder.remove.setText("Removed");
//                Toast.makeText(context, holder.ServiceName.getText()+" service is removed from the cart", Toast.LENGTH_SHORT).show();
//            }
//        });
        Products products = productsList.get(position);
        holder.ServiceName.setText(products.getProduct_Name());
        holder.ServicePrice.setText(""+products.getPrice());
        holder.remove.setOnClickListener(v -> {
            Log.e("CartAdapter "," Remove button Is Pressed "+position);
            Log.e("CartAdapter "," Remove button Is Pressed "+products.getProduct_Id());
           // productsList.remove(position);
            cartItemsDB ca = new cartItemsDB(context);
            ca.deleteitem(products.getProduct_Id());
           // notifyDataSetChanged();


        });

    }


    @Override
    public int getItemCount()
    {
        if(productsList==null) return 0;
        return productsList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView SrNo,ServiceName,ServicePrice;
        Button remove;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            SrNo = itemView.findViewById(R.id.tvSrNo);
            ServiceName = itemView.findViewById(R.id.tvServiceName);
            ServicePrice = itemView.findViewById(R.id.tvServicePrice);
            remove = itemView.findViewById(R.id.btnRemove);
            final CartAdapter adapter = new CartAdapter();
            remove.setOnClickListener(v -> {
                new Handler().post(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                    }
                });
            });


        }
    }
}
