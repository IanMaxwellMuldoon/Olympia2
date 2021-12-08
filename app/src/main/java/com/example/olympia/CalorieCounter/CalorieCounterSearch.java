package com.example.olympia.CalorieCounter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
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
import java.io.Serializable;
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
    public static ArrayList<foodItem> foodItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie_counter);



        //Meal Type Text
        TextView mealType = (TextView) findViewById(R.id.mealType);
        mealType.setText("<Food Type>");

        //Search Bar
        AutoCompleteTextView searchBar = (AutoCompleteTextView) findViewById(R.id.autoComplete);

        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

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
        searchBar.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_DONE) {
                    nameSearch = searchBar.getText().toString();
                    new foodSearchNetworkCall().execute();

                    Bundle bundle = new Bundle();
                    bundle.putParcelableArrayList("foodItems", foodItems);

                    FragmentList fragmentList = new FragmentList();
                    fragmentList.setArguments(bundle);

                    //fragmentTransaction
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.placeholder, new FragmentList());
                    ft.commit();

                }
                return false;
            }
        });

        //searchBar.getOnItemClickListener(new AdapterView.OnItemClickListener())


    }
    public List<foodItem> getfoodItems(){
        return foodItems;
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

            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                connection.disconnect();
            }
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
                Log.d("recommend", recommendation);
                autoList[i] = recommendation;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private void parse(String responseBody) {
        try {
            foodItems = new ArrayList<foodItem>();
            JSONObject responseObject = new JSONObject(responseBody);
            String searchtext = responseObject.getString("text");
            JSONArray foodlist = responseObject.getJSONArray("hints");
            for (int i = 0; i < foodlist.length(); i++) {
                int calories = 0;
                int protein = 0;
                int fat = 0;
                double fiber = 0;
                int cholesterol = 0;
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
                foodItems.add(new foodItem(label, calories, protein, fat, fiber, cholesterol));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


}





