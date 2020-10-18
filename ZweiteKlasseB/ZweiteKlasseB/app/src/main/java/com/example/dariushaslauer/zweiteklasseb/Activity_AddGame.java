package com.example.dariushaslauer.zweiteklasseb;

import android.annotation.SuppressLint;
import android.content.EntityIterator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Activity_AddGame extends AppCompatActivity implements View.OnClickListener {
    private EditText team1, team2, result1, result2, spielbericht;
    private DatabaseReference reff;
    private Button buttonAdd;
    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__add_game);
        buttonAdd = (Button)findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(this);
        team1 = (EditText)findViewById(R.id.editTextTeam1);
        team2 = (EditText)findViewById(R.id.editTextTeam2);
        result1 = (EditText)findViewById(R.id.editTextResult1);
        result2 = (EditText)findViewById(R.id.editTextResult2);
        spielbericht = (EditText)findViewById(R.id.editTextSpielbericht);
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        final String formattedDate = df.format(c.getTime());
        game = new Game();
        reff = FirebaseDatabase.getInstance().getReference().child("Games");
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String team_1 =  team1.getText().toString();
                String result_1 = result1.getText().toString();
                String team_2 = team2.getText().toString();
                String result_2 = result2.getText().toString();
                String _spielbericht = spielbericht.getText().toString();
                game.setTeam1(team_1);
                game.setResult1(result_1);
                game.setTeam2(team_2);
                game.setResult2(result_2);
                game.setSpielbericht(_spielbericht);
                reff.child(formattedDate).setValue(game);
                Toast.makeText(Activity_AddGame.this, "Successfully added database entry", Toast.LENGTH_SHORT).show();
                finish();


            }
        });

        }



    public void addToDatabase(){

    }

    @Override
    public void onClick(View view) {
        if(view == buttonAdd){
            addToDatabase();
        }
    }
}
