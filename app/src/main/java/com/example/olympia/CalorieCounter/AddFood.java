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

        TextView addFood = (TextView) findViewById(R.id.addFoodTitle);
        addFood.setText("Add Food");
    }
}