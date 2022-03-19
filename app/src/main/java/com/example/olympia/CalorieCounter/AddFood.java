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
import com.google.firebase.Timestamp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import android.text.format.Time;
import java.util.HashMap;
import java.util.Map;

public class AddFood extends AppCompatActivity {
    private int num = 1;
    private FoodItem selectedFood;
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;
    private String time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);
        String[] data = {"1", "2", "3", "4", "5", "6"};


        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();

        db = FirebaseFirestore.getInstance();

        TextView dropdownNum = findViewById(R.id.iddropNum);
        //for toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Add Food");

        TextView FoodLabel = findViewById(R.id.FoodLabel);
        TextView Calories = findViewById(R.id.CalorieNumID);
        TextView Protein = findViewById(R.id.ProteinNumID);
        TextView Cholesterol = findViewById(R.id.ChoNumID);
        TextView Fiber = findViewById(R.id.FibNumID);
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
                selectedFood = new FoodItem(selectedFood, num);
                Calories.setText("" + selectedFood.getCalories() + " kcal");
                Protein.setText("" + selectedFood.getProtein() + " g");
                Cholesterol.setText("" + selectedFood.getCholesterol() + " g");
                Fiber.setText("" + selectedFood.getFiber() + " g");
                dropdownNum.setText("" + num);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ImageButton checkButton = findViewById(R.id.idDoneButton);
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add timestamp to foodItem
                String time = getTimeStamp();
                selectedFood.setTime(time);
                //add selectedFood to the Database
                db.collection("users").document(user.getUid()).collection("foodlist").add(selectedFood);

                Toast.makeText(AddFood.this, "FOOD ADDED", Toast.LENGTH_SHORT).show();


            }
        });


        String label = selectedFood.getLabel();
        FoodLabel.setText("" + label);
        int cal = selectedFood.getCalories();
        Calories.setText("" + cal);
        int pro = selectedFood.getProtein();
        Protein.setText("" + pro);
        int cho = selectedFood.getCholesterol();
        Cholesterol.setText("" + cho);
        int fib = (int) selectedFood.getFiber();
        Fiber.setText("" + fib);


    }
    public static String getTimeStamp() {
        Time now = new Time();
        now.setToNow();
        String sTime = now.format("%Y_%m_%d_%H_%M_%S");
        return sTime;
    }
}
