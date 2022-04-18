package com.example.olympia.Exercises.AddExercise;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.olympia.R;

import java.util.ArrayList;

public class ExerciseSelectionAdapter extends ArrayAdapter<ExerciseSelectionDataModel> {
    // constructor for our list view adapter.
    public ExerciseSelectionAdapter(@NonNull Context context, ArrayList<ExerciseSelectionDataModel> dataModalArrayList) {
        super(context, 0, dataModalArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Inflate the layout for our item of list view.
        View listitemView = convertView;

        if (listitemView == null) {
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.exercise_selection_list_item, parent, false);
        }

        // Store data taken from the array list
        ExerciseSelectionDataModel dataModal = getItem(position);

        // initializing our UI components of list view item.
        TextView exerciseName = listitemView.findViewById(R.id.exerciseSelectionExerciseName);

        // Set the TextViews with the data grabbed from Firestore
        exerciseName.setText(dataModal.getExerciseName());

        // Click listener for each workout plan in the list view.
        listitemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get intent and send planName & docName to be used in the linked activity
//                Intent intent = new Intent(getContext(), WorkoutPlanHistoryExerciseList.class);
//                intent.putExtra("planName", dataModal.getPlanName());
//                intent.putExtra("docName", docName);
//
//                context.startActivity(intent);
            }
        });

        return listitemView;
    }
}