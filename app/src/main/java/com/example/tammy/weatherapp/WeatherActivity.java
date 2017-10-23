package com.example.tammy.weatherapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class WeatherActivity extends AppCompatActivity {

    //URL for data from the Open Weather Map dataset
    private static final String BASE_URL =
            "http://openweathermap.org/data/2.5/weather?q=Seattle,US-WA&appid=b1b15e88fa797225412429c1c50c122a1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


}
