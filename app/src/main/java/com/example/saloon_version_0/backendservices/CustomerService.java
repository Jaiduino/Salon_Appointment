package com.example.saloon_version_0.backendservices;

import com.example.saloon_version_0.entity.Customer;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CustomerService {
    @POST("register")
    public Call<JsonObject> register(@Body Customer cus);
//    @POST("user")
//    public  Call<JsonObject> login(@Body Customer cus);
    @GET("customer/{email_Id}/{pass}")
    public  Call<JsonObject> login(@Path("email_Id") String email,@Path("pass") String password);
}
