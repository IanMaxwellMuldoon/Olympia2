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

        TextView FoodLabel = (TextView) findViewById(R.id.FoodLabel);
        TextView Calories = (TextView) findViewById(R.id.CalorieNumID);
        TextView Protein = (TextView) findViewById(R.id.ProteinNumID);
        TextView Cholesterol = (TextView) findViewById(R.id.ChoNumID);
        TextView Fiber = (TextView) findViewById(R.id.FibNumID);



        FoodItem selectedFood = new FoodItem();
        selectedFood = ResultList.selectedFood;

        String label = selectedFood.getLabel();
        FoodLabel.setText(""+label);
        int cal = selectedFood.getCalories();
        Calories.setText(""+cal);
        int pro = selectedFood.getProtein();
        Protein.setText(""+pro);
        int cho = selectedFood.getCholesterol();
        Cholesterol.setText(""+cho);
        int fib = (int)selectedFood.getFiber();
        Fiber.setText(""+fib);
    }
}