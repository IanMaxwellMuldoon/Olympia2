package com.example.olympia.WorkoutRoutines.WorkoutRoutines;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.olympia.R;

public class Select_tutorial extends AppCompatActivity {
    private Button chestButton;
    private Button squatButton;
    private Button deadliftButton;
    private Button shoulderPressButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_tutorial);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("YouTube Tutorials");

        chestButton = (Button) findViewById(R.id.button10);
        squatButton = (Button) findViewById(R.id.button12);
        deadliftButton = (Button) findViewById(R.id.button13);
        shoulderPressButton = (Button) findViewById(R.id.button14);

        chestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChestTutorial();
            }
        });
        squatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSquatTutorial();
            }
        });
        deadliftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDeadliftTutorial();
            }
        });

        shoulderPressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openShoulderPressTutorial();
            }
        });
    }
    public void openChestTutorial() {
        Intent intent = new Intent(this, YouTubeLinks.class);
        startActivity(intent);
    }
    public void openSquatTutorial() {
        Intent intent = new Intent(this, Squat_tutorial.class);
        startActivity(intent);
    }
    public void openDeadliftTutorial(){
        Intent intent = new Intent(this, Deadlift_tutorial.class);
        startActivity(intent);
    }

    public void openShoulderPressTutorial() {
        Intent intent = new Intent(this, ShoulderPress_tutorial.class);
        startActivity(intent);
    }
}