package com.example.olympia.Exercises.LogExercise;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.olympia.CalorieCounter.ResultList;
import com.example.olympia.Exercises.Exercise;
import com.example.olympia.Exercises.ExerciseAdapter;
import com.example.olympia.Exercises.Plan;
import com.example.olympia.R;

import java.util.ArrayList;

public class LogExercises extends AppCompatActivity {
    private ArrayList<Exercise> exerciseList;

    private ExerciseAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private ListView listView;
    private Button doneButton;
    ArrayList<Exercise> exercises;

    public LogExercises() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_exercises);

        //for toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Exercise");

        //get Plan object
        Intent intent = getIntent();
        Plan plan = intent.getParcelableExtra("Example");

        exercises = plan.getExerciseArrayList();
        getIntent().putExtra("Plan",plan);


        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.idLogExerciseFragmentListPH, new FragmentLogExerciseList());
        ft.commit();


        //set the title
        TextView currentPlan = (TextView) findViewById(R.id.idCurrentPlan);
        String title = plan.getTitle();
        currentPlan.setText(title);


    }



    private void createExampleList() {
        exerciseList = new ArrayList<>();
        //------------------------------------
        //something goes here not sure what//
        //------------------------------------
    }

    private String arrayListToString (ArrayList arrayList) {
        String s = "";
        for(Object str : arrayList) {
            s+= str+" ";

        }
       return s;

    }


    }
