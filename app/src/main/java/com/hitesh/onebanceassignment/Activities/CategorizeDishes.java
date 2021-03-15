package com.hitesh.onebanceassignment.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.hitesh.onebanceassignment.Adapters.CuisineItemAdapter;
import com.hitesh.onebanceassignment.Data.DishData;
import com.hitesh.onebanceassignment.R;

import java.util.ArrayList;
import java.util.List;

public class CategorizeDishes extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private CuisineItemAdapter adapter;
    private List<DishData> data;
    private TextView title;
    private String cat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorize_dishes);
        title = findViewById(R.id.cati);
        cat = getIntent().getStringExtra("cuisine");
        title.setText(cat);
        layoutManager = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);

        data = new ArrayList<>();

        if(cat.equals(getString(R.string.north_indian)))
        {
            data.add(new DishData("Chole Bhature", "i1", "100",0));
            data.add(new DishData("Rogan Josh", "i2", "300",0));
            data.add(new DishData("Stuffed Bati", "i3", "120",0));
            data.add(new DishData("Malai ki Kheer", "i4", "250",0));
            data.add(new DishData("Chicken Dum Biryani", "i5", "500",0));
            data.add(new DishData("Aloo Samosa", "i6", "10",0));
            data.add(new DishData("Nihari Gosht", "i7", "180",0));
            data.add(new DishData("Butter Chicken", "i8", "3500",0));
            data.add(new DishData("Dahi Bhalla", "i9", "50",0));
        }
        else if(cat.equals(getString(R.string.south_indian)))
        {
            data.add(new DishData("Onion Rava Dosa", "i10", "50",0));
            data.add(new DishData("Buttermilk Sambar", "i11", "50",0));
            data.add(new DishData("Medu Vada", "i12", "50",0));
            data.add(new DishData("Ven Pongal", "i13", "50",0));
            data.add(new DishData("Uttapam", "i14", "50",0));
            data.add(new DishData("Rawa Upma", "i15", "50",0));
            data.add(new DishData("Puttu", "i16", "50",0));
            data.add(new DishData("Oats Idli", "i17", "50",0));
            data.add(new DishData("Oats Uttapam", "i18", "50",0));
            data.add(new DishData("Ragi Dosa", "i19", "50",0));

        }else if(cat.equals(getString(R.string.chinese))){
            data.add(new DishData("Hot N Sour Soup", "i20", "150",0));
            data.add(new DishData("Quick Noodles", "i21", "150",0));
            data.add(new DishData("Szechwan Chilli Chicken", "i22", "150",0));
            data.add(new DishData("Spring Rolls", "i23", "150",0));
            data.add(new DishData("Veg Hakka Noodles", "i24", "150",0));
            data.add(new DishData("Manchow Soup", "i25", "150",0));
            data.add(new DishData("Chilli Potato", "i26", "150",0));
        }else if(cat.equals(getString(R.string.mexican))){
            data.add(new DishData("Chicken Quesadillas", "i27", "150",0));
            data.add(new DishData("Do-it-yourself Tacos", "i28", "150",0));
            data.add(new DishData("Guacamole", "i29", "150",0));
            data.add(new DishData("Chilli Con Carne", "i30", "150",0));
            data.add(new DishData("Tomato Salsa", "i31", "150",0));
            data.add(new DishData("Enchiladas", "i32", "150",0));
            data.add(new DishData("Guilt Free Chilli", "i33", "150",0));

        }else if(cat.equals(getString(R.string.italian)))
        {
            data.add(new DishData("Panzenella", "i34", "180",0));
            data.add(new DishData("Bruschetta", "i35", "180",0));
            data.add(new DishData("Focaccia Bread", "i36", "180",0));
            data.add(new DishData("Pasta Carbonara", "i37", "180",0));
            data.add(new DishData("Margherita Pizza", "i38", "180",0));
            data.add(new DishData("Mushroom Risotto", "i39", "180",0));
            data.add(new DishData("Lasagna", "i40", "180",0));
            data.add(new DishData("Panettone", "i41", "180",0));
        }

        adapter = new CuisineItemAdapter(data, this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        recyclerView.setHasFixedSize(true);


    }

    public void closeActivity(View view) {
        finish();
    }

    public void onClick(View view) {
        startActivity(new Intent(CategorizeDishes.this, CartActivity.class));

    }
}