package com.example.saloon_version_0.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.saloon_version_0.fragment.CartFragment;
import com.example.saloon_version_0.fragment.HomeFragment;
import com.example.saloon_version_0.fragment.ProfileFragment;

public class FragmentAdapter extends FragmentStateAdapter  {
    public FragmentAdapter(@NonNull FragmentActivity fragmentActivity)
    {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new ProfileFragment();
            case 2:
                return new CartFragment();
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
