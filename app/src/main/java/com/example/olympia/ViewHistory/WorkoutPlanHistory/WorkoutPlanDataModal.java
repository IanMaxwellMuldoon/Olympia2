package com.example.olympia.ViewHistory.WorkoutPlanHistory;

public class WorkoutPlanDataModal {
    private String planName;
    private String time;
    private String docName;

    // Empty Constructor
    public WorkoutPlanDataModal() {
    }

    public WorkoutPlanDataModal(String planName, String time, String docName) {
        this.planName = planName;
        this.time = time;
        this.docName = docName;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }
}