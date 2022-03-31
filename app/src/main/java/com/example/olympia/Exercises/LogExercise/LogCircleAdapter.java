package com.example.olympia.Exercises.LogExercise;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.olympia.Exercises.Exercise;
import com.example.olympia.Exercises.Plan;
import com.example.olympia.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class LogCircleAdapter extends RecyclerView.Adapter<LogCircleAdapter.ViewHolder> {

private ArrayList<Button> buttons;
private Exercise exercise;



    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        private Button button;
        private Exercise exercise;

        public ViewHolder(View view, Exercise exercise) {
            super(view);
            // Define click listener for the ViewHolder's View
            button = view.findViewById(R.id.idCircleButton);
            button.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.M)
                @Override
                public void onClick(View v) {

                Log.d("message","you Clicked Me!!!");
                if(!button.isSelected()){
                    exercise.incrementProgressCount();
                }else {
                    exercise.decrementProgressCount();
                }
                button.setSelected(!button.isSelected());
                }
            });
        }

        public Button getLogButton() {
            return button;
        }

        public TextView getTextView() {
            return textView;
        }
    }
    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public LogCircleAdapter(ArrayList<Button> dataSet, Exercise exercise) {
        this.exercise = exercise;
        buttons = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.exercise_log_button, viewGroup, false);

        return new ViewHolder(view, exercise);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element


    }

    public Exercise getExercise() {
        return exercise;
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return buttons.size();
    }
}
