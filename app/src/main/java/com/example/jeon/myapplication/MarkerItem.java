package com.example.jeon.myapplication;

/**
 * Created by TedPark on 16. 4. 26..
 */
public class MarkerItem {


    double lat;
    double lon;
    String name;

    public MarkerItem(double lat, double lon, String name) {
        this.lat = lat;
        this.lon = lon;
        this.name = name;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getPrice() {
        return name;
    }

    public void setPrice(String name) {
        this.name = name;
    }


}
