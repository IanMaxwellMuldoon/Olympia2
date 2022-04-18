package com.example.olympia.Exercises;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.olympia.Exercises.AddExercise.ExerciseSelectionList;
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
    private ArrayList<Exercise> exerciseList;
    private EditText planName;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("Creating new plan");
        exerciseList = DataHolder.getInstance().arrayList;
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


            if(exercise != null) {
                System.out.println("Exercise is loaded");
                System.out.println(exercise.getTitle());
                exerciseList.add(exercise);
                System.out.println("Exercise has been put on the list");


            } else {
                System.out.println("Exercise is a null object");
            }



        } catch (Exception e) {
            Log.d("error", "There was an issue getting exercise data");
            e.printStackTrace();
        }


        planName = findViewById(R.id.idPlanName);
        planName.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {

                    planName.clearFocus();
                    planName.requestFocus();
                }
                return false;
            }
        });

        addExerciseButton = findViewById(R.id.idAddExerciseButton);
        addExerciseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewPlan.this, ExerciseSelectionList.class);
                startActivity(intent);


            }
        });

        doneButton = findViewById(R.id.idDoneButton);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = planName.getText().toString();
                Plan plan = new Plan(name, exerciseList);




                firebaseFirestore.collection("users").document(user.getUid()).collection("plans").add(plan);
                Intent intent = new Intent(NewPlan.this, PlanMenu.class);
                System.out.println("New workout plan is being loaded in NewPlan.java");
                intent.putExtra("planData", plan);
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

    public void setArrayList(ArrayList<Exercise> arrayList) {
        this.exerciseList = arrayList;

    }

    public ArrayList<Exercise> getExerciseList() {
        return exerciseList;
    }
}