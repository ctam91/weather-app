package com.example.tammy.weatherapp;

/**
 * Created by tammy on 10/6/2017.
 */

public class Weather {

    private String mTemp;
    private String mName;

    public Weather(String temp, String name) {
        this.mTemp = temp;
        this.mName = name;
    }


    public String getTemp() {
        return mTemp;
    }

    public void setTemp(String temp) {
        this.mTemp = temp;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }
}
