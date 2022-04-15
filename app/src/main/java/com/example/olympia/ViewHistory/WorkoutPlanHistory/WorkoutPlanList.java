package com.example.olympia.ViewHistory.WorkoutPlanHistory;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.olympia.Exercises.Exercise;
import com.example.olympia.Exercises.PlanMenu;
import com.example.olympia.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class WorkoutPlanList extends AppCompatActivity {
    // Variables
    ListView planListView;
    CardView exerciseListCardView;
    ArrayList<WorkoutPlanDataModal> planDataModalArrayList;
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;
    private String str_user;
    ArrayList<String> docName;
    String planName;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workout_plan_history);

        // For toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Workout History");

        // Initialize the variables
        planListView = findViewById(R.id.idworkoutPlanListView);
        exerciseListCardView = findViewById(R.id.exerciseHistoryCardView);
//        exercisesListView = findViewById(R.id.idExercisesListView);
        planDataModalArrayList = new ArrayList<>();

        // Get the instance of our Firestore database
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        db = FirebaseFirestore.getInstance();
        //TODO: Remove the hardcoded user path that's used for testing purposes
//        str_user = "1IiJknuI0cW3GnRI2sCII9i6KSR2";
        str_user = "1HwFXjkjOpSvBad3lT07svHmaMi1";
//        Log.d("TEST", "--> mAuth: " + mAuth);

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
                .document(str_user)
                .collection("LoggedWorkouts")
//                .collection("workoutData")
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
//                                docName.add(d.getId().toString());
//                                docName = d.getId();
                                Log.d("TEST", "document name: " + docName);


                                planName = d.getId();
                                // Store the data received from the database into our array list
                                planDataModalArrayList.add(dataModal);
                            } // End of for loop

                            // Pass the array list to the workout plan adapter class
                            WorkoutPlanAdapter adapter = new WorkoutPlanAdapter(WorkoutPlanList.this, planDataModalArrayList);
                            // Set the workout plan adapter to our list view for displaying the CardViews
                            planListView.setAdapter(adapter);
                        } else {
                            // Testing message
                            Toast.makeText(WorkoutPlanList.this, "No data found in Database", Toast.LENGTH_SHORT).show();
                        }
                    } // End of onSuccess()
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                // Display an error message if we fail to establish a connection to the database
                Toast.makeText(WorkoutPlanList.this, "Failed to load data..", Toast.LENGTH_SHORT).show();
            }
        });
    } // End of loadDataInListView()
}