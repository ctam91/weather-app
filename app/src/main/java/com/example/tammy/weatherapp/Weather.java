package com.example.tammy.weatherapp;

/**
 * Created by tammy on 10/6/2017.
 */

public class Weather {

    private String mTemp;
    private String mName;
    private Long mDate;

    public Weather(String temp, String name, Long date) {
        this.mTemp = temp;
        this.mName = name;
        this.mDate = date;
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

    public Long getDate() {
        return mDate;
    }

    public void setDate(Long mDate) {
        this.mDate = mDate;
    }
}
