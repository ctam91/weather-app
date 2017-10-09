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
        Long newDate = null;
        if (currentWeather != null) {
            newDate = currentWeather.getTimeInMilliseconds()*1000;

            Date dateObject = new Date(newDate);
            String formattedDate = formatDate(dateObject);
            TextView dateView = (TextView) listItemView.findViewById(R.id.date);
            dateView.setText(formattedDate);

            TextView timeView = (TextView) listItemView.findViewById(R.id.time);
            String formattedTime = formatTime(dateObject);
            timeView.setText(formattedTime);

            // Set temperature textview
            TextView temp = (TextView) listItemView.findViewById(R.id.temp);
            String currentTemp = formatTemp(currentWeather.getTemp());
            temp.setText(String.valueOf(currentTemp));
        }
        return listItemView;
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, MMM d, ''yy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }


    private String formatTemp(Double tempC){
        Double fTemp = tempC * (9.0/5) + 32.0;
        DecimalFormat fTempFormatted = new DecimalFormat("0.0");
        return fTempFormatted.format(fTemp);
    }

}
