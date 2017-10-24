package com.example.tammy.weatherapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class WeatherActivity extends AppCompatActivity {

    //URL for data from the Open Weather Map dataset
    private static final String API_URL =
            "http://openweathermap.org/data/2.5/weather?q=Seattle,US-WA&appid=b1b15e88fa797225412429c1c50c122a1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WeatherAsyncTask task = new WeatherAsyncTask();
        task.execute(API_URL);
        Log.v("Step", "task succesfully executed");
    }

    private class WeatherAsyncTask extends AsyncTask<String, Void, Weather> {

        @Override
        protected Weather doInBackground(String... urls) {
            if (urls.length < 1 || urls[0] == null) {
                return null;
            }
            Weather theWeather = QueryUtils.fetchWeatherData(urls[0]);
            return theWeather;
        }

        @Override
        protected void onPostExecute(Weather data) {
            if (data != null){
                String temp = data.getTemp();
                String name = data.getName();

                TextView tempTextView = (TextView) findViewById(R.id.temp);
                TextView nameTextView = (TextView) findViewById(R.id.location);

                tempTextView.setText(temp);
                nameTextView.setText(name);
            }
        }
    }

}
