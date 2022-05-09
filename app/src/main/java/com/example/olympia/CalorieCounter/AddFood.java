package com.example.olympia.CalorieCounter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import android.widget.TextView;
import android.widget.Toast;

import com.example.olympia.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import android.text.format.Time;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddFood
        extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener {
    private int num = 1;
    private FoodItem selectedFood;
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;
    private String time;
    private Calendar calendar;
    private SimpleDateFormat dateFormat;
    private String date, userid;
    private Spinner servingDropDown;
    private String[] numServingsArr = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    private String serving;
    private TextView FoodLabel;
    private TextView Calories;
    private TextView Protein;
    private TextView Cholesterol;
    private TextView Fiber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);
        calendar = Calendar.getInstance();
        dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        date = SimpleDateFormat.getDateInstance().format(calendar.getTime());
        mAuth = FirebaseAuth.getInstance();
        userid = mAuth.getCurrentUser().getUid();

        db = FirebaseFirestore.getInstance();

        TextView dropdownNum = findViewById(R.id.iddropNum);
        //for toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Add Food");

        FoodLabel = findViewById(R.id.FoodLabel);
        Calories = findViewById(R.id.CalorieNumID);
        Protein = findViewById(R.id.ProteinNumID);
        Cholesterol = findViewById(R.id.ChoNumID);
        Fiber = findViewById(R.id.FibNumID);

        // Hook to spinner object
        servingDropDown = (Spinner) findViewById(R.id.idSpinner);
        servingDropDown.setOnItemSelectedListener(this);

        // Create an ArrayAdapter to hold the list of food servings
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.spinner_item,
                numServingsArr);

        // Set a simple layout for each spinner item
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Set the array adapter info on the spinner
        servingDropDown.setAdapter(adapter);

        selectedFood = new FoodItem();
        selectedFood = ResultList.selectedFood;

//        ImageButton checkButton = findViewById(R.id.idDoneButton);
        Button addFoodBtn = findViewById(R.id.idDoneButton);
        addFoodBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add timestamp to foodItem
                String time = getTimeStamp();
                selectedFood.setTime(time);

                //set the date to the current date
                selectedFood.setDate(date);

                //set user id to to the current users id
                selectedFood.setUserid(userid);

                //add selectedFood to the Database
                //db.collection("users").document(user.getUid()).collection("foodlist").add(selectedFood);
                //to make document id the current date in the form of "Month day, year" example "Apr 16, 2022"
                //db.collection("users").document(user.getUid()).collection("foodlist").document("Apr 16, 2022").set(selectedFood);
                //need to add userid and date to selectedFood
                db.collection("food").add(selectedFood);

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
    } // Endo of onCreate()

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        Toast.makeText(getApplicationContext(), bodyParts[position], Toast.LENGTH_LONG).show();
        // Set bodyPart to currently selected item in spinner to be used in db query
        serving = numServingsArr[position];

        selectedFood = ResultList.selectedFood;
        String servingNum = servingDropDown.getSelectedItem().toString();
        num = Integer.parseInt(servingNum);
        selectedFood = new FoodItem(selectedFood, num);
        Calories.setText("" + selectedFood.getCalories() + " kcal");
        Protein.setText("" + selectedFood.getProtein() + " g");
        Cholesterol.setText("" + selectedFood.getCholesterol() + " g");
        Fiber.setText("" + selectedFood.getFiber() + " g");
//        dropdownNum.setText("" + num);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    public static String getTimeStamp() {
        Time now = new Time();
        now.setToNow();
        String sTime = now.format("%Y_%m_%d_%H_%M_%S");
        return sTime;
    }
}
