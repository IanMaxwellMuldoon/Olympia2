package com.example.olympia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CalorieCounterSearch calorie = new CalorieCounterSearch();
        calorie.Connect("chicken sandwich");


    //Added something to try and open buttons but app will not open
        
  /*     button = (Button) findViewById(R.id.button);
       button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    openCalorieCounter();
            }
        }); */

    }

   /* public void openCalorieCounter() {
        Intent intent = new Intent(this, CalorieCounterSearch.class);
        startActivity(intent);
    } */


}