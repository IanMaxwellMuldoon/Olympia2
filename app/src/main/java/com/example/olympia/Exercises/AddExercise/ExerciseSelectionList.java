package com.example.olympia.Exercises.AddExercise;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.olympia.Exercises.AddExercises;
import com.example.olympia.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


public class ExerciseSelectionList
        extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener {
    // Create string array of body parts to choose from
    String[] bodyParts = {
            "abs",
            "back",
            "biceps",
            "calves",
            "chest",
            "forearms",
            "legs",
            "shoulders",
            "traps",
            "triceps"
    };

    private FirebaseAuth mAuth;
    private FirebaseFirestore db;
    private String bodyPart;
    ListView exerciseSelectionListView;
    ArrayList<ExerciseSelectionDataModel> exerciseSelectionDataModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_selection_list);

        // For toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Select Exercise");

        // Initialize the variables
        exerciseSelectionListView = findViewById(R.id.bodyPartExerciseListView);
        exerciseSelectionDataModelArrayList = new ArrayList<>();

        // Get the instance of our Firestore database
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        db = FirebaseFirestore.getInstance();

        // Hook to spinner object
        Spinner bodyPartSpinner = (Spinner) findViewById(R.id.bodyPartSpinner);
        bodyPartSpinner.setOnItemSelectedListener(this);

        // Create an ArrayAdapter to hold the list of body parts
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item,
                bodyParts);

        // Set a simple layout for each spinner item
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Set the array adapter info on the spinner
        bodyPartSpinner.setAdapter(arrayAdapter);

        // Provide an option to go to the new workout plan menu if there is no stored workout plans
        // in the user's database
        Button addCustomExerciseBtn = (Button) findViewById(R.id.addCustomExerciseBtn);
        addCustomExerciseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExerciseSelectionList.this, AddExercises.class);
                startActivity(intent);
            }
        });
    } // End of onCreate()

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        Toast.makeText(getApplicationContext(), bodyParts[position], Toast.LENGTH_LONG).show();
        // Set bodyPart to currently selected item in spinner to be used in db query
        bodyPart = bodyParts[position];
        // First clear the exercises ListView in case there is data already
        exerciseSelectionListView.setAdapter(null);
        // Clear the exercise array list to allow for new exercises to populate it when the
        // user changes their body part selection
        exerciseSelectionDataModelArrayList.clear();
        // Method call to load the data from our database into the list view
        loadDataInListView();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    private void loadDataInListView() {
        db.collection("exerciseDB")
                .document(bodyPart)
                .collection("exerciseList")
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        // Ensure that the query to the database doesn't return an empty value
                        if (!queryDocumentSnapshots.isEmpty()) {
                            // Add all the possible workout plans stored in the user's database to a list
                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                            for (DocumentSnapshot doc : list) {
                                // Take the data received from the database and pass it to the workout
                                // plan helper class to parse the data
                                ExerciseSelectionDataModel dataModal = doc.toObject(ExerciseSelectionDataModel.class);
                                // Store the data received from the database into our array list
                                exerciseSelectionDataModelArrayList.add(dataModal);
                            } // End of for loop

                            // Pass the array list to the workout plan adapter class
                            ExerciseSelectionAdapter adapter = new ExerciseSelectionAdapter(ExerciseSelectionList.this, exerciseSelectionDataModelArrayList);
                            // Set the workout plan adapter to our list view for displaying the CardViews
                            exerciseSelectionListView.setAdapter(adapter);
                        } else {
                            // Testing message
                            Toast.makeText(ExerciseSelectionList.this, "No data found in Database", Toast.LENGTH_SHORT).show();
                        }
                    } // End of onSuccess()
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Display an error message if we fail to establish a connection to the database
                        Toast.makeText(ExerciseSelectionList.this, "Failed to load data..", Toast.LENGTH_SHORT).show();
                    }
                });
    } // End of loadDataInListView()
}