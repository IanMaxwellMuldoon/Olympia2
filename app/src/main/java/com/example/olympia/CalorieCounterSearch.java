package com.example.olympia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class CalorieCounterSearch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie_counter);
        RequestQueue queue = Volley.newRequestQueue(this);
    }
    private StringRequest searchNameStringRequest(String nameSearch) {
        final String URL_PREFIX = "https://api.edamam.com/api/food-database/v2/parser";
        final String API_ID = "?app_id=1ac33da3";
        final String API_KEY = "&app_key=8a5ff0e08e487166b798e56f3ab64627";
    }
}