package com.example.saloon_version_0.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saloon_version_0.R;
import com.example.saloon_version_0.pojo.Appointements;

import java.util.List;

public class AppointementAdapter extends RecyclerView.Adapter<AppointementAdapter.ViewHolder> {

    public Context context;
    public Appointements[] appointementsList;

    public AppointementAdapter(Context context, Appointements[] appointementsList)
    {
        this.context = context;
        this.appointementsList = appointementsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_appointement,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        holder.txtAppointement.setText(itemList.get(position));
    }

    @Override
    public int getItemCount() {
        return appointementsList.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView    txtAppointement;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
