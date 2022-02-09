package com.example.olympia.Exercises;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Plan implements Parcelable {
    private String title;
    private int numSets;
    private int numReps;
    private int weight;
    private ArrayList<Exercise> exerciseArrayList = new ArrayList<Exercise>();

    public Plan(String legs){
        title = null;
        numSets = 0;
        numReps = 0;
        weight = 0;
        exerciseArrayList = null;
    }

    protected Plan(Parcel in) {
        title = in.readString();
        numSets = in.readInt();
        numReps = in.readInt();
        weight = in.readInt();
        exerciseArrayList = in.createTypedArrayList(Exercise.CREATOR);
    }

    public static final Creator<Plan> CREATOR = new Creator<Plan>() {
        @Override
        public Plan createFromParcel(Parcel in) {
            return new Plan(in);
        }

        @Override
        public Plan[] newArray(int size) {
            return new Plan[size];
        }
    };

    public static String getTitle() {
        return "yuh";
    }

    public int getNumSets(){
        return 0;

    }

    public int getWeight(){
        return 0;

    }

    public int getNumReps(){
        return 0;

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeInt(numSets);
        dest.writeInt(numReps);
        dest.writeInt(weight);
        dest.writeTypedList(exerciseArrayList);
    }
}
