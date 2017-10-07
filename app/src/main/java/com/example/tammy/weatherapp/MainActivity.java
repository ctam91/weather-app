package com.example.tammy.weatherapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

import static com.example.tammy.weatherapp.R.layout.activity_main;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);

        ArrayList<Weather> weathers = new ArrayList<Weather>();
        weathers.add(new Weather("Lynnwood", 72.0));
        weathers.add(new Weather("Seattle", 64.3));

        WeatherAdapter adapter = new WeatherAdapter(this, weathers);
        ListView weatherListView = (ListView) findViewById(R.id.list);

        weatherListView.setAdapter(adapter);
    }
}
