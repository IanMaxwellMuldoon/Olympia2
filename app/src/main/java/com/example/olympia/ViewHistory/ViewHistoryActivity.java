package com.example.olympia.ViewHistory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.olympia.CalorieCounter.ResultList;
import com.example.olympia.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

public class ViewHistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_history);

        Button foodButton = findViewById(R.id.idFoodButton);
        foodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //fragmentTransaction - Start Result List
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.idPlaceHolder, new FoodGraphFragment());
                ft.commit();
            }
        });
    }
}