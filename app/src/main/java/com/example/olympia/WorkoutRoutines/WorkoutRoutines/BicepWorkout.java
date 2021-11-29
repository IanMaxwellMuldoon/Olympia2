package WorkoutRoutines;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.olympia.R;

import android.view.View;
import android.widget.CheckedTextView;
import android.widget.Button;

public class BicepWorkout extends AppCompatActivity {

    private CheckedTextView checkbox1;
    private Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bicep_workout);

        checkbox1 = (CheckedTextView) findViewById(R.id.checkedTextView2);

        checkbox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkbox1.isChecked()){
                    checkbox1.setChecked(false);
                }
                else
                    checkbox1.setChecked(true);
            }
        });
    }
}