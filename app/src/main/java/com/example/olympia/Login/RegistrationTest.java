package com.example.olympia.Login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import com.example.olympia.R;

import com.example.olympia.CalorieCounter.CalorieCounterSearch;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;


public class RegistrationTest extends AppCompatActivity {

    TextView heightTextView;
    TextView weightTextView;
    TextView ageTextView;
    TextView goalTextView;

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        heightTextView = findViewById(R.id.heightTextView);
        weightTextView = findViewById(R.id.weightTextView);
        ageTextView = findViewById(R.id.ageTextView);
        goalTextView = findViewById(R.id.goalTextView);

        CalorieCounterSearch calorie = new CalorieCounterSearch();

        mAuth = FirebaseAuth.getInstance();

        FirebaseUser user = mAuth.getCurrentUser();

        if (user != null) {
            FirebaseFirestore db = FirebaseFirestore.getInstance();

            db.collection("users").whereEqualTo("uid", user.getUid())
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                if (task.getResult().size() > 0) {
                                    DocumentSnapshot document = task.getResult().getDocuments().get(0);

                                    heightTextView.setText(document.get("height", String.class));
                                    weightTextView.setText(document.get("weight", String.class));
                                    ageTextView.setText(document.get("age", String.class));
                                    goalTextView.setText(document.get("goal", String.class));
                                }
                            }
                        }
                    });
        }



    }
}