package com.example.olympia.CalorieCounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.olympia.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalorieMenu extends AppCompatActivity {

    private static final String msg = "message";


    private TextView dateTimeDisplay;
    private Calendar calendar;
    private SimpleDateFormat dateFormat;
    private String date;

    private String sendText(Button button) {
        String text = button.getText().toString();
        return text;



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie_menu);


        dateTimeDisplay = (TextView)findViewById(R.id.textDateDisplay);
        calendar = Calendar.getInstance();
        dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        date = SimpleDateFormat.getDateInstance().format(calendar.getTime());
        dateTimeDisplay.setText(date);



        Button breakfastButton = (Button)findViewById(R.id.breakfastButton);
        breakfastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalorieMenu.this, CalorieCounterSearch.class);
                intent.putExtra("message_key", sendText(breakfastButton));
                startActivity(intent);
            }
        });

        Button lunchButton = (Button)findViewById(R.id.lunchButton);
        lunchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalorieMenu.this, CalorieCounterSearch.class);
                intent.putExtra("message_key", sendText(lunchButton));
                startActivity(intent);
            }
        });

        Button dinnerButton = (Button)findViewById(R.id.dinnerButton);
        dinnerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalorieMenu.this, CalorieCounterSearch.class);
                intent.putExtra("message_key", sendText(dinnerButton));
                startActivity(intent);
            }
        });

        Button snacksButton = (Button)findViewById(R.id.snacksButton);
        snacksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalorieMenu.this, CalorieCounterSearch.class);
                intent.putExtra("message_key", sendText(snacksButton));
                startActivity(intent);
            }
        });

        Button drinksButton = (Button)findViewById(R.id.drinksButton);
        drinksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalorieMenu.this, CalorieCounterSearch.class);
                intent.putExtra("message_key", sendText(drinksButton));
                startActivity(intent);
            }
        });



    }
}