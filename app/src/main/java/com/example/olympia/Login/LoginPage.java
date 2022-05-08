package com.example.olympia.Login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.olympia.Menus.MainMenu;
import com.example.olympia.R;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginPage extends AppCompatActivity {
    //does this change register

    private FirebaseAuth mAuth;

    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();

        if(currentUser != null) {
            // Go to second page
            // startActivity(....)

        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();

        setContentView(R.layout.activity_login_page);

        Button yourButton = (Button) findViewById(R.id.register);




        TextView username = (TextView) findViewById(R.id. username);
        TextView password = (TextView) findViewById(R.id. password);

        MaterialButton Loginbtn = (MaterialButton) findViewById(R.id.Loginbtn);
        //admin and admin
        Loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signInWithEmailAndPassword(username.getText().toString(), password.getText().toString())
                        .addOnCompleteListener(LoginPage.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Toast.makeText(LoginPage.this, "LOGIN SUCCESSFULL", Toast.LENGTH_SHORT).show();

                                    // Go to second page
                                    Intent intent = new Intent(LoginPage.this, MainMenu.class);
                                    startActivity(intent);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(LoginPage.this, "LOGIN Failed, Try Again", Toast.LENGTH_SHORT).show();
                                }

                                // ...
                            }
                        });


//                if
//                (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
//                    Toast.makeText(MainActivity2.this, "LOGIN SUCCESSFULL", Toast.LENGTH_SHORT).show();
//
//                } else
//                    Toast.makeText(MainActivity2.this, "LOGIN Failed, Try Again", Toast.LENGTH_SHORT).show();

            }


        });

        MaterialButton registerBtn = (MaterialButton) findViewById(R.id.register);
        //admin and admin
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginPage.this, RegistrationPage.class);
                startActivity(intent);
//                mAuth.createUserWithEmailAndPassword(username.getText().toString(), password.getText().toString())
//                        .addOnCompleteListener(MainActivity2.this, new OnCompleteListener<AuthResult>() {
//                            @Override
//                            public void onComplete(@NonNull Task<AuthResult> task) {
//                                if (task.isSuccessful()) {
//                                    // Sign in success, update UI with the signed-in user's information
//                                    FirebaseUser user = mAuth.getCurrentUser();
//                                    Toast.makeText(MainActivity2.this, "LOGIN SUCCESSFULL", Toast.LENGTH_SHORT).show();
//
//                                    // Go to second page
//
//                                } else {
//                                    // If sign in fails, display a message to the user.
//                                    Toast.makeText(MainActivity2.this, "Authentication failed.",
//                                            Toast.LENGTH_SHORT).show();
//                                }
//
//                                // ...
//                            }
//                        });
            }

        });
    }
}