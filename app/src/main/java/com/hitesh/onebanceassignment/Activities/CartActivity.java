package com.hitesh.onebanceassignment.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.hitesh.onebanceassignment.Adapters.OrderAdapter;
import com.hitesh.onebanceassignment.Data.DishData;
import com.hitesh.onebanceassignment.R;

public class CartActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private OrderAdapter adapter;
    private TextView txtNetTotal, txtGst, txtGrandTotal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        layoutManager = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new OrderAdapter(HomeActivity.orderData, this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        recyclerView.setHasFixedSize(true);

        txtGrandTotal = findViewById(R.id.grand_total);
        txtGst = findViewById(R.id.gst);
        txtNetTotal = findViewById(R.id.net_total);

        int netTotal = 0, gst = 0;

        for (DishData d:
             HomeActivity.orderData) {
            netTotal += Integer.parseInt(d.getPrice()) * d.getCount();
        }
        gst = (netTotal * 5)/100;

        txtNetTotal.setText("₹ "+String.valueOf(netTotal));
        txtGst.setText("₹ "+String.valueOf(gst));
        txtGrandTotal.setText("₹ "+String.valueOf(netTotal+gst));

    }

    public void closeActivity(View view) {
        finish();
    }
}