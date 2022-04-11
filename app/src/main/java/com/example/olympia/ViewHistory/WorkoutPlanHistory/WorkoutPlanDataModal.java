package com.example.olympia.ViewHistory.WorkoutPlanHistory;

import android.util.Log;

public class WorkoutPlanDataModal {
    private String date;
    private String planName;
//    private List<String> exercises;
    private String exercise1;

    // Empty Constructor
    public WorkoutPlanDataModal() {
    }

//    public WorkoutPlanDataModal(String date, String planName) {
//        this.date = date;
//        this.planName = planName;
//    }

    public WorkoutPlanDataModal(String date, String planName, String exercise1) {
        this.date = date;
        this.planName = planName;
        this.exercise1 = exercise1;
    }

    // Test Constructor to test getting exercises from database
//    public WorkoutPlanDataModal(String date, String planName, List<String> exercises) {
//        this.date = date;
//        this.planName = planName;
//        this.exercises = exercises;
//    }
//
//    public List<String> getExercises() {
//        return exercises;
//    }
//
//    public void setExercises(List<String> exercises) {
//        this.exercises = exercises;
//    }

    public String getExercise1() {
        Log.d("Document", "-->-->-->EXERCISE NAME " + exercise1);
        return exercise1;
    }

    public void setExercise1(String exercise1) {
        this.exercise1 = exercise1;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }
}
