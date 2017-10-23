package com.example.tammy.weatherapp;

/**
 * Created by tammy on 10/6/2017.
 */

public class Weather {

    private double mTemp;
    private String mName;

    public Weather(double temp, String name) {
        this.mTemp = temp;
        this.mName = name;
    }


    public double getTemp() {
        return mTemp;
    }

    public void setTemp(double temp) {
        this.mTemp = temp;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }
}
