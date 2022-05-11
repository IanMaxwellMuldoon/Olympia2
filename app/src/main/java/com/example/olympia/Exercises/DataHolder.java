package com.example.olympia.Exercises;

import java.util.ArrayList;

public class DataHolder {
    final ArrayList<Exercise> arrayList = new ArrayList<>();

    private DataHolder () {

    }


    static DataHolder getInstance() {
        if(instance == null) {
            instance = new DataHolder();

        }

        return instance;
    }

    private static DataHolder instance;
}
