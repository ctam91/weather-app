package com.example.tammy.weatherapp;

/**
 * Created by tammy on 10/6/2017.
 */

public class Weather {

    private String mTemp;
    private String mName;
    private Long mTimeInMilliseconds;

    public Weather(String temp, String name, Long timeInMilliseconds) {
        this.mTemp = temp;
        this.mName = name;
        this.mTimeInMilliseconds = timeInMilliseconds;
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

    public Long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }

    public void setTimeInMilliseconds(Long mTimeInMilliseconds) {
        this.mTimeInMilliseconds = mTimeInMilliseconds;
    }
}
