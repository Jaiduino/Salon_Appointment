package com.example.saloon_version_0.backendservices;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MensServices {
    @GET("Products_Category/{product_Id}")
    public Call<JsonObject> getservices(@Path("product_Id") String product_Id);
}
