package com.example.tammy.weatherapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by tammy on 10/6/2017.
 */

public class WeatherAdapter extends ArrayAdapter<Weather> {

    public WeatherAdapter(@NonNull Context context, @NonNull List<Weather> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.weather_list_item, parent, false);
        }
        Weather currentWeather= getItem(position);

        TextView city = (TextView) listItemView.findViewById(R.id.city);
        String currentCity = currentWeather.getCity();
        city.setText(currentCity);


        TextView temp = (TextView) listItemView.findViewById(R.id.temp);
        Double currentTemp = currentWeather.getTemp();
        temp.setText(String.valueOf(currentTemp));

        return listItemView;
    }
}
