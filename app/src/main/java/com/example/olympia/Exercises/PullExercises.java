package com.example.olympia.Exercises;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.olympia.R;

public class PullExercises extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_exercises);

        TextView Exercises = (TextView) findViewById(R.id.Exercises);
        Exercises.setText("Exercises");

        Button AddExerciseButton = (Button) findViewById(R.id.AddExerciseButton);

        AddExerciseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PullExercises.this, AddExercises.class);
                startActivity(intent);
            }
        });
    }
}