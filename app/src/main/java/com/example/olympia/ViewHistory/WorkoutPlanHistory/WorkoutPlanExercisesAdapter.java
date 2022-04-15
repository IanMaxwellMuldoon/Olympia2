package com.example.olympia.ViewHistory.WorkoutPlanHistory;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.olympia.Exercises.PlanMenu;
import com.example.olympia.R;

import java.util.ArrayList;

public class WorkoutPlanExercisesAdapter extends ArrayAdapter<WorkoutPlanHistoryExerciseDataModal> {
    Context context;
    // constructor for our list view adapter.
    public WorkoutPlanExercisesAdapter(@NonNull Context context, ArrayList<WorkoutPlanHistoryExerciseDataModal> dataModalArrayList) {
        super(context, 0, dataModalArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // below line is use to inflate the
        // layout for our item of list view.
        View listitemView = convertView;
        if (listitemView == null) {
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.workout_plan_history_exercise_list_item, parent, false);
        }


        // after inflating an item of listview item
        // we are getting data from array list inside
        // our modal class.
        WorkoutPlanHistoryExerciseDataModal dataModal = getItem(position);

        // initializing our UI components of list view item.
        TextView exerciseName = listitemView.findViewById(R.id.exerciseHistoryExerciseName);
        TextView exerciseWeight = listitemView.findViewById(R.id.exerciseHistoryListWeight);
        TextView exerciseGoal = listitemView.findViewById(R.id.exerciseHistoryListGoalAmt);
        TextView exerciseSets = listitemView.findViewById(R.id.exerciseHistoryListSets);
        TextView exerciseReps = listitemView.findViewById(R.id.exerciseHistoryListNumReps);

        // after initializing our items we are
        // setting data to our view.
        // below line is use to set data to our text view.
        exerciseName.setText(dataModal.getTitle());
        exerciseWeight.setText(dataModal.getWeight().toString());
        exerciseGoal.setText(dataModal.getRepSetWeight());
        exerciseSets.setText(dataModal.getNumSets().toString());
        exerciseReps.setText(dataModal.getNumReps().toString());

        // below line is use to add item click listener
        // for our item of list view.
        listitemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getContext(), "Exercise: " + dataModal.getExerciseName(), Toast.LENGTH_SHORT).show();
            }
        });

        return listitemView;
    }
}