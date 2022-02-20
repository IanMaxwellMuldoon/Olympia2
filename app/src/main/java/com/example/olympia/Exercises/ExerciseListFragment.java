 package com.example.olympia.Exercises;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.olympia.R;

import java.util.ArrayList;


 public class ExerciseListFragment extends Fragment {
    ListView listView;
    ArrayList<Exercise> exerciseList;


     public ExerciseListFragment() {
     }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exercise_list, container, false);
        exerciseList = new ArrayList<Exercise>();
        exerciseList.add(new Exercise("push ups"));
        exerciseList.add(new Exercise("Bench"));
        exerciseList.add(new Exercise("Legs"));
        exerciseList.add(new Exercise("Dick ups"));
        exerciseList.add(new Exercise("push ups"));


        listView = view.findViewById(R.id.idExerciseList);
        ExerciseAdapter exerciseAdapter= new ExerciseAdapter(getActivity().getApplicationContext(), R.layout.plan_item, exerciseList);
        listView.setAdapter(exerciseAdapter);

        return view;
    }
}