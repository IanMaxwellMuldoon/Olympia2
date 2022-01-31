package com.example.olympia.CalorieCounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.olympia.R;

public class AddFood extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);

        TextView FoodTitle = (TextView) findViewById(R.id.addFoodTitle);
        TextView Calories = (TextView) findViewById(R.id.CalorieID);

        FoodItem selectedFood = new FoodItem();
        selectedFood = ResultList.selectedFood;

        int cal = selectedFood.getCalories();
        Calories.setText(""+cal);
    }
}