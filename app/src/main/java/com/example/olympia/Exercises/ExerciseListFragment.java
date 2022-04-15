 package com.example.olympia.Exercises;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.olympia.R;

import java.util.ArrayList;


 public class ExerciseListFragment extends Fragment {
    ListView listView;
    ArrayList<Exercise> exerciseList =  new ArrayList<Exercise>();




     public ExerciseListFragment() {
     }



    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_exercise_list, container, false);

        //import data from AddExercise



        exerciseList.add(new Exercise("A"));
        exerciseList.add(new Exercise("B"));
        exerciseList.add(new Exercise("C"));


        try{
            NewPlan newPlan = (NewPlan) getActivity();
            Exercise exercise = newPlan.getExercise();
            Log.d("message","Exercise title: " + exercise.getTitle());
            exerciseList.add(exercise);
        }catch (NullPointerException e){
            Log.d("error","Null exercise");
        }
        listView = view.findViewById(R.id.idExerciseList);
        ExerciseAdapter exerciseAdapter= new ExerciseAdapter(getActivity().getApplicationContext(), R.layout.plan_item, exerciseList);
        listView.setAdapter(exerciseAdapter);



        return view;
    }


 }