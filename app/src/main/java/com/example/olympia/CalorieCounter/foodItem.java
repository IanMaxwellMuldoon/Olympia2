package com.example.olympia.CalorieCounter;

import android.os.Parcel;
import android.os.Parcelable;

public class foodItem implements Parcelable {
    private  String label = null;
    private int calories;
    private int protien;
    private int fat;
    private double fiber;
    private int cholesterol;

    public foodItem(String label, int cal, int ptn, int fat, double fib, int cho){
        this.label = label;
        calories = cal;
        protien = ptn;
        this.fat = fat;
        fiber = fib;
        cholesterol = cho;
    }


    protected foodItem(Parcel in) {
        label = in.readString();
        calories = in.readInt();
        protien = in.readInt();
        fat = in.readInt();
        fiber = in.readDouble();
        cholesterol = in.readInt();
    }

    public static final Creator<foodItem> CREATOR = new Creator<foodItem>() {
        @Override
        public foodItem createFromParcel(Parcel in) {
            return new foodItem(in);
        }

        @Override
        public foodItem[] newArray(int size) {
            return new foodItem[size];
        }
    };

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getProtien() {
        return protien;
    }

    public void setProtien(int protien) {
        this.protien = protien;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public double getFiber() {
        return fiber;
    }

    public void setFiber(double fiber) {
        this.fiber = fiber;
    }

    public int getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(int cholesterol) {
        this.cholesterol = cholesterol;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(label);
        dest.writeInt(calories);
        dest.writeInt(protien);
        dest.writeInt(fat);
        dest.writeDouble(fiber);
        dest.writeInt(cholesterol);
    }
}
