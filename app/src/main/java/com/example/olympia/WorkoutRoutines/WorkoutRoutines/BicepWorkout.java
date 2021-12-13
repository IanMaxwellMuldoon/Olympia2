package com.example.olympia.WorkoutRoutines.WorkoutRoutines;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.olympia.R;

import android.view.View;
import android.widget.CheckedTextView;
import android.widget.Button;

public class BicepWorkout extends AppCompatActivity {

    private CheckedTextView checkbox1;
    private CheckedTextView checkbox2;
    private CheckedTextView checkbox3;
    private CheckedTextView checkbox4;
    private CheckedTextView checkbox5;
    private CheckedTextView checkbox6;
    private CheckedTextView checkbox7;
    private CheckedTextView checkbox8;

    private Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bicep_workout);

        checkbox1 = (CheckedTextView) findViewById(R.id.checkedTextView1);
        checkbox2 = (CheckedTextView) findViewById(R.id.checkedTextView2);
        checkbox3 = (CheckedTextView) findViewById(R.id.checkedTextView3);
        checkbox4 = (CheckedTextView) findViewById(R.id.checkedTextView4);
        checkbox5 = (CheckedTextView) findViewById(R.id.checkedTextView5);
        checkbox6 = (CheckedTextView) findViewById(R.id.checkedTextView6);
        checkbox7 = (CheckedTextView) findViewById(R.id.checkedTextView7);
        checkbox8 = (CheckedTextView) findViewById(R.id.checkedTextView8);
        add = (Button) findViewById(R.id.button10);

        checkbox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkbox1.isChecked()){
                    checkbox1.setChecked(false);
                }
                else
                    checkbox1.setChecked(true);
            }
        });

        checkbox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkbox2.isChecked()){
                    checkbox2.setChecked(false);
                }
                else
                    checkbox2.setChecked(true);
            }
        });

        checkbox3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkbox3.isChecked()){
                    checkbox3.setChecked(false);
                }
                else
                    checkbox3.setChecked(true);
            }
        });

        checkbox4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkbox4.isChecked()){
                    checkbox4.setChecked(false);
                }
                else
                    checkbox4.setChecked(true);
            }
        });

        checkbox5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkbox5.isChecked()){
                    checkbox5.setChecked(false);
                }
                else
                    checkbox5.setChecked(true);
            }
        });

        checkbox6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkbox6.isChecked()){
                    checkbox6.setChecked(false);
                }
                else
                    checkbox6.setChecked(true);
            }
        });

        checkbox7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkbox7.isChecked()){
                    checkbox7.setChecked(false);
                }
                else
                    checkbox7.setChecked(true);
            }
        });

        checkbox8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkbox8.isChecked()){
                    checkbox8.setChecked(false);
                }
                else
                    checkbox8.setChecked(true);
            }
        });

     /*   add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                openBicepSelectedPlan();
            }
        }); */


    }
   /* public void openBicepSelectedPlan(){
        Intent intent = new Intent (this, BicepSelectedPlan.class);
        startActivity(intent);
    } */
}