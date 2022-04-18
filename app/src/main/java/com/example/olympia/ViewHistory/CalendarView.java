package com.example.olympia.ViewHistory;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.olympia.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarView extends AppCompatActivity {

    CalendarView calendarView;
    TextView mydate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_view2);

        mydate = (TextView) findViewById(R.id.mydate);
        setDate(mydate);
    }

    private void setDate(TextView mydate) {
        Date today = Calendar.getInstance().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("mm.dd.yyyy");
        String date = formatter.format(today);
        mydate.setText(date);
    }
}