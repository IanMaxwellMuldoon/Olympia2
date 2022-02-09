package com.example.olympia.Exercises;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.olympia.R;

import java.util.ArrayList;

public class CurrentPlan extends AppCompatActivity {
    private ArrayList<Exercise> exerciseList;

    private ExerciseAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_plan);

        Intent intent = getIntent();
        Plan plan = intent.getParcelableExtra("Example");


        String title = plan.getTitle();
        Log.d("title", title);
    }

    private void createExampleList() {
        exerciseList = new ArrayList<>();
        //------------------------------------
        //something goes here not sure what//
        //------------------------------------
    }

    private void buildRecyclerView() {
       /* mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(mExampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new ExampleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(MainActivity.this, Activity2.class);
                intent.putExtra("Example Item", mExampleList.get(position));

                startActivity(intent);
            }
        });

    }*/
    }
}