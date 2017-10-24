package com.example.tammy.weatherapp;

/**
 * Created by tammy on 10/6/2017.
 */

public class Weather {

    private double mTemp;
    private Long mTimeInMilliseconds;
    private String mDescription;
    private String mWeatherType;

    public Weather(double temp, Long date, String description, String weatherType) {
        this.mTemp = temp;
        this.mTimeInMilliseconds = date;
        this.mDescription = description;
        this.mWeatherType = weatherType;
    }


    public double getTemp() {
        return mTemp;
    }

    public void setTemp(double temp) {
        this.mTemp = temp;
    }

    public Long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }

    public void setTimeInMilliseconds(Long mTimeInMilliseconds) {
        this.mTimeInMilliseconds = mTimeInMilliseconds;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getWeatherType(){
        return mWeatherType;
    }
}
