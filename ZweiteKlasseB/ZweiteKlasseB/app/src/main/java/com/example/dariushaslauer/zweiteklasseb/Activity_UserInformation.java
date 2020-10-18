package com.example.dariushaslauer.zweiteklasseb;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Activity_UserInformation extends AppCompatActivity {
    TextView textViewEmail;
    TextView textViewUID;
    TextView textViewDate;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userinformation);
        textViewEmail = (TextView)findViewById(R.id.textViewEmail);
        textViewDate = (TextView)findViewById(R.id.textViewDateCreated);
        textViewUID = (TextView)findViewById(R.id.textViewUid);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        textViewEmail.setText(user.getEmail());
        textViewUID.setText(user.getUid());
        textViewDate.setText(user.getProviderId());

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent intent = new Intent(Activity_UserInformation.this, ActivitySpiele.class);
                    startActivity(intent);

                    return true;
                case R.id.navigation_dashboard:
                    Intent intent1 = new Intent(Activity_UserInformation.this, Activity_Mannschaft.class);
                    startActivity(intent1);
                    return true;
                case R.id.navigation_notifications:
                    Intent intent2 = new Intent(Activity_UserInformation.this, Activity_UserInformation.class);
                    startActivity(intent2);
                    return true;
            }
            return false;
        }
    };
}
