package com.example.dariushaslauer.zweiteklasseb;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class Activity_Mannschaft extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent intent = new Intent(Activity_Mannschaft.this, ActivitySpiele.class);
                    startActivity(intent);

                    return true;
                case R.id.navigation_dashboard:
                    Intent intent1 = new Intent(Activity_Mannschaft.this, Activity_Mannschaft.class);
                    startActivity(intent1);
                    return true;
                case R.id.navigation_notifications:
                    Intent intent2 = new Intent(Activity_Mannschaft.this, Activity_UserInformation.class);
                    startActivity(intent2);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mannschaft);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
