package com.example.saloon_version_0.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.saloon_version_0.BaseUrl.Constant;
import com.example.saloon_version_0.R;
import com.example.saloon_version_0.adapter.AddCartInterface;
import com.example.saloon_version_0.adapter.ServicesListAdapter;
import com.example.saloon_version_0.backendservices.MensServices;
import com.example.saloon_version_0.fragment.CartFragment;
import com.example.saloon_version_0.pojo.Products;
import com.example.saloon_version_0.pojo.ServicesList;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AMaleActivity extends AppCompatActivity implements AddCartInterface {

        List<Products> productsList = new ArrayList<>();

         LinearLayout linearLayout;
         ServicesListAdapter adapter;

        RecyclerView recyclerView;

        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_amale);
            linearLayout = findViewById(R.id.linear_layout);

            getSupportActionBar().setTitle("Back");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            adapter = new ServicesListAdapter( this, productsList);
//            GoToCart = findViewById(R.id.btnGoToCart);
//            GoToCart.setOnClickListener(new View.OnClickListener()
//            {
//                @Override
//                public void onClick(View v)
//                {
//                    Fragment fragment = new CartFragment();
//                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//                    fragmentTransaction.replace(R.id.btnGoToCart,fragment).commit();
//                }
//            });

            recyclerView = findViewById(R.id.recyclerView);
//            serviceList = new ServicesList[]
//                    {
//                            new ServicesList("Change Of Styling","600"),
//                            new ServicesList("Hair Spa","400"),
//                            new ServicesList("Hair Cutting","500"),
//                            new ServicesList("Hair Style","700")
//
//                    };
            getmenshairstyles();
           // ServicesListAdapter serviceAdapter = new ServicesListAdapter(this, productsList);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void getmenshairstyles() {
        Log.e("productList","mens hair and spa idhar aya");
      new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
              .baseUrl(Constant.BASE_URL).build().create(MensServices.class).getservices("A")
              .enqueue(new Callback<JsonObject>() {
                  @Override
                  public void onResponse(Call<JsonObject> call, Response<JsonObject> response) { JsonArray jsonArray;
                      if (response.isSuccessful() && response.body() != null) {
                           jsonArray = response.body().getAsJsonArray("data");
                          Log.e("productList",""+response.body());

                          if(jsonArray.size()>0){
                              for(int i = 0;i< jsonArray.size();i++){

                                  JsonObject object = jsonArray.get(i).getAsJsonObject();
                                  Products products = new Products();
                                  products.setProduct_Id(object.get("product_Id").getAsString());
                                  products.setProduct_Name(object.get("product_Name").getAsString());
                                  products.setDescription(object.get("description").getAsString());
                                  products.setGender(object.get("gender").getAsString());
                                  products.setPrice(object.get("price").getAsDouble());
                                  productsList.add(products);
                              }
                              adapter.notifyDataSetChanged();
                          }
                         
                          // Proceed with using the jsonArray
                      } else {
                          Log.e("productList","null");
                          // Handle the case when the response is not successful or the body is null
                      }
                  }

                  @Override
                  public void onFailure(Call<JsonObject> call, Throwable t) {

                  }
              });
    }


    public void goToCart(View view)
    {
        //startActivity(new Intent(AMaleActivity.this,CartFragment.class));
        Fragment fragment = new CartFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.constraint,fragment).commit();
    }

    @Override
    public void addProducts(List<Products> pList) {
        
    }
}