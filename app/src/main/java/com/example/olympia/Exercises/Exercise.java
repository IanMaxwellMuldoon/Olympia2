package com.example.olympia.Exercises;

public class Exercise {
    private String title;
    private int numSets;
    private int numReps;
    private int weight;

    public Exercise(){
    title = null;
    numSets = 0;
    numReps = 0;
    weight = 0;
    }

    public Exercise(String title, int numSets, int numReps, int weight){
        this.title = title;
        this.numSets = numSets;
        this.numReps = numReps;
        this.weight = weight;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumSets() {
        return numSets;
    }

    public void setNumSets(int numSets) {
        this.numSets = numSets;
    }

    public int getNumReps() {
        return numReps;
    }

    public void setNumReps(int numReps) {
        this.numReps = numReps;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
