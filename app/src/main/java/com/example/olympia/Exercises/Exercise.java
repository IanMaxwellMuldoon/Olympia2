package com.example.olympia.Exercises;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.fragment.app.Fragment;

public class Exercise implements Parcelable {
    private String title;
    private int numSets;
    private int numReps;
    private int weight;
    private int progressSetCount;


    public Exercise(){
    title = null;
    numSets = 0;
    numReps = 0;
    weight = 0;

       progressSetCount = 0;

    }

    public Exercise(String title, int numSets, int numReps, int weight){
        this.title = title;
        this.numSets = numSets;
        this.numReps = numReps;
        this.weight = weight;
        progressSetCount = 0;
    }
    public Exercise(String title){
        this.title = title;
    }

    protected Exercise(Parcel in) {
        title = in.readString();
        numSets = in.readInt();
        numReps = in.readInt();
        weight = in.readInt();
    }

    public static final Creator<Exercise> CREATOR = new Creator<Exercise>() {
        @Override
        public Exercise createFromParcel(Parcel in) {
            return new Exercise(in);
        }

        @Override
        public Exercise[] newArray(int size) {
            return new Exercise[size];
        }
    };

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }
    public int getProgressCount() {
        return progressSetCount;
    }

    public void setProgressCount(int progressCount) {
        this.progressSetCount = progressCount;
    }
    public void incrementProgressCount(){
        progressSetCount++;
    }
    public void decrementProgressCount(){
        progressSetCount--;
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
    public String getRepSetWeight(){
        return getNumSets() + "x" + getNumReps() + " " + getWeight() + "lbs";
    }

    public void setRepSetWeight() {


    }
   // public Fragment get

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
    }
}
