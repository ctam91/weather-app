package com.example.tammy.weatherapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Weather> weathers = new ArrayList<Weather>();
        weathers.add(new Weather("Lynnwood", 72.0));
        weathers.add(new Weather("Seattle", 64.3));
    }
}
