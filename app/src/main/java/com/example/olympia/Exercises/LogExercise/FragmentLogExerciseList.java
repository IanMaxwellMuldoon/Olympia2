package com.example.olympia.Exercises.LogExercise;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.olympia.Exercises.Exercise;
import com.example.olympia.Exercises.Plan;
import com.example.olympia.R;

import java.util.ArrayList;


public class FragmentLogExerciseList extends Fragment {
    ListView listView;
    ArrayList<Exercise> exerciseList;


    public FragmentLogExerciseList() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       try {
           View view = inflater.inflate(R.layout.fragment_log_exercise_list, container, false);

           Intent i = getActivity().getIntent();

           Plan plan = (Plan)i.getParcelableExtra("Plan");
           exerciseList = plan.getExerciseArrayList();


           LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
           listView = view.findViewById(R.id.idLogExerciseList);
           LogExerciseAdapter logAdapter = new LogExerciseAdapter(getActivity().getApplicationContext(), R.layout.exercise_log_item, exerciseList);
           listView.setAdapter(logAdapter);




           return view;
       }catch (Exception e){
           Log.e("OnCreateView", String.valueOf(e));
           throw e;
       }
    }

}