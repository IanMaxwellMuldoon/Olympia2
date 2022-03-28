 package com.example.olympia.Exercises;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.olympia.R;

import java.util.ArrayList;


 public class ExerciseListFragment extends Fragment {
    ListView listView;
    ArrayList<Exercise> exerciseList;


     public ExerciseListFragment() {
     }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Bundle data = getArguments();
        //String name = data.getString("name");


        Log.d("Msg", "I am before try catch ");
        try{
            Exercise exercise = this.getArguments().getParcelable("exerciseData");
            Log.d("Message", "I am in here spooky");
            exerciseList.add(exercise);
        }
        catch(NullPointerException e){
            Log.d("Msg", "NullPointerException" + e);

        }


        View view = inflater.inflate(R.layout.fragment_exercise_list, container, false);
        exerciseList = new ArrayList<Exercise>();
        exerciseList.add(new Exercise("push ups"));
        exerciseList.add(new Exercise("Bench"));
        exerciseList.add(new Exercise("Legs"));
        exerciseList.add(new Exercise("push ups"));
        Log.d("Msg", "I am before bundle. Did I get here?");





        listView = view.findViewById(R.id.idExerciseList);
        ExerciseAdapter exerciseAdapter= new ExerciseAdapter(getActivity().getApplicationContext(), R.layout.plan_item, exerciseList);
        listView.setAdapter(exerciseAdapter);



        return view;
    }
}