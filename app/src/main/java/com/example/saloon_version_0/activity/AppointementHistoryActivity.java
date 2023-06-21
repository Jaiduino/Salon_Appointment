package com.example.saloon_version_0.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.saloon_version_0.R;
import com.example.saloon_version_0.adapter.AppointementAdapter;
import com.example.saloon_version_0.pojo.Appointements;
import com.example.saloon_version_0.pojo.ServicesList;

import java.util.ArrayList;
import java.util.List;

public class AppointementHistoryActivity extends AppCompatActivity
{
    Appointements[] appointementsList;

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointement_history);

        getSupportActionBar().setTitle("Back");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView = findViewById(R.id.recyclerView);
        appointementsList = new Appointements[]
                {
                        new Appointements("Hair Spa","24.02.2023","400"),
                        new Appointements("Hair Cutting","25.02.2023","500"),
                        new Appointements("Hair Style","26.02.2023,","700")

                };

        AppointementAdapter cartListAdapter = new AppointementAdapter(this,appointementsList);
        recyclerView.setAdapter(cartListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}