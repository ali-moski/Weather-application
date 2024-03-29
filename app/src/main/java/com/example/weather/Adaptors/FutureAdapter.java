package com.example.weather.Adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.weather.Domains.FutureDomain;
import com.example.weather.Domains.Hourly;
import com.example.weather.R;

import java.util.ArrayList;

public class FutureAdapter extends RecyclerView.Adapter<FutureAdapter.viewHourly> {
    ArrayList<FutureDomain> items;
    Context context;

    public FutureAdapter(ArrayList<FutureDomain> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public FutureAdapter.viewHourly onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_futere,parent,false);
        context= parent.getContext();
        return new viewHourly(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull FutureAdapter.viewHourly holder, int position) {

holder.dayTxt.setText(items.get(position).getDay());
holder.statusTxt.setText(items.get(position).getStatus());
holder.highTxt.setText(items.get(position).getHighTemp()+"°");
holder.lowTxt.setText(items.get(position).getLoeTemp()+"");

int drawableResourceId=holder.itemView.getResources()
      .getIdentifier(items.get(position).getPicPath(),"drawable",holder.itemView.getContext().getPackageName());

        Glide.with(context)
                .load(drawableResourceId)
                .into(holder.pic);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class viewHourly extends RecyclerView.ViewHolder{
        TextView dayTxt,statusTxt,lowTxt,highTxt;

            ImageView pic;
        public viewHourly(@NonNull View itemView) {
            super(itemView);

            dayTxt=itemView.findViewById(R.id.dayTxt);
            statusTxt=itemView.findViewById(R.id.statusTxt);
            lowTxt=itemView.findViewById(R.id.lowTxt);
            highTxt=itemView.findViewById(R.id.highTxt);
            pic=itemView.findViewById(R.id.pic);

        }
    }
}