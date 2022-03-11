package com.example.olympia.Login;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.olympia.R;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.navigation.ui.AppBarConfiguration;


import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class RegistrationPage extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private AppBarConfiguration appBarConfiguration;
//    private ActivityMain4Binding binding;
    private EditText email;
    private EditText password;
    private EditText age;
    private EditText height;
    private EditText weight;
    private EditText goal;
    private Button BtnRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();

        setContentView(R.layout.activity_registration_page);

        email = findViewById(R.id.idEdtUserName);
        password = findViewById(R.id.Rpassword);
        age = findViewById(R.id.Rage);
        height = findViewById(R.id.Rheight);
        weight = findViewById(R.id.Rweight);
        goal = findViewById(R.id.Rgoal);
        BtnRegister = findViewById(R.id.idBtnRegister);

        //Register Button onClick
        BtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                mAuth
                        .createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // User registered
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    FirebaseFirestore db = FirebaseFirestore.getInstance();

                                    Map<String, Object> userProfile = new HashMap<>();
                                    userProfile.put("uid", user.getUid());
                                    userProfile.put("height", height.getText().toString());
                                    userProfile.put("weight", weight.getText().toString());
                                    userProfile.put("age", age.getText().toString());
                                    userProfile.put("goal", goal.getText().toString());




                                    db.collection("users")
                                            .add(userProfile)
                                            .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                                @Override
                                                public void onSuccess(DocumentReference documentReference) {
                                                    // User profile created and saved
                                                    // TODO: Go to main screen
                                                    Toast.makeText(RegistrationPage.this, "User has been created", Toast.LENGTH_SHORT ).show();
                                                    Intent intent = new Intent(RegistrationPage.this, LoginPage.class);
                                                    startActivity(intent);
                                                }
                                            })
                                            .addOnFailureListener(new OnFailureListener() {
                                                @Override
                                                public void onFailure(@NonNull Exception e) {
                                                    // Failed to create user profile
                                                    // TODO: show
                                                    Toast.makeText(RegistrationPage.this, "ERROR", Toast.LENGTH_SHORT).show();
                                                }
                                            });
                                } else {
                                    // User did not register
                                    Toast.makeText(RegistrationPage.this, "Could not register user", Toast.LENGTH_SHORT);
                                }
                            }
                        });

            }
        });
    }
}