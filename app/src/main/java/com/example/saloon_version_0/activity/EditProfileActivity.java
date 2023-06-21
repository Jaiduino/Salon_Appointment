package com.example.saloon_version_0.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.saloon_version_0.R;
import com.example.saloon_version_0.fragment.ProfileFragment;

public class EditProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        getSupportActionBar().setTitle("Back");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void updateProfile (View view)
    {
        startActivity(new Intent(this, ProfileFragment.class));
    }

    public void cancel (View view)
    {
        startActivity(new Intent(this, Home_Page_Activity.class));
    }

}