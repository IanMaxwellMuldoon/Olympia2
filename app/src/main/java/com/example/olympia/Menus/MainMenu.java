package com.example.olympia.Menus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.olympia.CalorieCounter.CalorieMenu;
import com.example.olympia.Exercises.PlanMenu;
import com.example.olympia.R;
import com.example.olympia.ViewHistory.ViewHistoryActivity;
import com.example.olympia.WorkoutRoutines.WorkoutRoutines.MainActivityWorkoutsSelect;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Button startWorkout = (Button)findViewById(R.id.startWorkout);
        startWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, PlanMenu.class);
                startActivity(intent);
            }
        });

        Button logFood = (Button)findViewById(R.id.logFood);
        logFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, CalorieMenu.class);
                startActivity(intent);
            }
        });

        Button tutorialWorkouts = (Button)findViewById(R.id.tutorialWorkouts);
        tutorialWorkouts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenu.this, MainActivityWorkoutsSelect.class);
                startActivity(intent);
            }
        });

        Button viewHistoryButton = (Button)findViewById(R.id.idViewHistoryButton);
        viewHistoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, ViewHistoryActivity.class);
                startActivity(intent);
            }
        });
    }
}