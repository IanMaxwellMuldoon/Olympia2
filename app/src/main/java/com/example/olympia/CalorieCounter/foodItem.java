package com.example.olympia.CalorieCounter;

public class foodItem {
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
}
