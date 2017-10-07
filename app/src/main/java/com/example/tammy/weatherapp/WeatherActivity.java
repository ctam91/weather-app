package com.example.tammy.weatherapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class WeatherActivity extends AppCompatActivity {

    private WeatherAdapter weatherAdapter;

    //URL for data from the Open Weather Map dataset
    private static final String BASE_URL =
            "http://samples.openweathermap.org/data/2.5/forecast?id=524901&appid=";

    private static final String appId = "e96c0c2ddd5f0f8a95124daeee861921";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weatherAdapter = new WeatherAdapter(this, new ArrayList<Weather>());
        ListView weatherListView = (ListView) findViewById(R.id.list);

        weatherListView.setAdapter(weatherAdapter);

        Log.v("Task", "WeatherAdapter successfully set");

        WeatherAsyncTask task = new WeatherAsyncTask();
        task.execute(BASE_URL + appId);
        Log.v("Step", "task succesfully executed");
    }

    private class WeatherAsyncTask extends AsyncTask<String, Void, List<Weather>> {

        @Override
        protected List<Weather> doInBackground(String... urls) {
            if (urls.length < 1 || urls[0] == null) {
                return null;
            }
            List<Weather> theWeather = QueryUtils.fetchWeatherData(urls[0]);
            return theWeather;
        }

        @Override
        protected void onPostExecute(List<Weather> data) {
            // Clear the adapter of previous earthquake data
            weatherAdapter.clear();

            // If there is a valid list of {@link Weather}s, then add them to the adapter's
            // data set. This will trigger the ListView to update.
            if (data != null && !data.isEmpty()) {
                weatherAdapter.addAll(data);
            }
        }
    }

}
