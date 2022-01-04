package com.example.olympia.Exercises;

import java.util.ArrayList;

public class Plan {
    private String title;
    private ArrayList<Exercise> exerciseArrayList = new ArrayList<Exercise>();

    public Plan(){
        title = null;
        exerciseArrayList = null;
    }
    public Plan(String title, ArrayList<Exercise> exerciseArrayList){
        this.title = title;
        this.exerciseArrayList = exerciseArrayList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Exercise> getExerciseArrayList() {
        return exerciseArrayList;
    }

    public void setExerciseArrayList(ArrayList<Exercise> exerciseArrayList) {
        this.exerciseArrayList = exerciseArrayList;
    }
}
