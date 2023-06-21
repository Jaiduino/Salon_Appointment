package com.example.saloon_version_0.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.saloon_version_0.R;

public class FemaleServiceActivity extends AppCompatActivity implements View.OnClickListener{

    private CardView crd1,crd2,crd3,crd4,crd5,crd6,crd7,crd8,crd9,crd10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_female_service);

        getSupportActionBar().setTitle("Back");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        crd1 = (CardView) findViewById(R.id.crd_Service1);
        crd2 = (CardView) findViewById(R.id.crd_Service2);
        crd3 = (CardView) findViewById(R.id.crd_Service3);
        crd4 = (CardView) findViewById(R.id.crd_Service4);
        crd5 = (CardView) findViewById(R.id.crd_Service5);
        crd6 = (CardView) findViewById(R.id.crd_Service6);
        crd7 = (CardView) findViewById(R.id.crd_Service7);
        crd8 = (CardView) findViewById(R.id.crd_Service8);
        crd9 = (CardView) findViewById(R.id.crd_Service9);
        crd10 = (CardView) findViewById(R.id.crd_Service10);

        crd1.setOnClickListener((View.OnClickListener) this);
        crd2.setOnClickListener((View.OnClickListener) this);
        crd3.setOnClickListener((View.OnClickListener) this);
        crd4.setOnClickListener((View.OnClickListener) this);
        crd5.setOnClickListener((View.OnClickListener) this);
        crd6.setOnClickListener((View.OnClickListener) this);
        crd7.setOnClickListener((View.OnClickListener) this);
        crd8.setOnClickListener((View.OnClickListener) this);
        crd9.setOnClickListener((View.OnClickListener) this);
        crd10.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View view)
    {
        Intent intent;
        switch (view.getId())
        {
            case R.id.crd_Service1:
                intent = new Intent(this,LFemaleActivity.class);
                startActivity(intent);
                break;

            case R.id.crd_Service2:
                intent = new Intent(this,MFemaleActivity.class);
                startActivity(intent);
                break;

            case R.id.crd_Service3:
                intent = new Intent(this,NFemaleActivity.class);
                startActivity(intent);
                break;

            case R.id.crd_Service4:
                intent = new Intent(this,OFemaleActivity.class);
                startActivity(intent);
                break;

            case R.id.crd_Service5:
                intent = new Intent(this,PFemaleActivity.class);
                startActivity(intent);
                break;

            case R.id.crd_Service6:
                intent = new Intent(this,QFemaleActivity.class);
                startActivity(intent);
                break;

            case R.id.crd_Service7:
                intent = new Intent(this,RFemaleActivity.class);
                startActivity(intent);
                break;

            case R.id.crd_Service8:
                intent = new Intent(this,SFemaleActivity.class);
                startActivity(intent);
                break;

            case R.id.crd_Service9:
                intent = new Intent(this,TFemaleActivity.class);
                startActivity(intent);
                break;

            case R.id.crd_Service10:
                intent = new Intent(this,UFemaleActivity.class);
                startActivity(intent);
                break;
        }
    }
}