package com.example.olympia.Exercises.LogExercise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.olympia.Exercises.Exercise;
import com.example.olympia.Exercises.Plan;
import com.example.olympia.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class LogExerciseAdapter extends ArrayAdapter {

    private ArrayList<Exercise> exercises;
    private ArrayList<Button> buttons;
    private ListView listView;
    private RecyclerView recyclerView;
    protected String[] mDataset;

    public LogExerciseAdapter(@NonNull Context context, int resource, ArrayList<Exercise> exercises) {
        super(context, resource, exercises);
        this.exercises = exercises;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        int phraseIndex = position;
        buttons = new ArrayList<Button>();
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.exercise_log_item, parent, false);
        }
        TextView titleTextView = convertView.findViewById(R.id.idLogExerciseName);
        titleTextView.setText(exercises.get(position).getTitle());

        TextView setsnreps = convertView.findViewById(R.id.idSetsnReps);
        setsnreps.setText(exercises.get(position).getRepSetWeight());

        //initialize buttons
        for(int i = 0; i < exercises.get(position).getNumSets(); i++){
            buttons.add(new Button(getContext()));
        }



        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView = convertView.findViewById(R.id.idCircleList);
        recyclerView.setLayoutManager(layoutManager);
        LogCircleAdapter circleAdapter = new LogCircleAdapter(buttons);
        recyclerView.setAdapter(circleAdapter);




        /*
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView = convertView.findViewById(R.id.idCircleList);
        recyclerView.setLayoutManager(mLayoutManager);
        CustomAdapter mAdapter = new CustomAdapter(mDataset);
        // Set CustomAdapter as the adapter for RecyclerView.
        recyclerView.setAdapter(mAdapter);
        */






        //ListView logButtonList = convertView.findViewById(R.id.idLogButtonList);





        return convertView;
    }



}
