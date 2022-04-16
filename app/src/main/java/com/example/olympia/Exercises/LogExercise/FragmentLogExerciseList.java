package com.example.olympia.Exercises.LogExercise;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.text.format.Time;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.olympia.Exercises.Exercise;
import com.example.olympia.Exercises.Plan;
import com.example.olympia.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


public class FragmentLogExerciseList extends Fragment {
    private ListView listView;
    private ArrayList<Exercise> exerciseList;
    private Button doneButton;

    private FirebaseAuth mAuth;
    private FirebaseFirestore db;


    public FragmentLogExerciseList() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       try {
           View view = inflater.inflate(R.layout.fragment_log_exercise_list, container, false);

           mAuth = FirebaseAuth.getInstance();
           FirebaseUser user = mAuth.getCurrentUser();

           db = FirebaseFirestore.getInstance();

           Intent i = getActivity().getIntent();

           Plan plan = (Plan)i.getParcelableExtra("Plan");
           exerciseList = plan.getExerciseArrayList();


           LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
           listView = view.findViewById(R.id.idLogExerciseList);
           LogExerciseAdapter logAdapter = new LogExerciseAdapter(getActivity().getApplicationContext(), R.layout.exercise_log_item, exerciseList);
           listView.setAdapter(logAdapter);

           doneButton = view.findViewById(R.id.idLogDoneButton);
           doneButton.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Log.d("message", "" + exerciseList.get(0).getProgressCount());
                   String time = getTimeStamp();
                   String date = getDate();
                   //add logged exercise to database
                   for(int j = 0; j < exerciseList.size(); j++){
                       db.collection("users").document(user.getUid()).collection("LoggedWorkouts").document(plan.getTitle()+time).collection("exercises").add(exerciseList.get(j));
                   }
                   Map<String,String> data = new HashMap<>();
                   data.put("time", date);
                   data.put("planName", plan.getTitle());
                   db.collection("users").document(user.getUid()).collection("LoggedWorkouts").document(plan.getTitle()+time).set(data);
               }
           });




           return view;
       }catch (Exception e){
           Log.e("OnCreateView", String.valueOf(e));
           throw e;
       }
    }
    public static String getTimeStamp() {
        Time now = new Time();
        now.setToNow();
        String sTime = now.format("%Y_%m_%d_%H_%M_%S");
        return sTime;
    }

    private static String getDate() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");

        return dateFormat.format(cal.getTime());
    }

}