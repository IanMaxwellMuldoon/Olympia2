package com.example.olympia.Exercises.AddExercise;

public class ExerciseSelectionDataModel {
    private String exerciseName;

    // Default constructor
    public ExerciseSelectionDataModel() {
    }

    // Regular constructor
    public ExerciseSelectionDataModel(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }
}
