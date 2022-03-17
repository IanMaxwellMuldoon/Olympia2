package com.example.olympia.CalorieCounter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.olympia.Login.RegistrationPage;
import com.example.olympia.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AddFood extends AppCompatActivity {
    private int num = 1;
    private FoodItem selectedFood;
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);
        String[] data = {"1","2","3","4","5","6"};


        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();

        db = FirebaseFirestore.getInstance();

        TextView dropdownNum = (TextView)findViewById(R.id.iddropNum);
        //for toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Add Food");

        TextView FoodLabel = (TextView) findViewById(R.id.FoodLabel);
        TextView Calories = (TextView) findViewById(R.id.CalorieNumID);
        TextView Protein = (TextView) findViewById(R.id.ProteinNumID);
        TextView Cholesterol = (TextView) findViewById(R.id.ChoNumID);
        TextView Fiber = (TextView) findViewById(R.id.FibNumID);
        Spinner dropdown = findViewById(R.id.idSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, data);
        dropdown.setAdapter(adapter);


        selectedFood = new FoodItem();
        selectedFood = ResultList.selectedFood;


        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedFood = ResultList.selectedFood;
                String servingNum = dropdown.getSelectedItem().toString();
                num = Integer.parseInt(servingNum);
                selectedFood = new FoodItem(selectedFood,num);
                Calories.setText(""+selectedFood.getCalories() + " kcal");
                Protein.setText(""+selectedFood.getProtein() + " g");
                Cholesterol.setText(""+selectedFood.getCholesterol()+" g");
                Fiber.setText(""+selectedFood.getFiber()+" g");
                dropdownNum.setText(""+num);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ImageButton checkButton = findViewById(R.id.idDoneButton);
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //This is where we add selectedFood to the Database
               // Toast.makeText(AddFood.this, "FOOD ADDED", Toast.LENGTH_SHORT).show();
                Toast.makeText(AddFood.this, "user is " + user.getDisplayName(), Toast.LENGTH_SHORT).show();

                //db.collection("users").document(RegistrationPage.newDocumentID).collection("foodlist").add(selectedFood);
                DocumentReference documentReference = db.collection("users").document(user.getUid()).collection("foodlist").document("foodList");
                documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            DocumentSnapshot document = task.getResult();
                            if (document.exists()) {
                                Log.d("work", "DocumentSnapshot data: " + document.getData());
                            } else {
                                Log.d("work", "No such document");
                            }
                        } else {
                            Log.d("work", "get failed with ", task.getException());
                        }
                    }
                });

            }
        });
        /*FirebaseUser user = mAuth.getCurrentUser();
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
                        });*/


        String label = selectedFood.getLabel();
        FoodLabel.setText(""+label);
        int cal = selectedFood.getCalories();
        Calories.setText(""+cal);
        int pro = selectedFood.getProtein();
        Protein.setText(""+pro);
        int cho = selectedFood.getCholesterol();
        Cholesterol.setText(""+cho);
        int fib = (int)selectedFood.getFiber();
        Fiber.setText(""+fib);
    }
}