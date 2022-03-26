package com.example.olympia.Exercises.LogExercise;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

import com.example.olympia.R;

public class LogButton {
    int number = 0;
    Button logButton;
    public LogButton() {
        number = 0;
    }
    public LogButton(int number){
        this.number = number;
    }

    @Override
    public String toString() {
        return "" + number;
    }
    public void setNumber(int number){
        this.number = number;
    }

}
