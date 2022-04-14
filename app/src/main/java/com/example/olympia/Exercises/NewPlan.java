package com.example.olympia.Exercises;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.olympia.R;

public class NewPlan extends AppCompatActivity  {
    Button addExerciseButton;
    Button doneButton;
    Exercise exercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_plan);

        //for toolbar

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        try {
            exercise = getIntent().getParcelableExtra("exerciseData");
        } catch (Exception e) {
            Log.d("error", "There was an issue getting exercise data");
            e.printStackTrace();
        }


        addExerciseButton = findViewById(R.id.idAddExerciseButton);
        addExerciseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewPlan.this, AddExercises.class);
                startActivity(intent);


            }
        });

        doneButton = findViewById(R.id.idDoneButton);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewPlan.this, PlanMenu.class);
                startActivity(intent);
            }
        });

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.idExerciseFragmentPH, ExerciseListFragment.class, null)
                    .commit();
        }
    }
    public Exercise getExercise() {
        return exercise;
    }


}