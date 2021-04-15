package com.example.weatherapp.data.utils;

import com.example.weatherapp.data.model.currentDay.CurrentDayWeather;
import com.example.weatherapp.data.model.forecastDays.ForecastForFiveDays;
import com.example.weatherapp.data.remote.RetrofitFactory;

import retrofit2.Call;
import retrofit2.Response;

public class WeatherDataRetriever {
    private final String APIKEY = "4bbf5a1ed98cd9f688ebb3651474cdd2";
    private final String APILANG = "ru";
    private final String APIUNITS = "metric";
    private static WeatherDataRetriever INSTANCE;
    private String cityName;

    public void getCurrentWeather(String cityName,Callback callback){
        this.cityName = cityName;
        RetrofitFactory.get_instance().getWeather(cityName,APIUNITS,APILANG,APIKEY).enqueue(new retrofit2.Callback<CurrentDayWeather>() {
            @Override
            public void onResponse(Call<CurrentDayWeather> call, Response<CurrentDayWeather> response) {
                if (response.isSuccessful() && response.body() != null){
                    callback.success(response.body());
                }
            }

            @Override
            public void onFailure(Call<CurrentDayWeather> call, Throwable t) {

            }
        });
    }

    public void getForecast(Callback callback){
        RetrofitFactory.get_instance().getWeatherForecast(cityName,APIUNITS,APILANG,APIKEY).enqueue(new retrofit2.Callback<ForecastForFiveDays>() {
            @Override
            public void onResponse(Call<ForecastForFiveDays> call, Response<ForecastForFiveDays> response) {
                if (response.isSuccessful() && response.body() != null){
                    callback.success(response.body());
                }
            }

            @Override
            public void onFailure(Call<ForecastForFiveDays> call, Throwable t) {

            }
        });
    }

    public interface Callback{
        void success(CurrentDayWeather currentDayWeather);
        void success(ForecastForFiveDays forecastForFiveDays);
    }

    public static WeatherDataRetriever getInstance(){
        if (INSTANCE == null){
            INSTANCE = new WeatherDataRetriever();
        }
        return INSTANCE;
    }
}
