package com.example.booktoursapp;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ListAdapter listAdapter;
    ArrayList < ModelList > tours = new ArrayList < > ();

    String[] TourTitle, TourDesc, TourPrice;
    int[] TourImages;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);


        // Get the transferred data from source activity.
        Intent city = getIntent();
        String CITY = city.getStringExtra("SpinnerText");

        Log.d("Spinner", city.getStringExtra("SpinnerText"));


        if (CITY.equals("New_York")) {
            TourTitle = getResources().getStringArray(R.array.New_YorkTitle);
            TourDesc = getResources().getStringArray(R.array.New_YorkDesc);
            TourPrice = getResources().getStringArray(R.array.NewYorkTourPrice);
            TourImages = new int[] {
                    R.drawable.newyork1, R.drawable.newyork2, R.drawable.newyork3, R.drawable.newyork4, R.drawable.newyork5
            };
        } else {
            TourTitle = getResources().getStringArray(R.array.ChicagoTitle);
            TourDesc = getResources().getStringArray(R.array.ChicagoDesc);
            TourPrice = getResources().getStringArray(R.array.ChicagoTourPrice);
            TourImages = new int[] {
                    R.drawable.chicago1, R.drawable.chicago2, R.drawable.chicago3, R.drawable.chicago4, R.drawable.chicago5
            };
        }


        for (int i = 0; i < TourTitle.length; i++) {
            ModelList tour = new ModelList();
            tour.setTourTitle(TourTitle[i]);
            tour.setTourDesc((TourDesc[i]));
            tour.setTourImage(TourImages[i]);
            tour.setTourPrice(TourPrice[i]);
            tours.add(tour);
        }


        listAdapter = new ListAdapter(tours);

        recyclerView = findViewById(R.id.worldTour);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(listAdapter);
    }




}