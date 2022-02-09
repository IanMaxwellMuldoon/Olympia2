package com.example.olympia.Exercises;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import com.example.olympia.R;

import java.util.ArrayList;


public class PlanListFragment extends Fragment {

    private ListView listView;

    private ArrayList<Plan> plans;
    private Plan selectedPlan;

    public PlanListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_plan_list, container, false);
        //
        plans = new ArrayList<Plan>();
        plans.add(new Plan("5 x 5"));
        plans.add(new Plan("Chest"));
        plans.add(new Plan("Back and Bi"));
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
                selectedPlan = (Plan)parent.getAdapter().getItem(position);
                Intent intent = new Intent(getContext(), CurrentPlan.class);
                startActivity(intent);
            }
        });


        return view;
    }
}