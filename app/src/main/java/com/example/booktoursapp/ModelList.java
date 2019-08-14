package com.example.booktoursapp;


//We create a model class that will be used to populate the Recycler View.

public class ModelList {


    private String TourTitle;
    private String TourDesc;
    private String TourPrice;
    private int TourImage;


    public String getTourTitle() {
        return TourTitle;
    }

    public void setTourTitle(String tourtitle) {
        this.TourTitle = tourtitle;
    }


    public String getTourPrice() {
        return TourPrice;
    }

    public void setTourPrice(String tourprice) {
        this.TourPrice = tourprice;
    }


    public String getTourDesc() {
        return TourDesc;
    }

    public void setTourDesc(String tourdesc) {
        this.TourDesc = tourdesc;
    }


    public int getTourImage() {
        return TourImage;
    }

    public void setTourImage(int tourimage) {
        this.TourImage = tourimage;
    }
}