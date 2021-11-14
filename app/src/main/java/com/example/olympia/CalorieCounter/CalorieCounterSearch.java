package com.example.olympia.CalorieCounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;


import com.example.olympia.R;

import org.apache.http.HttpRequest;
import org.apache.http.client.HttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;


public class CalorieCounterSearch extends AppCompatActivity {
    private static HttpURLConnection connection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie_counter);
        //RequestQueue queue = Volley.newRequestQueue(this)
    }


    public void Connect(String nameSearch) {
        new Thread(new Runnable() {
            public void run() {
                BufferedReader reader;
                String line;
                StringBuffer responseContent = new StringBuffer();
                try {
                    final String URL_PREFIX = "https://api.edamam.com/api/food-database/v2/parser";
                    final String API_ID = "?app_id=1ac33da3";
                    final String API_KEY = "&app_key=8a5ff0e08e487166b798e56f3ab64627";
                    final String INGR = "&ingr=";
                    final String URL_SUFFIX = "&nutrition-type=logging";

                    String urlstring = URL_PREFIX + API_ID + API_KEY + INGR + nameSearch + URL_SUFFIX;

                    URL url = new URL(urlstring);
                    connection = (HttpURLConnection) url.openConnection();

                    //Request setup
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(5000);
                    connection.setReadTimeout(5000);

                    int status = connection.getResponseCode();

                    if (status > 299) {
                        reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                        while ((line = reader.readLine()) != null) {
                            responseContent.append(line);
                        }
                        reader.close();
                    } else {
                        reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                        while ((line = reader.readLine()) != null) {
                            responseContent.append(line);
                        }
                    }
                    parse(responseContent.toString());



                } catch (
                        MalformedURLException e) {
                    e.printStackTrace();
                } catch (
                        ProtocolException e) {
                    e.printStackTrace();
                } catch (
                        IOException e) {
                    e.printStackTrace();
                } finally {
                    connection.disconnect();
                }

            }
        }).start();
    }



     public static String parse(String responseBody){
        try {
        JSONObject responseObject = new JSONObject(responseBody);
        String searchtext = responseObject.getString("text");
        JSONArray foodlist = responseObject.getJSONArray("hints");
        for(int i = 0; i < foodlist.length(); i++) {
            JSONObject listobject = foodlist.getJSONObject(i);
            JSONObject foodobject = listobject.getJSONObject("food");
            String label = foodobject.getString("label");
            JSONObject nutrients = foodobject.getJSONObject("nutrients");
            int calories = nutrients.getInt("ENERC_KCAL");
            int protein = nutrients.getInt("PROCNT");
            int fat = nutrients.getInt("FAT");
            int cholesterol = nutrients.getInt("CHOCDF");
            int fiber = nutrients.getInt("FIBTG");
            Log.d("foodlist", "food: "+ label + " Nutrients: calories = " + calories + " protien = " + protein+ " fat = " + fat + " cholesterol = " + cholesterol + " fiber = " + fiber);
        }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        return null;
        }
    }





