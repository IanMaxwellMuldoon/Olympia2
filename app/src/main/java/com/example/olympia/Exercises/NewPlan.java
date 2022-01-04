package com.example.olympia.Exercises;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;


import com.example.olympia.R;

import java.util.ArrayList;

public class NewPlan extends AppCompatActivity {
    Plan pullExercises = new Plan("Pull Exercises", null);
    Plan pushExercises = new Plan("Push Exercises", null);
    Plan Legs = new Plan("Legs", null);
    Plan Abs = new Plan("Abs", null);
    Plan Cardio = new Plan("Cardio", null);
    ArrayList<Plan> initialPList = new ArrayList<Plan>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_plan);

        initialPList.add(pullExercises);
        initialPList.add(pushExercises);
        initialPList.add(Legs);
        initialPList.add(Abs);
        initialPList.add(Cardio);


    }
}