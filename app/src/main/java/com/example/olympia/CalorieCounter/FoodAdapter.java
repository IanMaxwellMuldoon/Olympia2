package com.example.olympia.CalorieCounter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.olympia.R;

import java.util.ArrayList;

public class FoodAdapter extends ArrayAdapter<foodItem> {
    private ArrayList<foodItem> foodList;

    public FoodAdapter(@NonNull Context context, int resource, ArrayList<foodItem> foodList) {
        super(context, resource, foodList);
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        int phraseIndex = position;
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.fooditem, parent, false);
        }
        TextView titleTextView = convertView.findViewById(R.id.Title_textview);

        TextView subTitleTextView = convertView.findViewById(R.id.SubTitle_textview);

        titleTextView.setText(foodList.get(position).getLabel());

        subTitleTextView.setText((foodList.get(position).getSubTitle()));
        return convertView;
    }

}
