package com.example.olympia.ViewHistory.WorkoutPlanHistory;

import android.content.Context;
import android.content.Intent;
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

public class WorkoutPlanAdapter extends ArrayAdapter<WorkoutPlanDataModal> {
    Context context;

    // constructor for our list view adapter.
    public WorkoutPlanAdapter(@NonNull Context context, ArrayList<WorkoutPlanDataModal> dataModalArrayList) {
        super(context, 0, dataModalArrayList);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Inflate the layout for our item of list view.
        View listitemView = convertView;

        if (listitemView == null) {
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.workout_plan_history_list_item, parent, false);
        }

        // Store data taken from the array list
        WorkoutPlanDataModal dataModal = getItem(position);

        // initializing our UI components of list view item.
        TextView planName = listitemView.findViewById(R.id.planName);
        TextView date = listitemView.findViewById(R.id.planHistoryDate);
        TextView time = listitemView.findViewById(R.id.planHistoryTime);

        // Adjust datetime object into two strings
        String[] datetimeArr = dataModal.getTime().toString().split(" ");
        String splitDate = datetimeArr[0];
        String splitTime = datetimeArr[1];

        // Set the TextViews with the data grabbed from Firestore
        planName.setText(dataModal.getPlanName());
        date.setText(splitDate);
        time.setText(splitTime);

        // Click listener for each workout plan in the list view.
        listitemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get intent and send planName & docName to be used in the linked activity
                Intent intent = new Intent(getContext(), WorkoutPlanHistoryExerciseList.class);
                intent.putExtra("planName", dataModal.getPlanName());
                intent.putExtra("docName", dataModal.getDocName());

                context.startActivity(intent);
            }
        });

        return listitemView;
    }
}