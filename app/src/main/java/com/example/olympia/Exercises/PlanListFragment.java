package com.example.olympia.Exercises;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


import com.example.olympia.R;

import org.w3c.dom.Text;

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
        exercises.add(new Exercise("Bench", 3, 8, 135));
        exercises.add(new Exercise("Incline Bench", 3, 8, 135));


        plans = new ArrayList<Plan>();
        plans.add(new Plan("Push", exercises));
        plans.add(new Plan("Pull"));
        plans.add(new Plan("Leg"));
        plans.add(new Plan("Shoulders"));
        plans.add(new Plan("Legs"));
        plans.add(new Plan("Legs"));
        plans.add(new Plan("Chest"));
        plans.add(new Plan("Back and Bi"));
        plans.add(new Plan("Shoulders"));
        plans.add(new Plan("Legs"));
        plans.add(new Plan("Legs"));
        plans.add(new Plan("Chest"));
        plans.add(new Plan("Back and Bi"));
        plans.add(new Plan("Shoulders"));
        plans.add(new Plan("Legs"));





        //setting listview and adapter for search results
        listView = (ListView) view.findViewById(R.id.PlanListView);
        PlanAdapter planAdapter = new PlanAdapter(getActivity().getApplicationContext(), R.layout.plan_item, plans);
        listView.setAdapter(planAdapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //String planName = (String) listView.getItemAtPosition(position);
                //Log.d("msg", planName);

                selectedPlan = (Plan)parent.getAdapter().getItem(position);
                Intent intent = new Intent(getContext(), CurrentPlan.class);
                intent.putExtra("Example", selectedPlan);
                startActivity(intent);
            }
        });


        return view;
    }
}