package com.example.olympia.Exercises;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.olympia.R;

public class Exercises extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);

        TextView exercises = (TextView) findViewById(R.id.exercises);
        exercises.setText(" Exercises");

        Button newPlanButton = (Button) findViewById(R.id.newPlanButton);

        newPlanButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Exercises.this, NewPlan.class);
                startActivity(intent);
            }
        });


    }
}