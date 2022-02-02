package com.example.olympia.Exercises;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.olympia.R;

import java.util.ArrayList;

public class PlanAdapter extends ArrayAdapter {

    private ArrayList<Plan> plans;
    public PlanAdapter(@NonNull Context context, int resource, ArrayList<Plan> plans) {
        super(context, resource, plans);
        this.plans = plans;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        int phraseIndex = position;
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.plan_item, parent, false);
        }
        TextView titleTextView = convertView.findViewById(R.id.Planbuttonid);
        titleTextView.setText(plans.get(position).getTitle());

        return convertView;
    }
}
