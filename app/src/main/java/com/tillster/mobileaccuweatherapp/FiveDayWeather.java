package com.tillster.mobileaccuweatherapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//THIS IS FRAGMENT CLASS
//YOU RIGHT CLICK com... FOLDER UNDER JAVA > NEW > FRAGMENT > BLANK
public class FiveDayWeather extends Fragment {



    public FiveDayWeather() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 19th STEP
        View view = inflater.inflate(R.layout.fragment_five_day_weather, container, false);
        return view;
    }
}