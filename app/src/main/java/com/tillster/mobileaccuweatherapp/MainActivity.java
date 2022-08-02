package com.tillster.mobileaccuweatherapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;



import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "AccuWeatherURL";
    //16th step
    Fragment FiveDayWeather;
    //
    Fragment Tide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //18th STEP
        FiveDayWeather = new FiveDayWeather();
        //
        Tide = new TideFragment();


        //TENTH STEP
        URL accuWeatherURL = NetworkUtil.buildURL();
        //ELEVENTH STEP
        //MANUALLY TYPE THIS IMPORT ==> import static android.content.ContentValues.TAG;
        Log.i(TAG, "onCreate " + accuWeatherURL);

        //TWELFTH STEP
        //FIND URL IN LOGCATS TAB BELOW
        //YOUR URL SHOULD BE ==>
        //https://dataservice.accuweather.com/forecasts/v1/daily/5day/305605?apikey=jf7zmp1b3FzelEUNsUPXStMrIIzq8B5U&metric=true
        //YOU ADDED A "S" TO "HTTP"


        //17TH STEP
        // IMPLEMENTING FRAGMENT
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.weather_frame, FiveDayWeather);
        //
        //transaction.replace(R.id.tide_frame, Tide);
        transaction.commit();



    }
}