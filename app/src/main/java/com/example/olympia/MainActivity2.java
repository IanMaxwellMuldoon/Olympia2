package com.example.olympia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.olympia.CalorieCounter.CalorieCounterSearch;
import com.example.olympia.CalorieCounter.CalorieMenu;
import com.example.olympia.Menus.MainMenu;
import com.google.android.material.button.MaterialButton;

public class MainActivity2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        TextView username = (TextView) findViewById(R.id. username);
        TextView password = (TextView) findViewById(R.id. password);

        MaterialButton Loginbtn = (MaterialButton) findViewById(R.id.Loginbtn);
        //admin and admin
        Loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if
                (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {

                    Intent intent = new Intent(MainActivity2.this, MainMenu.class);
                    startActivity(intent);
                    Toast.makeText(MainActivity2.this, "LOGIN SUCCESSFULL", Toast.LENGTH_SHORT).show();

                } else
                    Toast.makeText(MainActivity2.this, "LOGIN Failed, Try Again", Toast.LENGTH_SHORT).show();

            }


        });


    }
}