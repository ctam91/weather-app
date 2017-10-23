package com.example.tammy.weatherapp;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * Created by tammy on 10/6/2017.
 */

public final class QueryUtils {

    /*
        Default Constructor
     */
    public QueryUtils() {
    }

    /**
    *Create a URL object from the given URL string
     */
    private static URL createUrl(String stringUrl){
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

    /**
     * Convert InputStream into String
    */
    private static String readFromStream(InputStream inputStream) throws IOException{
        StringBuilder output = new StringBuilder();

        if(inputStream !=null){
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while( line != null){
                output.append(line);
                line = reader.readLine();
            }
        } return output.toString();
    }

    /**
     * Establish a network connection. Make an HTTP request to the given URL and return a String as the response.
     */
    private static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";

        // if the url is null, return early
        if(url == null){
            return jsonResponse;
        }

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;

        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            if(urlConnection.getResponseCode() == 200){
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else{
                Log.e("Error", "Error response code" + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            Log.e("Error", "Problem returning the JSON information");
        } finally {
            if(urlConnection != null ){
                urlConnection.disconnect();
            } if(inputStream != null){
                inputStream.close();
            }
        }
        return jsonResponse;
    }

    /**
     * Parse JSON response
     * @param weatherJSON the JSON data
     * @return list of weather objects from JSON
     */
    private static Weather extractWeatherData(String weatherJSON){

        // If the JSON string is empty or null, then return early.
        if (TextUtils.isEmpty(weatherJSON)) {
            return null;
        }

        try {
            JSONObject myObject = new JSONObject(weatherJSON);
            JSONObject main = new JSONObject(myObject.getString("main"));
            String temp = main.getString("temp");
            String placeName = myObject.getString("name");

            Weather result = new Weather(temp, placeName);
            return result;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

        /*
        Retrieve Weather Data from API
     */

    public static Weather fetchWeatherData(String requestUrl){
        // Create URL object
        URL url = createUrl(requestUrl);

        // Perform HTTP request
        String jsonResponse = null;
        try{
            jsonResponse = makeHttpRequest(url);
        } catch(IOException e){
            Log.e("Error","Problem making the HTTP request", e);
        }
        // Extract relevant field from JSON response and add it to an Earthquake List
        Weather weatherData = extractWeatherData(jsonResponse);
        return weatherData;
    }

}
