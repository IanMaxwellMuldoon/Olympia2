package com.example.olympia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
        final String INGR = "&ingr=";
        final String URL_SUFFIX = "&nutrition-type=logging";

        String url = URL_PREFIX + API_ID + API_KEY + INGR + nameSearch + URL_SUFFIX;

        
    }
    }
