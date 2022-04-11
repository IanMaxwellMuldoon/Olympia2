package com.example.olympia.ViewHistory.WorkoutPlanHistory;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.olympia.R;

import java.util.ArrayList;

public class WorkoutPlanExercisesAdapter extends ArrayAdapter<WorkoutPlanDataModal> {

    // constructor for our list view adapter.
    public WorkoutPlanExercisesAdapter(@NonNull Context context, ArrayList<WorkoutPlanDataModal> dataModalArrayList) {
        super(context, 0, dataModalArrayList);
        Log.d("TEST", "-->-->--> WorkoutPlanExercisesAdapter");

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // below line is use to inflate the
        // layout for our item of list view.
        Log.d("TEST", "-->-->--> WorkoutPlanExercisesAdapter");

        View listitemView = convertView;
        if (listitemView == null) {
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.workout_plan_exercises_list, parent, false);
        }
        Log.d("TEST", "-->-->--> WorkoutPlanExercisesAdapter view: " + listitemView);


        // after inflating an item of listview item
        // we are getting data from array list inside
        // our modal class.
        WorkoutPlanDataModal dataModal = getItem(position);

        // initializing our UI components of list view item.
        TextView exerciseName = listitemView.findViewById(R.id.idExerciseListExerciseName);
        TextView sets = listitemView.findViewById(R.id.idExerciseListSets);

        // after initializing our items we are
        // setting data to our view.
        // below line is use to set data to our text view.
//        List<String> exercises = dataModal.getExercises();
//        String name = exercises[0];
//        exerciseName.setText(dataModal.getExercise1());
        Log.d("Document", "-->-->--> BEFORE setting text");
        exerciseName.setText(dataModal.getPlanName());
        sets.setText(dataModal.getDate());
//        sets.setText("???");
        Log.d("Document", "-->-->--> AFTER setting text");

        // below line is use to add item click listener
        // for our item of list view.
        listitemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Exercise: " + dataModal.getExercise1(), Toast.LENGTH_SHORT).show();
            }
        });

        return listitemView;
    }
}