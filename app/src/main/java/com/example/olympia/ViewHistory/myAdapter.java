package com.example.olympia.ViewHistory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import com.example.olympia.R;
import com.google.firebase.firestore.auth.User;

public class myAdapter extends RecyclerView.Adapter<myAdapter.MyViewHolder> {

    Context context;
    ArrayList<usersFoodlist> foodArrayList;

    public myAdapter(Context context, ArrayList<usersFoodlist> foodArrayList) {
        this.context = context;
        this.foodArrayList = foodArrayList;
    }

    @NonNull
    @Override
    public myAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.fooditems,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull myAdapter.MyViewHolder holder, int position) {

        usersFoodlist user = foodArrayList.get(position);

        holder.brand.setText(user.brand);
        holder.calories.setText(String.valueOf(user.calories));
        holder.cholesterol.setText(String.valueOf(user.cholesterol));
        holder.fat.setText(String.valueOf(user.fat));
        holder.fiber.setText(String.valueOf(user.fiber));
        holder.food.setText(user.label);
        holder.protein.setText(String.valueOf(user.protein));
        //holder.time.setText(user.time);

    }

    @Override
    public int getItemCount() {
        return foodArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView brand, calories, cholesterol, fat, fiber, food, protein, time;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            brand = itemView.findViewById(R.id.Brand);
            calories = itemView.findViewById(R.id.Calories);
            cholesterol = itemView.findViewById(R.id.Cholesterol);
            fat = itemView.findViewById(R.id.Fat);
            fiber = itemView.findViewById(R.id.Fiber);
            food = itemView.findViewById(R.id.Food);
            protein = itemView.findViewById(R.id.Protein);
            //time = itemView.findViewById(R.id.Time);
        }
    }
}
