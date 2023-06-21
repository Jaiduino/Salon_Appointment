package com.example.saloon_version_0.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.saloon_version_0.R;
import com.example.saloon_version_0.fragment.CartFragment;

public class SampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
    }

    public void goCart(View view)
    {
//        startActivity(new Intent(SampleActivity.this, CartFragment.class));
        Intent intent = new Intent(this,CartFragment.class);
        startActivity(intent);


    }
}