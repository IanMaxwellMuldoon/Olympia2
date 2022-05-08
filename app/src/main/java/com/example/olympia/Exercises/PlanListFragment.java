package com.example.olympia.Exercises;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
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
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;
    private String currentUser;
    private String currentPlan;


    public PlanListFragment() {
        // Required empty public constructor
    }

    private Exercise exercise;
    private ArrayList<Exercise> exercises;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        System.out.println("I am in side of fraglist on create");

        // Get the instance of our Firestore database
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        db = FirebaseFirestore.getInstance();
        // Get the user id of whomever is logged into the app currently
        currentUser = user.getUid();

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_plan_list, container, false);
        //

        planList = new ArrayList<Plan>();

        //setting listview and adapter for search results
        listView = (ListView) view.findViewById(R.id.PlanListView);

        loadPlansInFragment();



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("You are here");
                    currentPlan = db.collection()


                    selectedPlan = (Plan)parent.getAdapter().getItem(position);
                    planList.remove(selectedPlan);
                    deleteData(selectedPlan.getTitle());

                PlanAdapter planAdapter = new PlanAdapter(getActivity().getApplicationContext(), R.layout.plan_item, planList);
                listView.setAdapter(planAdapter);


                    selectedPlan = (Plan)parent.getAdapter().getItem(position - 1);
                    Intent intent = new Intent(getContext(), LogExercises.class);
                    intent.putExtra("Example", selectedPlan);

                    //startActivity(intent);







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

    private void deleteData(String title) {
        db.collection("users")
                .document(currentUser)
                .collection("plans")
                .document("(document.documentID)")
                .delete()
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {

                        System.out.println("DocumentSnapshot successfully deleted!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        System.out.println("Error deleting document " + e);
                    }
                });

    }

    public void setPlanList (ArrayList<Plan> arrayList) {
        this.planList = arrayList;

    }




}