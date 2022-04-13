package com.example.olympia.ViewHistory.WorkoutPlanHistory;

import android.util.Log;

public class WorkoutPlanDataModal {
    private String date;
    private String planName;
//    private List<String> exercises;
    private String exerciseName;
    private String sets;

    // Empty Constructor
    public WorkoutPlanDataModal() {
    }

//    public WorkoutPlanDataModal(String date, String planName) {
//        this.date = date;
//        this.planName = planName;
//    }

    public WorkoutPlanDataModal(String date, String planName, String exerciseName, String sets) {
        this.date = date;
        this.planName = planName;
        this.exerciseName = exerciseName;
        this.sets = sets;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public String getSets() {
        return sets;
    }

    public void setSets(String sets) {
        this.sets = sets;
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
