package com.example.olympia.ViewHistory.WorkoutPlanHistory;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

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

public class WorkoutPlanHistoryExerciseList extends AppCompatActivity {
    ListView exercisesListView;
    ArrayList<WorkoutPlanDataModal> planDataModalArrayList;
    ArrayList<WorkoutPlanHistoryExerciseDataModal> exerciseDataModalArrayList;
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;
    private String currentUser;
    private String docName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workout_plan_history_exercises_list);
        // Get data from WorkoutPlanList
        Intent intent = getIntent();
        String planName = intent.getStringExtra("planName");
        docName = intent.getStringExtra("docName");

        // For toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(planName);

        // Initialize the variables
        exercisesListView = findViewById(R.id.workoutHistoryPlanExerciseListView);
        planDataModalArrayList = new ArrayList<>();
        exerciseDataModalArrayList = new ArrayList<>();

        // Get the instance of our Firestore database
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        db = FirebaseFirestore.getInstance();
        // Get the user id of whomever is logged into the app currently
        currentUser = user.getUid();

        // Method call to load the data from our database into the list view
        loadDataInListView();
    } // End of onCreate()

    private void loadDataInListView() {
        // Test query for getting exercises
        db.collection("users")
                .document(currentUser)
                .collection("LoggedWorkouts")
                .document(docName)
                .collection("exercises")
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if (!queryDocumentSnapshots.isEmpty()) {
                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                            for (DocumentSnapshot doc : list) {
                                WorkoutPlanHistoryExerciseDataModal exerciseModal = doc.toObject(WorkoutPlanHistoryExerciseDataModal.class);
                                exerciseDataModalArrayList.add(exerciseModal);
                            } // End of for loop

                            // Pass the array list to the workout plan exercise adapter class
                            WorkoutPlanExercisesAdapter adapterExercises = new WorkoutPlanExercisesAdapter(WorkoutPlanHistoryExerciseList.this, exerciseDataModalArrayList);
                            // Set the exercise adapter to the sub-list view inside of the CardView elements
                            exercisesListView.setAdapter(adapterExercises);
                        }
                    } // End of onSuccess()
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Display an error message if we fail to establish a connection to the database
                        Toast.makeText(WorkoutPlanHistoryExerciseList.this, "Failed to load data..", Toast.LENGTH_SHORT).show();
                    }
                });
    } // End of loadDataInListView()
}