package com.hitesh.onebanceassignment.Adapters;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hitesh.onebanceassignment.Activities.CategorizeDishes;
import com.hitesh.onebanceassignment.Data.CategoryData;
import com.hitesh.onebanceassignment.R;

import java.util.List;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {

    private List<CategoryData> categoryData;
    private Context context;

    public CategoryAdapter(List<CategoryData> data, Context context) {
        this.categoryData = data;
        this.context = context;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_layout, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        position = position % categoryData.size();

        holder.name.setText(categoryData.get(position).getCuisineName());
        Resources res = context.getResources();
        int resID = res.getIdentifier(categoryData.get(position).getImageName() , "drawable", context.getPackageName());
        holder.image.setImageResource(resID);
        int finalPosition = position;
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(context, CategorizeDishes.class);
                intent.putExtra("cuisine", categoryData.get(finalPosition).getCuisineName());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name;
        CardView cardView;
        public MyViewHolder(View itemView) {
            super(itemView);
            //title = itemView.findViewById(R.id.lat);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            cardView = itemView.findViewById(R.id.cardview);


        }
    }
}
