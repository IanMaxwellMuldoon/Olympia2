package com.example.olympia.Exercises;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.olympia.R;

public class NewPlan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_plan);

        TextView newPlanText = (TextView) findViewById(R.id.newPlanText);
        newPlanText.setText("New Plan");

        Button PullExercisesButton = (Button) findViewById(R.id.PullExercisesButton);

        PullExercisesButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewPlan .this, PullExercises.class);
                startActivity(intent);
            }
        });
    }
}