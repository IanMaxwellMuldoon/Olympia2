package com.example.olympia.ViewHistory.WorkoutPlanHistory;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.olympia.Exercises.PlanMenu;
import com.example.olympia.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class WorkoutPlanList extends AppCompatActivity {
    // Variables
    ListView planListView;
    ListView exercisesListView;
    ArrayList<WorkoutPlanDataModal> planDataModalArrayList;
    FirebaseFirestore db;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_history_workout_plan_list);

        // For toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("History");

        // Initialize the variables
        planListView = findViewById(R.id.idworkoutPlanListView);
        exercisesListView = findViewById(R.id.idExercisesListView);
        planDataModalArrayList = new ArrayList<>();

        // Get the instance of our Firestore database
        db = FirebaseFirestore.getInstance();

        // Method call to load the data from our database into the list view
        loadDataInListView();

        // Provide an option to go to the new workout plan menu if there is no stored workout plans
        // in the user's database
        Button planMenuBtn = (Button) findViewById(R.id.planMenuBtn);
        planMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WorkoutPlanList.this, PlanMenu.class);
                startActivity(intent);
            }
        });
    } // End of onCreate()

    private void loadDataInListView() {
        db.collection("users")
                .document("1IiJknuI0cW3GnRI2sCII9i6KSR2")
                .collection("workoutData")
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        // Ensure that the query to the database doesn't return an empty value
                        if (!queryDocumentSnapshots.isEmpty()) {
                            // Add all the possible workout plans stored in the user's database to a list
                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                            for (DocumentSnapshot d : list) {
                                // Take the data received from the database and pass it to the workout
                                // plan helper class to parse the data
                                WorkoutPlanDataModal dataModal = d.toObject(WorkoutPlanDataModal.class);

                                // Store the data received from the database into our array list
                                planDataModalArrayList.add(dataModal);
                            }

                            // Pass the array list to the workout plan adapter class
                            WorkoutPlanAdapter adapter = new WorkoutPlanAdapter(WorkoutPlanList.this, planDataModalArrayList);
                            // Pass exercise info to its adapter class

                            WorkoutPlanExercisesAdapter adapterExercises = new WorkoutPlanExercisesAdapter(WorkoutPlanList.this, planDataModalArrayList);

                            // TESTING STUFF

                            Log.d("TEST", "-->-->--> : planListView" + planListView);
                            Log.d("TEST", "-->-->--> : exercisesListView" + exercisesListView);


                            // END OF TESTING STUFF
                            // Set the workout plan adapter to our list view for displaying the CardViews
                            planListView.setAdapter(adapter);
                            // Set the exercise adapter to the sub-list view inside of the CardView elements
//                            exercisesListView.setAdapter(adapterExercises);
                        } else {
                            // Testing message
                            Toast.makeText(WorkoutPlanList.this, "No data found in Database", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                // Display an error message if we fail to establish a connection to the database
                Toast.makeText(WorkoutPlanList.this, "Failed to load data..", Toast.LENGTH_SHORT).show();
            }
        });
    } // End of loadDataInListView()
}