package com.example.tammy.weatherapp;

/**
 * Created by tammy on 10/6/2017.
 */

public class Weather {

    private double mTemp;

    public Weather(double temp) {
        this.mTemp = temp;
    }


    public double getTemp() {
        return mTemp;
    }

    public void setTemp(double temp) {
        this.mTemp = temp;
    }

}
