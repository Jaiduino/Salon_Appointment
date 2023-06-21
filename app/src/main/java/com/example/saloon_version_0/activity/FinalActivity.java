package com.example.saloon_version_0.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.saloon_version_0.R;

public class FinalActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        getSupportActionBar().setTitle("Back");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void continueExploring (View view)
    {
        startActivity(new Intent(this,Home_Page_Activity.class));
    }

    public void submit (View view)
    {
        startActivity(new Intent(this,Home_Page_Activity.class));
    }
}