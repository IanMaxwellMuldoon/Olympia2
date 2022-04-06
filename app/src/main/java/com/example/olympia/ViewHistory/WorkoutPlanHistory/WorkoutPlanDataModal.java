package com.example.olympia.ViewHistory.WorkoutPlanHistory;

import java.util.ArrayList;

public class WorkoutPlanDataModal {
    private String date;
    private String planName;

    // Empty Constructor
    public WorkoutPlanDataModal() {

    }

    public WorkoutPlanDataModal(String date, String planName) {
        this.date = date;
        this.planName = planName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }
}
