package com.example.dariushaslauer.zweiteklasseb;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ActivitySpiele extends AppCompatActivity implements View.OnClickListener {

    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private ListView listView;
    private Button buttonAdd;
    private Game game;
    private ArrayList<String> allMatches = new ArrayList<>();
    //private ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spiele);
        buttonAdd = (Button)findViewById(R.id.buttonAdd);


        buttonAdd.setOnClickListener(this);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        listView = (ListView)findViewById(R.id.listViewMatches);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, allMatches);
        listView.setAdapter(arrayAdapter);
        //readData();

    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent intent = new Intent(ActivitySpiele.this, ActivitySpiele.class);
                    startActivity(intent);

                    return true;
                case R.id.navigation_dashboard:
                    Intent intent1 = new Intent(ActivitySpiele.this, Activity_Mannschaft.class);
                    startActivity(intent1);
                    return true;
                case R.id.navigation_notifications:
                    Intent intent2 = new Intent(ActivitySpiele.this, Activity_UserInformation.class);
                    startActivity(intent2);
                    return true;
            }
            return false;
        }
    };

//    public void readData(){
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        final DatabaseReference myRef = database.getReference("Games");
//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                Toast.makeText(ActivitySpiele.this, dataSnapshot.getValue().toString(), Toast.LENGTH_LONG).show();
//                game = new Game();
//                myRef.addChildEventListener(new ChildEventListener() {
//                    @Override
//                    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//                    }
//
//                    @Override
//                    public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//                    }
//
//                    @Override
//                    public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
//
//                    }
//
//                    @Override
//                    public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                    }
//                });
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//   }


    @Override
    public void onClick(View view) {
        if(view == buttonAdd){
            Intent intent = new Intent(getApplicationContext(), Activity_AddGame.class);
            startActivity(intent);
        }
    }
}
