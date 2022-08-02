package com.tillster.mobileaccuweatherapp;

import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;


//WORKING WITH THIS CLASS FIRST
public class NetworkUtil {
    //FIRST STEP
    //UNDER FORECASTS & UNDER 5 DAY FORECAST
    private static final String BASE_URL = "https://dataservice.accuweather.com/forecasts/v1/daily/5day/305605";
    //SECOND STEP
    //UNDER MY APPS IN ACCUWEATHER WEBSITE
    private static final String API_KEY = "jf7zmp1b3FzelEUNsUPXStMrIIzq8B5U";
    //THIRD STEP
    private static final String PARAM_API_KEY = "apikey";
    //FORTH STEP
    private static final String METRIC_PARAM = "metric";
    //FIFTH STEP
    private static final String METRIC_VALUE = "true";

    //CREATED FOR THE TAG
    public static String TAG = "NETWORK_UTIL";

    //SIXTH STEP
    //IMPORT CLASS
    public static URL buildURL() {
        //IMPORT CLASS
        Uri uri = Uri.parse(BASE_URL)
                //SECOND BUILD UPON
                .buildUpon()
                .appendQueryParameter(PARAM_API_KEY, API_KEY)
                .appendQueryParameter(METRIC_PARAM, METRIC_VALUE)
                .build();

        //SEVENTH STEP
        URL url = null;
        //EIGHTH STEP
        //ORIGINAL LINE OF CODE  ==> url = new URL(buildURL().toString());
        //CLICK SURROUND BY TRY CATCH
        try {
            url = new URL((uri).toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        //NINTH STEP
        return url;
    }

    //THIRTEENTH STEP
    //ADDED "throws IOException" AND ALT ENTER
    public static String getResponse(URL url) throws IOException {
        //PULL IN AN EXISTING JAVA CLASS
        //TYPE "HTT" AND SELECT HTTPURLCONNECTION
        //ORIGINAL LINE OF CODE ==>    HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
        //SURROUND BY TRY CATCH
        //WAS IN TRY BUT TAKEN OUT AND PUT HERE
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

        try {
            //
            InputStream in = httpURLConnection.getInputStream();
            Scanner scanner = new Scanner(in);

            //FINDS NEXT LINE
            scanner.useDelimiter("//A");//DELIMITER FOR JSON

            //
            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {

                Log.i(TAG, "getResponse: " + scanner.next());

                return null;
            }

        }


        //FOURTEENTH STEP
        finally {
            httpURLConnection.disconnect();
        }
    }



}
