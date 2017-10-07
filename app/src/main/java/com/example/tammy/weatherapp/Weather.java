package com.example.tammy.weatherapp;

/**
 * Created by tammy on 10/6/2017.
 */

public class Weather {

    private String mCity;
    private double mTemp;

    public Weather(String mCity, double temp) {
        this.mCity = mCity;
        this.mTemp = temp;
    }

    public String getCity() {
        return mCity;
    }

    public void setCity(String city) {
        this.mCity = city;
    }

    public double getTemp() {
        return mTemp;
    }
}
