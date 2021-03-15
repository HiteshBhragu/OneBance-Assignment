package com.hitesh.onebanceassignment.Adapters;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hitesh.onebanceassignment.Data.DishData;
import com.hitesh.onebanceassignment.Activities.HomeActivity;
import com.hitesh.onebanceassignment.R;

import java.util.List;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


public class CuisineItemAdapter extends RecyclerView.Adapter<CuisineItemAdapter.MyViewHolder> {

    private List<DishData> orderData;
    private Context context;

    public CuisineItemAdapter(List<DishData> data, Context context) {
        this.orderData = data;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);

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

        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.add.setVisibility(View.GONE);
                holder.multi.setVisibility(View.VISIBLE);
                HomeActivity.orderData.add(new DishData(orderData.get(position).getFoodName(), orderData.get(position).getImageName()
                        , orderData.get(position).getPrice(),1));
                holder.count.setText("1");
            }
        });
        holder.txtAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.add.setVisibility(View.GONE);
                holder.multi.setVisibility(View.VISIBLE);
                HomeActivity.orderData.add(new DishData(orderData.get(position).getFoodName(), orderData.get(position).getImageName()
                        , orderData.get(position).getPrice(),1));
                holder.count.setText("1");
            }
        });

        holder.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = holder.count.getText().toString();
                int i = Integer.parseInt(s);
                i++;
                holder.count.setText(String.valueOf(i));
                for (DishData d:HomeActivity.orderData) {
                    if(d.getFoodName().equals(orderData.get(position).getFoodName()))
                        d.increCount();
                }
            }
        });
        holder.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.count.getText().toString().equals("0") || holder.count.getText().toString().equals(""))
                    return;

                for (int j = 0; j < HomeActivity.orderData.size(); j++) {
                    if (HomeActivity.orderData.get(j).getFoodName().equals(orderData.get(position).getFoodName()))
                        if (HomeActivity.orderData.get(j).getCount() == 1) {
                            HomeActivity.orderData.remove(j);
                            holder.add.setVisibility(View.VISIBLE);
                            holder.multi.setVisibility(View.GONE);
                            holder.count.setText("0");
                        } else
                            HomeActivity.orderData.get(j).dcreCount();
                    }

                String s = holder.count.getText().toString();
                int i = Integer.parseInt(s);
                i--;
                holder.count.setText(String.valueOf(i));
            }
        });
    }

    @Override
    public int getItemCount() {
        return orderData.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name, price, quan, minus, plus, count, txtAdd;
        CardView add, multi;
        public MyViewHolder(View itemView) {
            super(itemView);
            //title = itemView.findViewById(R.id.lat);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            quan = itemView.findViewById(R.id.txtQuan);
            add = itemView.findViewById(R.id.addCardView);
            multi = itemView.findViewById(R.id.ll_addQuan);
            minus = itemView.findViewById(R.id.minus);
            plus = itemView.findViewById(R.id.plus);
            count = itemView.findViewById(R.id.txtQuan);
            txtAdd = itemView.findViewById(R.id.txtAdd);
        }
    }
}
