package com.example.booktoursapp;

import android.app.ListActivity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.content.Intent;
import android.widget.ListView;
import java.util.Arrays;
import java.util.List;


public class CityInfoActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_city_info);

        //convert the attraction string-array to list
        List < String > cities = Arrays.asList(getResources().getStringArray(R.array.citiesInfo));

        //inflate the UI with Attractions list
        setListAdapter(new ArrayAdapter < String > (this, R.layout.activity_city_info, R.id.webCity, cities));

    }


    //handle user taps on  the list items

    protected void onListItemClick(ListView l, View v, int position, long id) {

        Intent ItemIntent;

        switch (position) {
            case 0: //Chicago - Wikipedia
                ItemIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/wiki/Chicago"));
                break;

            case 1: // Chicago Fun Facts | Trivia About Chicago Attractions and History
                ItemIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.choosechicago.com/plan-your-trip/chicago-fun-facts/"));
                break;

            case 2: // 25 Things You Should Know About Chicago
                ItemIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://mentalfloss.com/article/64953/25-things-you-should-know-about-chicago"));
                break;
            case 3: // New York City - Wikipedia
                ItemIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/wiki/New_York_City"));
                break;
            case 4: // 25 Things You Should Know About New York City
                ItemIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://mentalfloss.com/article/64997/25-things-you-should-know-about-new-york-city"));
                break;
            case 5: // 10 Things You Need To Know About New York City
                ItemIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.hostelworld.com/blog/10-things-you-need-to-know-about-new-york-city/"));
                break;

            default:
                ItemIntent = null;
                break;

        } //end switch
        if (ItemIntent != null) {
            startActivity(ItemIntent);
        }

    }
}