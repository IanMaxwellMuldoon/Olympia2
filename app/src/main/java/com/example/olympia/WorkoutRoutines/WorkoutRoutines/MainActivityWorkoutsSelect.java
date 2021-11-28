package com.example.olympia.WorkoutRoutines.WorkoutRoutines;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.olympia.R;
import android.content.Intent;

import android.view.View;
import android.widget.Button;

public class MainActivityWorkoutsSelect extends AppCompatActivity {
    private Button button;
    private Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_workouts_select);

        button = (Button) findViewById(R.id.button10);
        button2 = (Button) findViewById(R.id.button15);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openChestActivity();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLegActivity();
            }
        });
    }
    public void openChestActivity() {
        Intent intent = new Intent(this, ChestWorkout.class);
        startActivity(intent);
    }

    public void openLegActivity(){
        Intent intent = new Intent (this, LegWorkout.class);
        startActivity(intent);
    }
}