package com.example.saloon_version_0.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.saloon_version_0.BaseUrl.Constant;
import com.example.saloon_version_0.R;
import com.example.saloon_version_0.backendservices.CustomerService;
import com.example.saloon_version_0.entity.Credentials;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {
    EditText editEmail, editPassword;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPasword);
        checkBox = findViewById(R.id.checkBox);
    }

    public void login(View view) {

        // Credentials cus = validateData();
       // Log.e("test", "Inside loginin" + cus);
        // if (cus != null) {
        //    CheckCredentials(cus);
       // Log.e("test", "Inside signin" + cus);

        startActivity(new Intent(LoginActivity.this, Home_Page_Activity.class));

    }


    public void CheckCredentials(Credentials cus) {
        Log.e("test", "Inside Check" + cus);
        new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constant.BASE_URL)
                .build()
                .create(CustomerService.class)
                .login(cus.getEmail_id(), cus.getPassword())
                .enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        Log.e("test", "Inside Check on responce" + cus);
                        JsonObject json = response.body().getAsJsonObject("data");

                        JsonObject jsonObject;
                        //Toast.makeText(LoginActivity.this, "array length = " + jsonArray.size(), Toast.LENGTH_SHORT).show();
                        if (json.size() > 0) {
                            // jsonObject = json.get(0).getAsJsonObject();
                            // int id = json.get("id").getAsInt();
                            //  JsonObject cu = jsonObject.getAsJsonObject();
                            //  Toast.makeText(LoginActivity.this, "user id = " + id, Toast.LENGTH_SHORT).show();
                            // Log.e("user","Recived JsonObject"+cu);
                            //add the userid inside the shared preferences
                            //  saveData(id);
                            startActivity(new Intent(LoginActivity.this, Home_Page_Activity.class));
                            finish();
                        }

                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, "Response failed", Toast.LENGTH_SHORT).show();

                    }
                });


    }
    public void register(View view)
    {
        startActivity(new Intent(LoginActivity.this, RegistrationActivity
                .class));
    }
    public Credentials validateData() {
        Credentials cus = new Credentials();
        cus.setEmail_id(editEmail.getText().toString());
        cus.setPassword(editPassword.getText().toString());
        Log.e("test","Inside validate "+cus);
        if (!cus.getEmail_id().equals(""))
            if (!cus.getPassword().equals("")) {
                Log.e("test","Done Login"+cus);
                return cus;
            }
            else
                Toast.makeText(this, "Password cannot be empty", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Email cannot be empty", Toast.LENGTH_SHORT).show();
        return null;
    }
    public void registration(View view) {
        startActivity(new Intent(this, RegistrationActivity.class));
    }
}