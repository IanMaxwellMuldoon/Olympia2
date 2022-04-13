package com.example.olympia.ViewHistory.WorkoutPlanHistory;

public class WorkoutPlanDataModal {
    private String date;
    private String planName;
    private String exerciseName;
    private String sets;
    private String weight;
    private String time;

    // Empty Constructor
    public WorkoutPlanDataModal() {
    }

    public WorkoutPlanDataModal(String date, String planName, String exerciseName, String sets, String weight, String time) {
        this.date = date;
        this.planName = planName;
        this.exerciseName = exerciseName;
        this.sets = sets;
        this.weight = weight;
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
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
