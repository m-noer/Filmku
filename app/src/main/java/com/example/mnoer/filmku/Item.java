package com.example.mnoer.filmku;

public class Item {
    private String mImageUrl;
    private String mTitle;
    private String mOverview;
    private String mRelease;
    private double mRate;

    public Item(String imageUrl, String creator, String overview, String release, double rate) {
        mImageUrl = imageUrl;
        mTitle = creator;
        mOverview = overview;
        mRelease = release;
        mRate = rate;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmOverview() {
        return mOverview;
    }

    public String getmRelease() {
        return mRelease;
    }

    public double getmRate() {
        return mRate;
    }
}
