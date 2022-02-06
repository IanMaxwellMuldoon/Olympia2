package com.example.olympia.CalorieCounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.olympia.R;

public class AddFood extends AppCompatActivity {
    private int num = 1;
    private FoodItem selectedFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);
        String[] data = {"1","2","3","4","5","6"};

        TextView dropdownNum = (TextView)findViewById(R.id.iddropNum);
        TextView FoodLabel = (TextView) findViewById(R.id.FoodLabel);
        TextView Calories = (TextView) findViewById(R.id.CalorieNumID);
        TextView Protein = (TextView) findViewById(R.id.ProteinNumID);
        TextView Cholesterol = (TextView) findViewById(R.id.ChoNumID);
        TextView Fiber = (TextView) findViewById(R.id.FibNumID);
        Spinner dropdown = findViewById(R.id.idSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, data);
        dropdown.setAdapter(adapter);

        selectedFood = new FoodItem();
        selectedFood = ResultList.selectedFood;


        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedFood = ResultList.selectedFood;
                String servingNum = dropdown.getSelectedItem().toString();
                num = Integer.parseInt(servingNum);
                selectedFood = new FoodItem(selectedFood,num);
                Calories.setText(""+selectedFood.getCalories() + " kcal");
                Protein.setText(""+selectedFood.getProtein() + " g");
                Cholesterol.setText(""+selectedFood.getCholesterol()+" g");
                Fiber.setText(""+selectedFood.getFiber()+" g");
                dropdownNum.setText(""+num);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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