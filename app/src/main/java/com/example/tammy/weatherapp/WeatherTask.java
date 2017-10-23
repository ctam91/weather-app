package com.example.tammy.weatherapp;

import android.os.AsyncTask;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by tammy on 10/23/2017.
 */

public class WeatherTask extends AsyncTask<Weather, Void, Weather> {

    @Override
    protected Weather doInBackground(Weather ... urls) {
        if (urls.length < 1 || urls[0] == null) {
            return null;
        }
        Weather theWeather = QueryUtils.fetchWeatherData(urls[0]);
        return theWeather;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);

        TextView temp = (TextView) MainActivity.findViewById(R.id.temp);
        String currentTemp = formatTemp(currentWeather.getTemp());
        temp.setText(String.valueOf(currentTemp));
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
