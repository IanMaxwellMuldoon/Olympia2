package com.example.olympia.CalorieCounter.FoodDetails;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.olympia.CalorieCounter.FoodItem;
import com.example.olympia.R;

import org.w3c.dom.Text;


public class FoodDetailAdapter extends ArrayAdapter {
    private String[] foodDesc;
    private FoodItem foodItem;

    public FoodDetailAdapter(@NonNull Context context, int resource, String[] foodDesc) {
        super(context, resource, foodDesc);
        this.foodDesc = foodDesc;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        int phraseIndex = position;
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.food_detail_item, parent, false);
        }
        TextView nutrient = convertView.findViewById(R.id.nutrientid);
        TextView amount = convertView.findViewById(R.id.amountid);

        return convertView;
    }
}
