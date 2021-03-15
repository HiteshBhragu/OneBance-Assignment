package com.hitesh.onebanceassignment.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.hitesh.onebanceassignment.Adapters.CategoryAdapter;
import com.hitesh.onebanceassignment.Data.CategoryData;
import com.hitesh.onebanceassignment.Data.DishData;
import com.hitesh.onebanceassignment.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    public static List<DishData> orderData = new ArrayList<>();
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private CategoryAdapter adapter;
    private List<CategoryData> data;
    private TextView c1, c2, c3;
    private CardView add1, multi1, add2, add3, multi2, multi3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);

        data = new ArrayList<>();

        data.add(new CategoryData(getString(R.string.north_indian), "northindian"));
        data.add(new CategoryData(getString(R.string.south_indian), "southindian"));
        data.add(new CategoryData(getString(R.string.chinese), "chinese"));
        data.add(new CategoryData(getString(R.string.mexican), "mexican"));
        data.add(new CategoryData(getString(R.string.italian), "italian"));

        adapter = new CategoryAdapter(data, this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        recyclerView.setHasFixedSize(true);
        recyclerView.scrollToPosition(20);

        c1 = findViewById(R.id.txtQuan1);
        c2 = findViewById(R.id.txtQuan2);
        c3 = findViewById(R.id.txtQuan3);

        multi1 = findViewById(R.id.ll_addQuan1);
        multi2 = findViewById(R.id.ll_addQuan2);
        multi3 = findViewById(R.id.ll_addQuan3);
        add1 = findViewById(R.id.addCardView1);
        add2 = findViewById(R.id.addCardView2);
        add3 = findViewById(R.id.addCardView3);

    }


    public void onClick(View view) {
        String s;
        int i;
        switch (view.getId())
        {
            case R.id.plus1:

                s = c1.getText().toString();
                i = Integer.parseInt(s);
                i++;
                c1.setText(String.valueOf(i));
                for (DishData d:orderData) {
                    if(d.getFoodName().equals("Veg Noodles"))
                        d.increCount();
                }

                break;

            case R.id.plus2:

                s = c2.getText().toString();
                i = Integer.parseInt(s);
                i++;
                c2.setText(String.valueOf(i));
                for (DishData d:orderData) {
                    if(d.getFoodName().equals("Pizza"))
                        d.increCount();
                }

                break;

            case R.id.plus3:

                s = c3.getText().toString();
                i = Integer.parseInt(s);
                i++;
                c3.setText(String.valueOf(i));
                for (DishData d:orderData) {
                    if(d.getFoodName().equals("Masala Dhosa"))
                        d.increCount();
                }

                break;

            case R.id.minus1:

                if(c1.getText().toString().equals("0") || c1.getText().toString().equals(""))
                    return;

                for (int j = 0; j < orderData.size(); j++) {
                    if(orderData.get(j).getFoodName().equals("Veg Noodles"))
                        if(orderData.get(j).getCount() == 1) {
                            orderData.remove(j);
                            add1.setVisibility(View.VISIBLE);
                            multi1.setVisibility(View.GONE);
                        }
                        else
                            orderData.get(j).dcreCount();
                }
                s = c1.getText().toString();
                i = Integer.parseInt(s);
                i--;
                c1.setText(String.valueOf(i));

                break;

            case R.id.minus2:

                if(c2.getText().toString().equals("0") || c2.getText().toString().equals(""))
                    return;
                for (int j = 0; j < orderData.size(); j++) {
                    if(orderData.get(j).getFoodName().equals("Pizza"))
                        if(orderData.get(j).getCount() == 1) {
                            orderData.remove(j);
                            add2.setVisibility(View.VISIBLE);
                            multi2.setVisibility(View.GONE);
                        }
                        else
                            orderData.get(j).dcreCount();
                }
                s = c2.getText().toString();
                i = Integer.parseInt(s);
                i--;
                c2.setText(String.valueOf(i));

                break;

            case R.id.minus3:

                if(c3.getText().toString().equals("0") || c3.getText().toString().equals(""))
                    return;

                for (int j = 0; j < orderData.size(); j++) {
                    if(orderData.get(j).getFoodName().equals("Masala Dhosa")) {
                        if (orderData.get(j).getCount() == 1)
                            orderData.remove(j);
                        add3.setVisibility(View.VISIBLE);
                        multi3.setVisibility(View.GONE);
                    }
                        else
                            orderData.get(j).dcreCount();
                }
                s = c3.getText().toString();
                i = Integer.parseInt(s);
                i--;
                c3.setText(String.valueOf(i));

                break;

            case R.id.cart:
                startActivity(new Intent(HomeActivity.this, CartActivity.class));
                break;

            case R.id.addCardView1:
                add1.setVisibility(View.GONE);
                multi1.setVisibility(View.VISIBLE);
                c1.setText("1");
                orderData.add(new DishData("Veg Noodles", "noodles", "100",1));
                break;

            case R.id.addCardView2:
                add2.setVisibility(View.GONE);
                multi2.setVisibility(View.VISIBLE);
                c2.setText("1");
                orderData.add(new DishData("Pizza", "pizza", "200",1));
                break;

            case R.id.addCardView3:
                add3.setVisibility(View.GONE);
                multi3.setVisibility(View.VISIBLE);
                c3.setText("1");
                orderData.add(new DishData("Masala Dhosa", "dhosa", "150",1));
                break;
        }
    }

    public void changeLanguage(View view) {
        final String[] list = {"English", "Hindi"};
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(HomeActivity.this);
        mBuilder.setTitle("Choose Language");
        mBuilder.setSingleChoiceItems(list, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(i == 0)
                {
                    setLocale("en");
                    recreate();
                }else if(i == 1)
                {
                    setLocale("hi");
                    recreate();
                }
            }
        });
        AlertDialog mDialoge = mBuilder.create();
        mDialoge.show();
    }

    private void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());

    }
}