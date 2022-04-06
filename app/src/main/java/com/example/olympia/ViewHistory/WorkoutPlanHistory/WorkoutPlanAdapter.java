package com.example.olympia.ViewHistory.WorkoutPlanHistory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.olympia.Exercises.Exercise;
import com.example.olympia.Exercises.LogExercise.LogCircleAdapter;
import com.example.olympia.R;

import java.util.ArrayList;

public class WorkoutPlanAdapter extends ArrayAdapter<WorkoutPlanDataModal> {

    // constructor for our list view adapter.
    public WorkoutPlanAdapter(@NonNull Context context, ArrayList<WorkoutPlanDataModal> dataModalArrayList) {
        super(context, 0, dataModalArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // below line is use to inflate the
        // layout for our item of list view.
        View listitemView = convertView;
        if (listitemView == null) {
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.workout_plan_list_item, parent, false);
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
        date.setText(dataModal.getDate());

        // below line is use to add item click listener
        // for our item of list view.
        listitemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on the item click on our list view.
                // we are displaying a toast message.
                Toast.makeText(getContext(), "Item clicked is : " + dataModal.getPlanName(), Toast.LENGTH_SHORT).show();
            }
        });

        return listitemView;
    }
}