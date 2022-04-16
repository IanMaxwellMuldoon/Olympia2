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

import com.example.olympia.Exercises.PlanMenu;
import com.example.olympia.R;

import java.util.ArrayList;

public class WorkoutPlanAdapter extends ArrayAdapter<WorkoutPlanDataModal> {
    Context context;
    String docName;
    // constructor for our list view adapter.
    public WorkoutPlanAdapter(@NonNull Context context, ArrayList<WorkoutPlanDataModal> dataModalArrayList, String docName) {
        super(context, 0, dataModalArrayList);
        this.context = context;
        this.docName = docName;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // below line is use to inflate the
        // layout for our item of list view.
        View listitemView = convertView;
        if (listitemView == null) {
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.workout_plan_history_list_item, parent, false);
        }

        // after inflating an item of listview item
        // we are getting data from array list inside
        // our modal class.
        WorkoutPlanDataModal dataModal = getItem(position);

        // initializing our UI components of list view item.
        TextView planName = listitemView.findViewById(R.id.planName);
        TextView date = listitemView.findViewById(R.id.date);

        // after initializing our items we are
        // setting data to our view.
        // below line is use to set data to our text view.
        planName.setText(dataModal.getPlanName());
//        date.setText(dataModal.getDate());
//        planName.setText(this.planName);
        date.setText(dataModal.getTime());

        // Click listener for each workout plan in the list view.
        listitemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Workout plan docName: " + docName, Toast.LENGTH_SHORT).show();
                // TODO: This seems to work properly but need clarification to be sure
                Intent intent = new Intent(getContext(), WorkoutPlanHistoryExerciseList.class);
                intent.putExtra("planName", dataModal.getPlanName());
                intent.putExtra("docName", docName);

                context.startActivity(intent);
            }
        });

        return listitemView;
    }
}