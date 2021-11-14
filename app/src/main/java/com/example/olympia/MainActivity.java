package com.example.olympia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.olympia.CalorieCounter.CalorieCounterSearch;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CalorieCounterSearch calorie = new CalorieCounterSearch();
        calorie.Connect("carbonara");


    }
}