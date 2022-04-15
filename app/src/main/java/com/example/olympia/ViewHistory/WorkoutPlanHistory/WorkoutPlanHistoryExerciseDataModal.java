package com.example.olympia.ViewHistory.WorkoutPlanHistory;

public class WorkoutPlanHistoryExerciseDataModal {
//    String numReps;
//    String numSets;
//    String progressCount;
    String repSetWeight;
    String title;
//    String weight;

    // Empty constructor
    public WorkoutPlanHistoryExerciseDataModal() {
    }

    public WorkoutPlanHistoryExerciseDataModal(String repSetWeight, String title) {
        this.repSetWeight = repSetWeight;
        this.title = title;
    }

    public String getRepSetWeight() {
        return repSetWeight;
    }

    public void setRepSetWeight(String repSetWeight) {
        this.repSetWeight = repSetWeight;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
