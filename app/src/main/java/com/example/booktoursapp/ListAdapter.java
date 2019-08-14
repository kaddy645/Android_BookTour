package com.example.booktoursapp;

import android.content.Context;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;


public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {


    List<ModelList> Tours;
    Context context;

    public ListAdapter(List<ModelList> Tours) {
        this.Tours = Tours;
    }

    @Override  /* inflate the layout for the view of every item in the Recycler View. */
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_tours, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        context = parent.getContext();
        return viewHolder;
    }

    @Override
    /* holder object getting from createview we can set the data on all of the views defined in the activity_tours xml file.*/
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        ModelList Tour = Tours.get(position);
        holder.titleTour.setText(Tour.getTourTitle());
        holder.descTour.setText(Tour.getTourDesc());
        holder.priceTour.setText(Tour.getTourPrice());
        holder.imgTour.setImageResource(Tour.getTourImage());

        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String tourTitle = holder.titleTour.getText().toString();
                String tourDesc = holder.descTour.getText().toString();
                String tourPrice = holder.priceTour.getText().toString();
                Intent tourDetails = new Intent(view.getContext(), TourDetailsActivity.class);
                tourDetails.putExtra("TourTitle", tourTitle);
                tourDetails.putExtra("TourDesc", tourDesc);
                tourDetails.putExtra("TourPrice", tourPrice);
                view.getContext().startActivity(tourDetails);
            }
        });


    }

    @Override
    public int getItemCount() {
        return Tours.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTour;
        TextView descTour;
        TextView priceTour;
        ImageView imgTour;

        CardView cv;

        public ViewHolder(View itemView) {
            super(itemView);
            titleTour = itemView.findViewById(R.id.titleTour);
            descTour = itemView.findViewById(R.id.descTour);
            priceTour = itemView.findViewById(R.id.priceTour);
            imgTour = itemView.findViewById(R.id.imgTour);

            cv = itemView.findViewById(R.id.cv);
        }

    }
}