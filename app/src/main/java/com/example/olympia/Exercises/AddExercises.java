package com.example.olympia.Exercises;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.olympia.R;

import java.util.ArrayList;

public class AddExercises extends AppCompatActivity {
    private EditText exerciseName;
    private EditText numOfSets;
    private EditText numOfReps;
    private EditText weight;
    private Button saveExercise;
    private String name;
    private int numSets;
    private int numReps;
    private int lbs;
    private NewPlan newPlan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exercises);

        // Get data from WorkoutPlanList
        Intent intent = getIntent();
        String exerName = intent.getStringExtra("exerciseName");

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        exerciseName = findViewById(R.id.idExerciseName);

        // If intent came from adding a default exercise then set exercise name field
        if (exerName != null) {
            exerciseName.setText(exerName);
        }

        exerciseName.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {


                    exerciseName.clearFocus();
                    exerciseName.requestFocus(exerciseName.FOCUS_DOWN);


                }
                return false;
            }
        });

        numOfSets = findViewById(R.id.idNumOfSets);
        numOfSets.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    numOfSets.clearFocus();
                    numOfSets.requestFocus(numOfSets.FOCUS_DOWN);


                }
                return false;
            }
        });

        numOfReps = findViewById(R.id.idNumOfReps);
        numOfReps.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    numOfReps.clearFocus();
                    numOfReps.requestFocus(numOfReps.FOCUS_DOWN);


                }
                return false;
            }
        });

        weight = findViewById(R.id.idWeight);
        weight.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    weight.clearFocus();
                    weight.requestFocus(weight.FOCUS_DOWN);


                }
                return false;
            }
        });

        saveExercise = findViewById(R.id.idSaveExercise);
        saveExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (!TextUtils.isEmpty(exerciseName.getText().toString())) {
                    name = exerciseName.getText().toString();

                } else {
                    Toast.makeText(AddExercises.this, "Please enter in a name of the exercise", Toast.LENGTH_SHORT).show();
                }

                if (!TextUtils.isEmpty(numOfSets.getText().toString())) {
                    numSets = Integer.parseInt(numOfSets.getText().toString());


                } else {
                    Toast.makeText(AddExercises.this, "Please enter in the desired amount of sets", Toast.LENGTH_SHORT).show();

                }

                if (!TextUtils.isEmpty(numOfReps.getText().toString())) {
                    numReps = Integer.parseInt(numOfReps.getText().toString());

                } else {
                    Toast.makeText(AddExercises.this, "Please enter in the desired amount of reps", Toast.LENGTH_SHORT).show();

                }

                if (!TextUtils.isEmpty(numOfReps.getText().toString())) {
                    lbs = Integer.parseInt(weight.getText().toString());


                } else {
                    Toast.makeText(AddExercises.this, "Please enter in the desired amount of lbs", Toast.LENGTH_SHORT).show();
                }

                if(!TextUtils.isEmpty(exerciseName.getText().toString()) && !TextUtils.isEmpty(numOfSets.getText().toString())
                        && !TextUtils.isEmpty(numOfReps.getText().toString()) &&
                !TextUtils.isEmpty(numOfReps.getText().toString()) && !TextUtils.isEmpty(numOfReps.getText().toString())) {
                    Exercise exercise = new Exercise(name, numSets, numReps, lbs);
                    Intent intent = new Intent(AddExercises.this, NewPlan.class);
                    intent.putExtra("exerciseData", exercise);
                    startActivity(intent);

                }

            }
        });


    }

    private boolean isEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0)
            return false;

        return true;
    }


}