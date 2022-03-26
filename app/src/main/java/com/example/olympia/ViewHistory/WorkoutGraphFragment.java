package com.example.olympia.ViewHistory;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.olympia.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;


public class WorkoutGraphFragment extends Fragment {

    BarChart barChart;
    BarData barData;
    BarDataSet barDataSet;
    ArrayList barEntriesList;

    public WorkoutGraphFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_food_graph, container, false);
        barChart = view.findViewById(R.id.idFoodBarChart);
        //get sample data
        sampleData();
        //create bar data set
        barDataSet = new BarDataSet(barEntriesList, "sample data");
        //create data
        barData = new BarData(barDataSet);
        barData.setValueTextColor(Color.WHITE);
        //set data
        barChart.setData(barData);
        //set colors
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        //text color
        barDataSet.setValueTextColor(Color.WHITE);
        // setting text size
        barDataSet.setValueTextSize(16f);
        barChart.getDescription().setEnabled(false);
        barChart.setTouchEnabled(false);

        return view;
    }

    private void sampleData(){
        barEntriesList = new ArrayList<>();
        barEntriesList.add(new BarEntry(6f, 4));
        barEntriesList.add (new BarEntry(8f, 6));
        barEntriesList.add(new BarEntry(1f,8));
        barEntriesList.add(new BarEntry(2f, 2));
        barEntriesList.add(new BarEntry(8f, 4));
        barEntriesList.add(new BarEntry(1f, 1));
    }
}