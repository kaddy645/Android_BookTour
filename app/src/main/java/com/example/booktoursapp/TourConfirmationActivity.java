package com.example.booktoursapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Random;

public class TourConfirmationActivity extends AppCompatActivity {

    String tourTitle, tourTravellers, tourPrice, tourDate;
    Double totalTourPrice;
    TextView textTourName, textTourPeople, textTourPrice, textTourCode, textTourDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_confirmation);


        // Get the transferred data from source activity.
        Intent confirmation = getIntent();
        tourTitle = getString("tourTitle");
        tourTravellers = getString("tourTravellers");
        tourPrice = getString("tourPrice");
        tourDate = getString("tourDate");


        textTourName = findViewById(R.id.textTourName);
        textTourPeople = findViewById(R.id.textTourPeople);
        textTourPrice = findViewById(R.id.textTourPrice);
        textTourCode = findViewById(R.id.textTourCode);
        textTourDate = findViewById(R.id.textTourDate);


        textTourName.setText(tourTitle);
        textTourPeople.setText(tourTravellers);
        totalTourPrice = (Double.parseDouble(tourPrice.substring(1)) * Integer.parseInt(tourTravellers));
        tourPrice = "$" + totalTourPrice;
        textTourPrice.setText(tourPrice);
        textTourDate.setText(tourDate);
        textTourCode.setText(getProdcutCode());

        Log.d("tourDate",tourDate);
        Log.d("tourCode",getProdcutCode());

    }


    public String getProdcutCode() {
        String RandomChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

        StringBuilder code = new StringBuilder();
        Random rnd = new Random();
        while (code.length() < 7) { // length of the random string.
            int index = (int)(rnd.nextFloat() * RandomChar.length());
            code.append(RandomChar.charAt(index));
        }
        String codeStr = code.toString();
        return codeStr;

    }

    public String getString(String StringName) {
        Intent confirmation = getIntent();
        return confirmation.getStringExtra(StringName);
    }

}