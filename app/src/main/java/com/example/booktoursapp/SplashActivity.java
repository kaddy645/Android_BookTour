package com.example.booktoursapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Timer;
import java.util.TimerTask;
import android.content.Intent;


public class SplashActivity extends AppCompatActivity {

    //This is the first (Splash Screen) after delay we are directing to next activity

    private static final long DELAY = 5000;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                finish();
                startActivity(new Intent(SplashActivity.this, WelcomeActivity.class));
            }
        };
        Timer opening = new Timer();
        opening.schedule(task, DELAY);
    }
}