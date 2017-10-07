package com.example.tammy.weatherapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by tammy on 10/6/2017.
 */

public class WeatherAdapter extends ArrayAdapter<Weather> {

    public WeatherAdapter(@NonNull Context context, @NonNull List<Weather> objects) {
        super(context, 0, objects);
    }
}
