package com.example.quicktap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private SharedPreferences pref;
    private TextView textHighScoreTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pref = PreferenceManager.getDefaultSharedPreferences(this);



        ((Button) findViewById(R.id.start)).setOnClickListener(this);
        ((Button) findViewById(R.id.score)).setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.start:
                Intent intentLevel = new Intent(getApplicationContext(), GameLevel.class);
                startActivity(intentLevel);
                break;

            case R.id.score:
                Intent intentScore = new Intent(getApplicationContext(), ScoreZone.class);
                startActivity(intentScore);
                break;
        }
    }
}
