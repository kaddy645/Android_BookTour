package com.example.booktoursapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.TextView;
import android.app.DatePickerDialog;

import java.text.DateFormat;
import java.util.Calendar;


import android.widget.DatePicker;


import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class TourDetailsActivity extends AppCompatActivity {

    String tourTitle;
    String tourDesc;
    String tourPrice;
    String tourDate = "Empty";


    private EditText displayEditText;


    Calendar c = Calendar.getInstance();
    DateFormat fmtDate = DateFormat.getDateInstance();

    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            c.set(Calendar.YEAR, year);
            c.set(Calendar.MONTH, monthOfYear);
            c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            tourDate = fmtDate.format(c.getTime());

        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_details);

        Button incrementButton, decrementButton, bookthetourButton, settheDateButton;
        // initialise ui components
        incrementButton = findViewById(R.id.increment);
        decrementButton = findViewById(R.id.decrement);
        bookthetourButton = findViewById(R.id.btnBookTour);
        settheDateButton = findViewById(R.id.btnDate);
        displayEditText = findViewById(R.id.display);


        // register button click and action listeners
        View.OnClickListener incrementButtonListner = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increment();
            }
        };

        View.OnClickListener decrementButtonListner = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrement();
            }
        };

        View.OnClickListener bookthetourButtonListner = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 if(tourDate.equals("Empty")){
                     showError();
                 }

                else {

                     Intent tourConfirmationIntent = new Intent(TourDetailsActivity.this, TourConfirmationActivity.class);
                     tourConfirmationIntent.putExtra("tourTitle", tourTitle);
                     tourConfirmationIntent.putExtra("tourTravellers", Integer.toString(getCurrentValue()));
                     tourConfirmationIntent.putExtra("tourPrice", tourPrice);
                     tourConfirmationIntent.putExtra("tourDate", tourDate);
                     startActivity(tourConfirmationIntent);
                 }

            }
        };

        View.OnClickListener DateListner = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(TourDetailsActivity.this, d, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show();
            }
        };

        incrementButton.setOnClickListener(incrementButtonListner);
        decrementButton.setOnClickListener(decrementButtonListner);
        settheDateButton.setOnClickListener(DateListner);
        bookthetourButton.setOnClickListener(bookthetourButtonListner);

        // Get the transferred data from source activity.
        Intent city = getIntent();
        tourTitle = city.getStringExtra("TourTitle");
        tourDesc = city.getStringExtra("TourDesc");
        tourPrice = city.getStringExtra("TourPrice");
        TextView txtTitleResult = findViewById(R.id.titleTourDetails);
        TextView txtDescResult = findViewById(R.id.descTourDetails);

        txtTitleResult.setText(tourTitle); // set the data got it from previous activity
        txtDescResult.setText(tourDesc);

    }


    public void increment() {
        int val = getCurrentValue();
        val++;

        if (val > 10) {
            Toast.makeText(TourDetailsActivity.this, "Max no people is 10!", Toast.LENGTH_LONG).show();
        } else {
            String temp = Integer.toString(val);
            displayEditText.setText(temp);
        }


    }


    public void decrement() {
        int val = getCurrentValue();
        val--;
        if (val < 1) {
            Toast.makeText(TourDetailsActivity.this, "Min no people is 1!", Toast.LENGTH_LONG).show();
        } else {
            String temp = Integer.toString(val);
            displayEditText.setText(temp);
        }


    }


    public void showError(){
        Toast.makeText(TourDetailsActivity.this, "Please Select the date!", Toast.LENGTH_LONG).show();
    }


    public int getCurrentValue() {
        return Integer.parseInt(displayEditText.getText().toString());
    }


}