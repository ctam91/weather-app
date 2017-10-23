package com.example.tammy.weatherapp;

import android.os.AsyncTask;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tammy on 10/23/2017.
 */

public class WeatherTask extends AsyncTask {

    @Override
    protected Object doInBackground(Object[] params) {


        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);

        TextView temp = (TextView) MainActivity.findViewById(R.id.temp);
        String currentTemp = formatTemp(currentWeather.getTemp());
        temp.setText(String.valueOf(currentTemp));
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

    private int getWeatherIcon(String weatherType){
        int iconResourceId;
        switch (weatherType){
            case "Clear":
                iconResourceId = R.drawable.sun;
                break;
            case "Rain":
                iconResourceId = R.drawable.rain;
                break;
            case "Clouds":
                iconResourceId = R.drawable.cloudy;
                break;
            default:
                iconResourceId = R.drawable.umbrella;
        }
        return iconResourceId;
    }
}
