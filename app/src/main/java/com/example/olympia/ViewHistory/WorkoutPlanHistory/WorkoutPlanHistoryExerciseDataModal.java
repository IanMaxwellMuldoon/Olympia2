package com.example.olympia.ViewHistory.WorkoutPlanHistory;

public class WorkoutPlanHistoryExerciseDataModal {
    Long numReps;
    Long numSets;
//    String progressCount;
    String repSetWeight;
    String title;
    Long weight;

    // Empty constructor
    public WorkoutPlanHistoryExerciseDataModal() {
    }

    public WorkoutPlanHistoryExerciseDataModal(Long numReps, Long numSets, String repSetWeight, String title, Long weight) {
        this.numReps = numReps;
        this.numSets = numSets;
        this.repSetWeight = repSetWeight;
        this.title = title;
        this.weight = weight;
    }

    public Long getNumReps() {
        return numReps;
    }

    public void setNumReps(Long numReps) {
        this.numReps = numReps;
    }

    public Long getNumSets() {
        return numSets;
    }

    public void setNumSets(Long numSets) {
        this.numSets = numSets;
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

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }
}
