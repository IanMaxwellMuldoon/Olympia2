package com.example.olympia.Exercises;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.olympia.R;

public class NewPlan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_plan);

        TextView newPlanText = (TextView) findViewById(R.id.newPlanText);

    }
}