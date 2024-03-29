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
import com.example.weather.Domains.Hourly;
import com.example.weather.R;

import java.util.ArrayList;

public class HourlyAdapters extends RecyclerView.Adapter<HourlyAdapters.viewHourly> {
    ArrayList<Hourly> items;
    Context context;

    public HourlyAdapters(ArrayList<Hourly> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public HourlyAdapters.viewHourly onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_hourly,parent,false);
        context= parent.getContext();
        return new viewHourly(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull HourlyAdapters.viewHourly holder, int position) {
holder.hourTxt.setText(items.get(position).getHour());
holder.tempTxt.setText(items.get(position).getTemp()+"°");

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
        TextView hourTxt,tempTxt;
            ImageView pic;
        public viewHourly(@NonNull View itemView) {
            super(itemView);

            hourTxt=itemView.findViewById(R.id.hourTxt);
            tempTxt=itemView.findViewById(R.id.tempTxt);
            pic=itemView.findViewById(R.id.pic);

        }
    }
}
