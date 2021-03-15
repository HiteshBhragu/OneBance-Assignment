package com.hitesh.onebanceassignment.Adapters;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hitesh.onebanceassignment.Data.DishData;
import com.hitesh.onebanceassignment.R;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;



public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.MyViewHolder> {

    private List<DishData> orderData;
    private Context context;

    public OrderAdapter(List<DishData> data, Context context) {
        this.orderData = data;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_layout, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.name.setText(orderData.get(position).getFoodName());
        holder.price.setText("₹ "+orderData.get(position).getPrice());
        holder.quan.setText(String.valueOf(orderData.get(position).getCount()));
        Resources res = context.getResources();
        int resID = res.getIdentifier(orderData.get(position).getImageName() , "drawable", context.getPackageName());
        holder.image.setImageResource(resID);
    }

    @Override
    public int getItemCount() {
        return orderData.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name, price, quan;

        public MyViewHolder(View itemView) {
            super(itemView);
            //title = itemView.findViewById(R.id.lat);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            quan = itemView.findViewById(R.id.txtQuan);
        }
    }
}
