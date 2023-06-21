package com.example.saloon_version_0.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

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

public class CMaleActivity extends AppCompatActivity {


    List<Products> productsList = new ArrayList<>();
    ServicesListAdapter serviceAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cmale);
        getSupportActionBar().setTitle("Back");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
  getdata();
        recyclerView = findViewById(R.id.recyclerView);


       serviceAdapter = new ServicesListAdapter( this, productsList);
        recyclerView.setAdapter(serviceAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    private void getdata() {
        Log.e("productList","idhar aya");
        new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constant.BASE_URL).build().create(MensServices.class).getservices("P")
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
                                serviceAdapter.notifyDataSetChanged();
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
}