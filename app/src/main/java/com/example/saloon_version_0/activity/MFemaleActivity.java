package com.example.saloon_version_0.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.saloon_version_0.R;
import com.example.saloon_version_0.adapter.ServicesListAdapter;
import com.example.saloon_version_0.fragment.CartFragment;
import com.example.saloon_version_0.pojo.ServicesList;

public class MFemaleActivity extends AppCompatActivity {



    ServicesList[] serviceList;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mfemale);
        getSupportActionBar().setTitle("Back");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.recyclerView);

        serviceList = new ServicesList[]
                {
                        new ServicesList("Change Of Styling","600"),
                        new ServicesList("Hair Spa","400"),
                        new ServicesList("Hair Cutting","500"),
                        new ServicesList("Hair Style","700")

                };
      //  ServicesListAdapter serviceAdapter = new ServicesListAdapter(this, serviceList);
       // recyclerView.setAdapter(serviceAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    public void goToCart(View view)
    {
        //startActivity(new Intent(AMaleActivity.this,CartFragment.class));
        Fragment fragment = new CartFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.constraint,fragment).commit();
    }
}