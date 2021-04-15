package com.example.weatherapp.data.remote;

import com.example.weatherapp.data.model.currentDay.CurrentDayWeather;
import com.example.weatherapp.data.model.forecastDays.ForecastForFiveDays;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OpenWeatherAPI {

    @GET("weather")
    Call<CurrentDayWeather> getWeather(@Query("q") String i
            , @Query("units") String k
            , @Query("lang") String l
            , @Query("appid") String s);

    @GET("forecast")
    Call<ForecastForFiveDays> getWeatherForecast(@Query("q") String i
            , @Query("units") String k
            , @Query("lang") String l
            , @Query("appid") String s);
}
