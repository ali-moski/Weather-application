package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.weather.Adaptors.FutureAdapter;
import com.example.weather.Domains.FutureDomain;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    ImageView imageView3;
    private RecyclerView.Adapter adapterTommory;
    public RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        imageView3=findViewById(R.id.imageView3);
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        initRecyclerView();

    }
    private void initRecyclerView() {
        ArrayList<FutureDomain> items=new ArrayList<>();

        items.add(new FutureDomain("Sat","storm","storm",25,10));
        items.add(new FutureDomain("Sun","cloudy","cloudy",24,16));
        items.add(new FutureDomain("Mon","windy","windy",29,15));
        items.add(new FutureDomain("Tue","cloudy_sunny","Cloudy Sunny",22,13));
        items.add(new FutureDomain("Wen","sunny","sunny",28,11));
        items.add(new FutureDomain("Thu","rainy","Rainy",23,12));

        recyclerView=findViewById(R.id.view2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        adapterTommory=new FutureAdapter(items);
        recyclerView.setAdapter(adapterTommory);
    }
}