package com.example.weatherapp.data.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFactory {
    private static OpenWeatherAPI API;

    public static OpenWeatherAPI get_instance() {

        if (API == null) {
            API = new Retrofit.Builder()
                    .baseUrl("http://api.openweathermap.org/data/2.5/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(OpenWeatherAPI.class);
        }
        return API;
    }
}
