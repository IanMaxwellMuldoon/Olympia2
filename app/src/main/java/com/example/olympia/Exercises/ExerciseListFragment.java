 package com.example.olympia.Exercises;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.olympia.R;

import java.util.ArrayList;


 public class ExerciseListFragment extends Fragment {
    ListView listView;
    private Exercise selectedExercise;





     public ExerciseListFragment() {
     }



    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         selectedExercise = new Exercise();


        View view = inflater.inflate(R.layout.fragment_exercise_list, container, false);

        ArrayList<Exercise> exerciseList;



        //import data from AddExercise

        try{
            NewPlan newPlan = (NewPlan) getActivity();
            exerciseList = newPlan.getExerciseList();
            if(exerciseList != null) {
                listView = view.findViewById(R.id.idExerciseList);
                ExerciseAdapter exerciseAdapter= new ExerciseAdapter(getActivity().getApplicationContext(), R.layout.plan_item, exerciseList);
                listView.setAdapter(exerciseAdapter);

            } else {
                System.out.println("Null exercise list");
            }

        }catch (NullPointerException e){
            Log.d("error","Null exercise");
        }




        return view;
    }


 }