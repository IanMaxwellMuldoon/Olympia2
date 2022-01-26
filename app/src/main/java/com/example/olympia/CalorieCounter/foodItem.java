package com.example.olympia.CalorieCounter;

import android.os.Parcel;
import android.os.Parcelable;

public class foodItem  {
    private  String label = null;
    private int calories;
    private int protein;
    private int fat;
    private double fiber;
    private int cholesterol;
    private String brand;

    public foodItem(String label, String brand, int cal, int ptn, int fat, double fib, int cho){
        this.label = label;
        this.brand = brand;
        calories = cal;
        protein = ptn;
        this.fat = fat;
        fiber = fib;
        cholesterol = cho;
    }

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

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
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
    public String toString(){
        return label;
    }

    public String getSubTitle(){
        if(brand != null) {
            return "Brand: " + getBrand() + ", Calories: " + getCalories();
        }else{
            return "Calories: " + getCalories();
        }
    }

    public int describeContents() {
        return 0;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
