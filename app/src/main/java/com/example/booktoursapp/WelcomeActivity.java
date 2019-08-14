package com.example.booktoursapp;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.view.View;
import android.widget.Button;


public class WelcomeActivity extends AppCompatActivity {

    Spinner city;
    String CITY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        city = findViewById(R.id.spinner);  //Get Spinner Value
        CITY = city.getSelectedItem().toString();     // Convert it to String


        // Setting Listner on Spinner for future values
        city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                CITY = parent.getItemAtPosition(position).toString();  // Updating Change
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        // Get Both the buttons

        Button btnFindTours = findViewById(R.id.btnFindTours);
        Button btnKnowMore = findViewById(R.id.knowMore);


        /* Set On click Listners */

        View.OnClickListener btnFindToursListner = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent findToursIntent = new Intent(WelcomeActivity.this, RecyclerViewActivity.class);
                findToursIntent.putExtra("SpinnerText", CITY);

                startActivity(findToursIntent);
            }
        };


        View.OnClickListener btnKnowMoreListner = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent knowMoreIntent = new Intent(WelcomeActivity.this, CityInfoActivity.class);
                startActivity(knowMoreIntent);
            }
        };


        btnFindTours.setOnClickListener(btnFindToursListner);
        btnKnowMore.setOnClickListener(btnKnowMoreListner);
    }
}