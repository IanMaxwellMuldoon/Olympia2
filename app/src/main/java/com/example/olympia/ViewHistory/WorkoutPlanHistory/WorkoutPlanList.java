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

import com.example.olympia.Exercises.PlanMenu;
import com.example.olympia.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class WorkoutPlanList extends AppCompatActivity {
    // Variables
    ListView planListView;
    ArrayList<WorkoutPlanDataModal> planDataModalArrayList;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_history_workout_plan_list);

        // For toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("History");

        // Inilialize the variables

        // Get data from Firestore Database to populate workout plan list
        DocumentReference docRef = FirebaseFirestore.getInstance().collection("users").document("1IiJknuI0cW3GnRI2sCII9i6KSR2").collection("workoutData").document("plan1");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot doc = task.getResult();
                    if (doc.exists()) {
                        Log.d("Document", doc.getData().toString());
                    } else {
                        Log.d("Document", "No Data");
                    }
                }
            }
        });

        // Provide an option to go to the new workout plan menu if there is no stored workout plans
        // in the user's database
        Button planMenuBtn = (Button)findViewById(R.id.planMenuBtn);
        planMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WorkoutPlanList.this, PlanMenu.class);
                startActivity(intent);
            }
        });
    }
}