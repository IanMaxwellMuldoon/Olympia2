package com.example.olympia.Exercises;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


import com.example.olympia.Exercises.LogExercise.LogExercises;
import com.example.olympia.R;
import com.example.olympia.ViewHistory.WorkoutPlanHistory.WorkoutPlanHistoryExerciseList;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


public class PlanListFragment extends Fragment {

    private ListView listView;

    private ArrayList<Plan> planList;
    private Plan selectedPlan;
    private DocumentReference docRef;
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;
    private String currentUser;
    private ArrayList<Plan> tempList;

    public PlanListFragment() {
        // Required empty public constructor
    }

    private Exercise exercise;
    private ArrayList<Exercise> exercises;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Get the instance of our Firestore database
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        db = FirebaseFirestore.getInstance();
        // Get the user id of whomever is logged into the app currently
        currentUser = user.getUid();

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_plan_list, container, false);
        //


        exercises = new ArrayList<Exercise>();
        exercises.add(new Exercise("Tricep", 3, 8, 80));
        exercises.add(new Exercise("Pushups", 2, 10, 180));
        exercises.add(new Exercise("Shoulder Press", 5, 8, 135));



        planList = new ArrayList<Plan>();
        planList.add(new Plan("Push", exercises));
        planList.add(new Plan("Pull", exercises));
        planList.add(new Plan("Upper Body", exercises));







        //setting listview and adapter for search results
        listView = (ListView) view.findViewById(R.id.PlanListView);

        loadPlansInFragment();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                selectedPlan = (Plan)parent.getAdapter().getItem(position);
                Intent intent = new Intent(getContext(), LogExercises.class);
                intent.putExtra("Example", selectedPlan);

                startActivity(intent);


            }
        });


        return view;
    }

    private void loadPlansInFragment() {
        System.out.println("You are inside loadsPlanInFragment");
        db.collection("users")
                .document(currentUser)
                .collection("plans")
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot documentSnapshots) {
                        if(documentSnapshots.isEmpty()) {
                            System.out.println("List empty");
                            return;
                        } else {
                            List<Plan> types = documentSnapshots.toObjects(Plan.class);
                            planList.addAll(types);
                            for (int i = 0; i < planList.size(); i++) {
                                System.out.println(planList.get(i).getTitle());

                            }
                            setPlanList(planList);
                            PlanAdapter planAdapter = new PlanAdapter(getActivity().getApplicationContext(), R.layout.plan_item, planList);
                            listView.setAdapter(planAdapter);

                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {


                    }
                });

    }

    public void setPlanList (ArrayList<Plan> arrayList) {
        this.planList = arrayList;

    }


}