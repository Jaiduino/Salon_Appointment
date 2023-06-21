package com.example.saloon_version_0.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import com.example.saloon_version_0.R;
import com.example.saloon_version_0.activity.AppointementHistoryActivity;
import com.example.saloon_version_0.activity.EditProfileActivity;
import com.example.saloon_version_0.activity.Home_Page_Activity;

public class ProfileFragment extends Fragment
{
    Button btn1,btn2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState)
    {

        View view =  inflater.inflate(R.layout.fragment_profile, container, false);
        btn1 = view.findViewById(R.id.btnEdit);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), EditProfileActivity.class);
                startActivity(intent);
            }
        });



        btn2 = view.findViewById(R.id.btnHistory);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AppointementHistoryActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

}