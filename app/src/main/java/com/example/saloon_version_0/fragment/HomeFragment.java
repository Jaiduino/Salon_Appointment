package com.example.saloon_version_0.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.saloon_version_0.R;
import com.example.saloon_version_0.activity.FemaleServiceActivity;
import com.example.saloon_version_0.activity.MaleServiceActivity;

import java.util.ArrayList;
import java.util.Objects;

public class HomeFragment extends Fragment
{
    private CardView cardView1,cardView2;

    ImageSlider imageSlider;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        imageSlider = view.findViewById(R.id.imageSlider);
        ArrayList<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.male, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.female, ScaleTypes.FIT));

        imageSlider.setImageList(slideModels,ScaleTypes.FIT);

        cardView1 = view.findViewById(R.id.cardView1);
        cardView1.setOnClickListener((v ->
        {
            Intent intent = new Intent(getActivity(), MaleServiceActivity.class);
            startActivity(intent);
        }));

        cardView2 = view.findViewById(R.id.cardView2);
        cardView2.setOnClickListener((v ->
        {
            Intent intent = new Intent(getActivity(), FemaleServiceActivity.class);
            startActivity(intent);
        }));
        return view;
    }



}