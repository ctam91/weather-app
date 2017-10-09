package com.example.tammy.weatherapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

        // Create a new Date object from the time in milliseconds and set date textview
        Date dateObject = new Date(currentWeather.getTimeInMilliseconds()*1000);
        String formattedDate = formatDate(dateObject);
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        dateView.setText(formattedDate);

        // Set temperature textview
        TextView temp = (TextView) listItemView.findViewById(R.id.temp);
        String currentTemp = formatTemp(currentWeather.getTemp());
        temp.setText(String.valueOf(currentTemp));

        return listItemView;
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, MMM d, ''yy");
        return dateFormat.format(dateObject);
    }

    private String formatTemp(Double tempK){
        Double fTemp = (9.0/5)*(tempK - 273) + 32.0;
        DecimalFormat fTempFormatted = new DecimalFormat("0.0");
        return fTempFormatted.format(fTemp);
    }

}
