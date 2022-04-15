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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class NewPlan extends AppCompatActivity  {
    Button addExerciseButton;
    Button doneButton;
    Exercise exercise;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;
    ArrayList<Exercise> exerciseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_plan);

        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();

        firebaseFirestore = firebaseFirestore.getInstance();

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
                Plan plan = new Plan("Temp Title");

                firebaseFirestore.collection("users").document(user.getUid()).collection("plans").add(getExercise());
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