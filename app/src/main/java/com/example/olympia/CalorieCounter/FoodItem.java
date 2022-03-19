package com.example.olympia.CalorieCounter;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class FoodItem {
    public String getFoodID() {
        return foodID;
    }

    public void setFoodID(String foodID) {
        this.foodID = foodID;
    }

    private String foodID;
    private  String label = null;
    private int calories;
    private int protein;
    private int fat;
    private double fiber;
    private int cholesterol;
    private String brand;

    //empty constructor
    public FoodItem(){
    }

    public FoodItem(String FoodID, String label){
        this.foodID = foodID;
        this.label = label;
    }

    public FoodItem(String FoodID, String label, String brand, int cal, int ptn, int fat, double fib, int cho){
        this.foodID = foodID;
        this.label = label;
        this.brand = brand;
        calories = cal;
        protein = ptn;
        this.fat = fat;
        fiber = fib;
        cholesterol = cho;
    }
    public FoodItem(FoodItem food, int serving){
        this.label = food.label;
        this.brand = food.brand;
        calories = food.getCalories() * serving;
        protein = food.getProtein() * serving;
        this.fat = food.getFat() * serving;
        fiber = food.getFiber() * serving;
        cholesterol = food.getCholesterol() * serving;
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

    public String SubTitle(){
        if(brand != null) {
            return "Brand: " + getBrand() + ", Calories: " + getCalories();
        }else{
            return "Calories: " + getCalories();
        }
    }
    public String CalString(){
        return "Calories " + getCalories();
    }
    public String ProString(){
        return "Protein " + getProtein();
    }
    public String FatString(){
        return "Fat " + getFat();
    }
    public String FibString(){
        return "Fiber " + getFiber();
    }
    public String ChoString(){
        return "Cholesterol " + getCholesterol();
    }
    public String[] StringArray(){
        String[] nutrients = new String[5];
        nutrients[0] = CalString();
        nutrients[1] = ProString();
        nutrients[2] = FatString();
        nutrients[3] = FibString();
        nutrients[4] = ChoString();
        return nutrients;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
