package com.example.olympia.Exercises;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.olympia.R;

import java.util.ArrayList;

public class ExerciseAdapter extends ArrayAdapter {

    private ArrayList<Exercise> exerciseList;

    public ExerciseAdapter(@NonNull Context context, int resource, ArrayList<Exercise> exerciseList) {
        super(context, resource, exerciseList);
        this.exerciseList = exerciseList;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        int phraseIndex = position;
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.exercise_item, parent, false);
        }

        TextView exerciseName = (TextView) convertView.findViewById(R.id.addExerciseTextView);
        TextView exerciseSets = (TextView) convertView.findViewById(R.id.addExerciseSetsTextView);
        TextView exerciseReps = (TextView) convertView.findViewById(R.id.addExerciseRepsTextView);
        TextView exerciseWeight = (TextView) convertView.findViewById(R.id.addExerciseWeightTextView);

        try {
            // Convert stored Ints into Strings to be displayed in GUI
            String sets = Integer.toString(exerciseList.get(position).getNumSets());
            String reps = Integer.toString(exerciseList.get(position).getNumReps());
            String weight = Integer.toString(exerciseList.get(position).getWeight());
            exerciseName.setText(exerciseList.get(position).getTitle());
            exerciseSets.setText(sets);
            exerciseReps.setText(reps);
            exerciseWeight.setText(weight);

        } catch(Exception e) {
            System.out.println("Error: " + e);

        }
        //titleTextView.setText(exerciseList.get(position).getTitle());
        return convertView;
    }
}
