package com.example.olympia.Exercises;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import com.example.olympia.CalorieCounter.AddFood;
import com.example.olympia.CalorieCounter.FoodItem;
import com.example.olympia.R;

import java.util.ArrayList;

public class PlanMenu extends AppCompatActivity {
    public ArrayList<Plan> plans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_menu);

        //for toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button newPlanBtn = (Button)findViewById(R.id.idNewPlanBtn);


        newPlanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(PlanMenu.this, NewPlan.class);
            startActivity(intent);
            }
        });

        Button planButton = (Button)findViewById(R.id.idPlanButton);


       /* planButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlanMenu.this, CurrentPlan.class);
                startActivity(intent);

            }
        });*/


    }
}