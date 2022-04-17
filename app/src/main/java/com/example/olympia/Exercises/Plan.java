package com.example.olympia.Exercises;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Plan implements Parcelable {
    private String title;
    private ArrayList<Exercise> exerciseArrayList = new ArrayList<Exercise>();

    public Plan (String title) {
       this.title = title;
       exerciseArrayList = null;
    }

    public Plan(String title, ArrayList<Exercise> arrayList){
        this.title = title;
        this.exerciseArrayList = arrayList;
    }


    protected Plan(Parcel in) {
        title = in.readString();
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

    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Exercise> getExerciseArrayList() {
        return exerciseArrayList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeTypedList(exerciseArrayList);
    }




}
