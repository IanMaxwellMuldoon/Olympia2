package com.example.olympia.CalorieCounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.olympia.MainActivity;
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

        ImageButton checkButton = findViewById(R.id.idDoneButton);
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //This is where we add selectedFood to the Database
                Toast.makeText(AddFood.this, "FOOD ADDED", Toast.LENGTH_SHORT).show();
            }
        });


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