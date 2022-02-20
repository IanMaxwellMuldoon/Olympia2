package com.example.olympia.CalorieCounter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.SearchRecentSuggestions;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;


import com.example.olympia.R;

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
import java.util.ArrayList;
import java.util.List;


public class CalorieCounterSearch extends AppCompatActivity{
    private static HttpURLConnection connection;
    private String nameSearch;
    private String input;
    private String[] autoList = new String[]{"Chicken", "Sandwich", "Burger"};
    public static ArrayList<FoodItem> FoodItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie_counter);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Meal Type Text
        TextView mealType = (TextView) findViewById(R.id.mealType);
        mealType.setText("<Food Type>");

        Intent intent = getIntent();
        String string = intent.getStringExtra("message_key");
        mealType.setText(string);

        //Search Bar
        AutoCompleteTextView searchBar = (AutoCompleteTextView) findViewById(R.id.autoComplete);

        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            //When the user is typing
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                input = searchBar.getText().toString();
                new autoSearchNetworkCall().execute();
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(CalorieCounterSearch.this, android.R.layout.simple_list_item_1, autoList);
                searchBar.setAdapter(adapter);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        // When the user hits "enter"
        searchBar.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_DONE) {
                    nameSearch = searchBar.getText().toString();
                    SearchRecentSuggestions suggestions = new SearchRecentSuggestions(CalorieCounterSearch.this, MySuggestionProvider.AUTHORITY, MySuggestionProvider.MODE);
                    suggestions.saveRecentQuery(nameSearch, null);
                    new foodSearchNetworkCall().execute();
                }
                return false;
            }
        });

        searchBar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                nameSearch = searchBar.getText().toString();
                new foodSearchNetworkCall().execute();
                Log.d("message","food network call");
            }
        });


    }
    public List<FoodItem> getfoodItems(){
        return FoodItems;
    }



    private class foodSearchNetworkCall extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {

            BufferedReader reader;
            String line;
            StringBuffer responseContent = new StringBuffer();

            try {
                final String URL_PREFIX = "https://api.edamam.com/api/food-database/v2/parser";
                final String API_ID = "?app_id=1ac33da3";
                final String API_KEY = "&app_key=8a5ff0e08e487166b798e56f3ab64627";
                final String INGR = "&ingr=";
                final String URL_SUFFIX = "&nutrition-type=cooking";

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

            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                connection.disconnect();
            }

            //fragmentTransaction - Start Result List
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.placeholder, new ResultList());
            ft.commit();

            return null;
        }


    }

    private class autoSearchNetworkCall extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            BufferedReader reader;
            String line;
            StringBuffer responseContent = new StringBuffer();
            try {
                final String URL_PREFIX = "https://api.edamam.com/auto-complete";
                final String API_ID = "?app_id=1ac33da3";
                final String API_KEY = "&app_key=8a5ff0e08e487166b798e56f3ab64627";
                final String INGR = "&q=";

                String urlstring = URL_PREFIX + API_ID + API_KEY + INGR + input;

                URL url = new URL(urlstring);
                connection = (HttpURLConnection) url.openConnection();

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
                parseAuto(responseContent.toString());
            } catch (
                    ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();

            } finally {
                connection.disconnect();
            }
            return null;
        }
    }

    private void parseAuto(String responseBody) {
        try {
            JSONArray responseArray = new JSONArray(responseBody);
            autoList = new String[responseArray.length()];
            for (int i = 0; i < responseArray.length(); i++) {
                String recommendation = responseArray.getString(i);
                autoList[i] = recommendation;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private void parse(String responseBody) {
        try {
            FoodItems = new ArrayList<>();
            JSONObject responseObject = new JSONObject(responseBody);
            String searchtext = responseObject.getString("text");
            JSONArray foodlist = responseObject.getJSONArray("hints");
            for (int i = 0; i < foodlist.length(); i++) {
                int calories = 0;
                int protein = 0;
                int fat = 0;
                double fiber = 0;
                int cholesterol = 0;
                String brand = null;
                JSONObject listobject = foodlist.getJSONObject(i);
                JSONObject foodobject = listobject.getJSONObject("food");
                String label = foodobject.getString("label");
                JSONObject nutrients = foodobject.getJSONObject("nutrients");
                if (nutrients.has("ENERC_KCAL")) {
                    calories = nutrients.getInt("ENERC_KCAL");
                }
                if (nutrients.has("PROCNT")) {
                    protein = nutrients.getInt("PROCNT");
                }
                if (nutrients.has("FAT")) {
                    fat = nutrients.getInt("FAT");
                }
                if (nutrients.has("CHOCDF")) {
                    cholesterol = nutrients.getInt("CHOCDF");
                }
                if (nutrients.has("FIBTG")) {
                    fiber = nutrients.getDouble("FIBTG");
                }
                if(foodobject.has("brand")) {
                    brand = foodobject.getString("brand");
                }
                FoodItems.add(new FoodItem(label, brand, calories, protein, fat, fiber, cholesterol));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


}





