package com.example.olympia.ViewHistory;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.olympia.CalorieCounter.CalorieCounterSearch;
import com.example.olympia.CalorieCounter.CalorieMenu;
import com.example.olympia.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class mealHistory extends AppCompatActivity {

    private TextView dateTimeDisplay;
    private Calendar calendar;
    private SimpleDateFormat dateFormat;
    private String date;

    //Button changeDate;
    TextView change;
    ImageButton changeDate;
    TextView test;
    TextView test2, test3;
    FirebaseAuth dataBase;
    FirebaseFirestore foodTest;
    String userId;
    String valuefat;

    //for recycler view
    RecyclerView recyclerView;
    ArrayList<usersFoodlist> userArrayList;
    myAdapter Adapter;
    FirebaseFirestore db;

    String dateChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_history);

        //for toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Food History");

        //to get date
        dateTimeDisplay = (TextView)findViewById(R.id.yesterday);
        calendar = Calendar.getInstance();
        dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        date = SimpleDateFormat.getDateInstance().format(calendar.getTime());
        dateTimeDisplay.setText(date);


       // String stringTest = date.toString();

        // <- button (for the yesterdays date)
        change = (TextView)findViewById(R.id.yesterday);
        changeDate = (ImageButton)findViewById(R.id.before);
        changeDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar.add(Calendar.DATE, -1);
                date = SimpleDateFormat.getDateInstance().format(calendar.getTime());
                change.setText(date);
                dataBase = FirebaseAuth.getInstance();
                foodTest = FirebaseFirestore.getInstance();
                userId = dataBase.getCurrentUser().getUid();

//        String stringTest = date.toString();
                //dateChange = change.getText().toString();
                userArrayList.clear();
                Adapter.notifyDataSetChanged();
                db.collection("food").whereEqualTo("userid",userId).whereEqualTo("date", date)
                        .addSnapshotListener(new EventListener<QuerySnapshot>() {
                            @Override
                            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                                if(error != null) {
                                    Log.e("Firestore error", error.getMessage());
                                    return;
                                }

                                for (DocumentChange dc: value.getDocumentChanges()) {

                                    if(dc.getType() == DocumentChange.Type.ADDED){

                                        userArrayList.add(dc.getDocument().toObject(usersFoodlist.class));
                                    }

                                    Adapter.notifyDataSetChanged();

                                }

                            }
                        });
            }

        });

        // -> button (for the tomorrows date)
        change = (TextView)findViewById(R.id.yesterday);
        changeDate = (ImageButton)findViewById(R.id.after);
        changeDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar.add(Calendar.DATE, 1);
                date = SimpleDateFormat.getDateInstance().format(calendar.getTime());
                change.setText(date);
                dataBase = FirebaseAuth.getInstance();
                foodTest = FirebaseFirestore.getInstance();
                userId = dataBase.getCurrentUser().getUid();
                userArrayList.clear();
                Adapter.notifyDataSetChanged();
//        String stringTest = date.toString();
                //dateChange = change.getText().toString();

                db.collection("food").whereEqualTo("userid",userId).whereEqualTo("date", date)
                        .addSnapshotListener(new EventListener<QuerySnapshot>() {
                            @Override
                            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                                if(error != null) {
                                    Log.e("Firestore error", error.getMessage());
                                    return;
                                }

                                for (DocumentChange dc: value.getDocumentChanges()) {

                                    if(dc.getType() == DocumentChange.Type.ADDED){

                                        userArrayList.add(dc.getDocument().toObject(usersFoodlist.class));
                                    }

                                    Adapter.notifyDataSetChanged();

                                }

                            }
                        });

            }

        });

//        test = findViewById(R.id.food1);
//        test2 = findViewById(R.id.fatvalue1);
//        test3 = findViewById(R.id.fatvalue2);

        dataBase = FirebaseAuth.getInstance();
        foodTest = FirebaseFirestore.getInstance();
        userId = dataBase.getCurrentUser().getUid();

//        String stringTest = date.toString();
            //dateChange = change.getText().toString();

//        foodTest.collection("users").document(userId).collection("foodlist").document(date)
//        .addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
//            @Override
//            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
//
//                    test.setText("Food: " + value.getString("label"));
//                    test2.setText("Calories: " + value.getLong("calories"));
//                    test3.setText("Fat: " + value.getLong("fat"));
//
//            }
//        });

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        db = FirebaseFirestore.getInstance();
        dataBase = FirebaseAuth.getInstance();
        userId = dataBase.getCurrentUser().getUid();

        userArrayList = new ArrayList<usersFoodlist>();
        Adapter = new myAdapter(mealHistory.this,userArrayList);

        recyclerView.setAdapter(Adapter);

        userArrayList.clear();
        Adapter.notifyDataSetChanged();
        db.collection("food").whereEqualTo("userid",userId).whereEqualTo("date", date)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                        if(error != null) {
                            Log.e("Firestore error", error.getMessage());
                            return;
                        }

                        for (DocumentChange dc: value.getDocumentChanges()) {

                            if(dc.getType() == DocumentChange.Type.ADDED){

                                userArrayList.add(dc.getDocument().toObject(usersFoodlist.class));
                            }

                            Adapter.notifyDataSetChanged();

                        }

                    }
                });

//        EventChangeListener();
    }

//    private void EventChangeListener() {
//
//        db.collection("food").whereEqualTo("userid","1HwFXjkjOpSvBad3lT07svHmaMi1").whereEqualTo("date", date)
//                .addSnapshotListener(new EventListener<QuerySnapshot>() {
//                    @Override
//                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
//
//                        if(error != null) {
//                            Log.e("Firestore error", error.getMessage());
//                            return;
//                        }
//
//                        for (DocumentChange dc: value.getDocumentChanges()) {
//
//                            if(dc.getType() == DocumentChange.Type.ADDED){
//
//                                userArrayList.add(dc.getDocument().toObject(usersFoodlist.class));
//                            }
//
//                                Adapter.notifyDataSetChanged();
//
//                        }
//
//                    }
//                });
//    }
}