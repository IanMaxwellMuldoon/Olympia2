package com.example.olympia.ViewHistory.WorkoutPlanHistory;

public class WorkoutPlanHistoryExerciseDataModal {
    private Long numReps;
    private Long numSets;
    private Long weight;
    private Long progressCount;
    private String repSetWeight;
    private String title;

    // Empty constructor
    public WorkoutPlanHistoryExerciseDataModal() {
    }

    public WorkoutPlanHistoryExerciseDataModal(Long numReps, Long numSets, Long weight, Long progressCount, String repSetWeight, String title) {
        this.numReps = numReps;
        this.numSets = numSets;
        this.weight = weight;
        this.progressCount = progressCount;
        this.repSetWeight = repSetWeight;
        this.title = title;
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

    public Long getProgressCount() {
        return progressCount;
    }

    public void setProgressCount(Long progressCount) {
        this.progressCount = progressCount;
    }
}
