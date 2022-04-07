package com.example.olympia.Exercises;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


import com.example.olympia.Exercises.LogExercise.LogExercises;
import com.example.olympia.R;

import java.util.ArrayList;


public class PlanListFragment extends Fragment {

    private ListView listView;

    private ArrayList<Plan> plans;
    private Plan selectedPlan;


    public PlanListFragment() {
        // Required empty public constructor
    }

    private Exercise exercise;
    private ArrayList<Exercise> exercises;






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_plan_list, container, false);
        //

        exercises = new ArrayList<Exercise>();
        exercises.add(new Exercise("Tricep", 3, 8, 80));
        exercises.add(new Exercise("Pushups", 2, 10, 180));
        exercises.add(new Exercise("Shoulder Press", 5, 8, 135));



        plans = new ArrayList<Plan>();
        plans.add(new Plan("Push", exercises));
        plans.add(new Plan("Pull", exercises));
        plans.add(new Plan("Upper Body", exercises));







        //setting listview and adapter for search results
        listView = (ListView) view.findViewById(R.id.PlanListView);
        PlanAdapter planAdapter = new PlanAdapter(getActivity().getApplicationContext(), R.layout.plan_item, plans);
        listView.setAdapter(planAdapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                selectedPlan = (Plan)parent.getAdapter().getItem(position);
                Intent intent = new Intent(getContext(), LogExercises.class);
                intent.putExtra("Example", selectedPlan);

                startActivity(intent);

            }
        });


        return view;
    }
}