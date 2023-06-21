package com.example.saloon_version_0.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.saloon_version_0.BaseUrl.Constant;
import com.example.saloon_version_0.R;
import com.example.saloon_version_0.backendservices.CustomerService;
import com.example.saloon_version_0.entity.Customer;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegistrationActivity extends AppCompatActivity
{
    EditText editFullName, editEmailId, editGender, editBuilding_No, editAreaName, editPincode, editMobileNo, editPassword, editConfirmPassword;
    RadioGroup radioGenderGroup;
    RadioButton radioMaleButton,radioFemaleButton;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);



        radioGenderGroup = findViewById(R.id.radioGenderGroup);
        radioMaleButton = findViewById(R.id.radioMale);
        radioFemaleButton = findViewById(R.id.radioFemale);
        editFullName = findViewById(R.id.editFullName);
        editEmailId = findViewById(R.id.editEmail_Id);
        // editGender = findViewById(R.id.editGender);
        editBuilding_No = findViewById(R.id.editBuilding_No);
        editAreaName = findViewById(R.id.editStreet_Name);
        editPincode = findViewById(R.id.editPincode);
        editMobileNo = findViewById(R.id.editMobileNo);
        editPassword = findViewById(R.id.editPassword);
        editConfirmPassword = findViewById(R.id.editConfirmPassword);

    }
    public void register(View view)
    {
//        Customer cus = validateData();
//        if (cus != null)
//            registerCustomer(cus);
        startActivity(new Intent(RegistrationActivity.this,LoginActivity.class));
    }
    public void registerCustomer(Customer cus) {
        Log.e("tag", "register" + cus.getMobileNo());
        new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constant.BASE_URL)
                .build()
                .create(CustomerService.class)
                .register(cus)
                .enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        Toast.makeText(RegistrationActivity.this, "User Registerd Successfully", Toast.LENGTH_SHORT).show();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        Toast.makeText(RegistrationActivity.this, "User Registerd Failed!!!!", Toast.LENGTH_SHORT).show();

                    }
                });
    }
    public Customer validateData() {
        Customer cus = new Customer();
        cus.setFullName(editFullName.getText().toString());
        cus.setEmail_Id(editEmailId.getText().toString());
        cus.setMobileNo(editMobileNo.getText().toString());
        cus.setPassword(editPassword.getText().toString());
        cus.setAreaName(editAreaName.getText().toString());
        cus.setBuildingNo(editBuilding_No.getText().toString());
        // cus.setGender(editGender.getText().toString());
        cus.setPincode(Integer.parseInt(editPincode.getText().toString()));
        //String confirmPassword = editConfirmPassword.getText().toString();
        Log.e("tag", "" + cus.toString());
        if(radioFemaleButton.isChecked())
        {
            cus.setGender("Female");
        }
        else
        if(radioMaleButton.isChecked())
        {
            cus.setGender("Male");
        }
        return cus;
    }

    public void cancel(View view)
    {
        startActivity(new Intent(this,SplashActivity.class));
    }

}