package com.example.olympia.ViewHistory;

public class usersFoodlist {
    String brand, label, time, date, userid;
    long calories, cholesterol, fat, fiber, protein;

    public usersFoodlist() {

    }

    public usersFoodlist(String brand, String label, String time, String date, String userid, long calories, long cholesterol, long fat, long fiber, long protein) {
        this.brand = brand;
        this.label = label;
        this.time = time;
        this.calories = calories;
        this.cholesterol = cholesterol;
        this.fat = fat;
        this.fiber = fiber;
        this.protein = protein;
        this.date = date;
        this.userid = userid;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() { return date; }

    public void setDate(String date) {this.date = date; }

    public String getUserid() { return userid; }

    public void setUserid(String userid) {this.userid = userid; }

    public long getCalories() {
        return calories;
    }

    public void setCalories(long calories) {
        this.calories = calories;
    }

    public long getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(long cholesterol) {
        this.cholesterol = cholesterol;
    }

    public long getFat() {
        return fat;
    }

    public void setFat(long fat) {
        this.fat = fat;
    }

    public long getFiber() {
        return fiber;
    }

    public void setFiber(long fiber) {
        this.fiber = fiber;
    }

    public long getProtein() {
        return protein;
    }

    public void setProtein(long protein) {
        this.protein = protein;
    }
}
