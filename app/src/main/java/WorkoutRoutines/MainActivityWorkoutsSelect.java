package WorkoutRoutines;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.olympia.R;
import android.content.Intent;

import android.view.View;
import android.widget.Button;

public class MainActivityWorkoutsSelect extends AppCompatActivity {
    private Button button;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_workouts_select);

        button = (Button) findViewById(R.id.button10);
        button2 = (Button) findViewById(R.id.button15);
        button3 = (Button) findViewById(R.id.button12);
        button4 = (Button) findViewById(R.id.button13);
        button5 = (Button) findViewById(R.id.button14);
        button6 = (Button) findViewById(R.id.button16);
        button7 = (Button) findViewById(R.id.button17);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openChestActivity();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLegActivity();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openShoulderActivity();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBackActivity();
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBicepsActivity();
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTricepsActivity();
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAbActivity();
            }
        });

    }
    public void openChestActivity() {
        Intent intent = new Intent(this, ChestWorkout.class);
        startActivity(intent);
    }

    public void openLegActivity(){
        Intent intent = new Intent (this, LegWorkout.class);
        startActivity(intent);
    }

    public void openShoulderActivity(){
        Intent intent = new Intent (this, ShoulderWorkout.class);
        startActivity(intent);
    }

    public void openBackActivity(){
        Intent intent = new Intent (this, BackWorkout.class);
        startActivity(intent);
    }

    public void openBicepsActivity(){
        Intent intent = new Intent (this, BicepWorkout.class);
        startActivity(intent);
    }
    public void openTricepsActivity(){
        Intent intent = new Intent (this, TricepWorkout.class);
        startActivity(intent);
    }
    public void openAbActivity(){
        Intent intent = new Intent (this, AbWorkout.class);
        startActivity(intent);
    }
}