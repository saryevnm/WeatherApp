package com.example.weatherapp.ui.info_fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.View;

import com.bumptech.glide.Glide;
import com.example.weatherapp.data.model.currentDay.CurrentDayWeather;
import com.example.weatherapp.data.model.forecastDays.ForecastForFiveDays;
import com.example.weatherapp.data.model.forecastDays.List;
import com.example.weatherapp.data.utils.DataParser;
import com.example.weatherapp.databinding.WeatherInfoBinding;
import com.example.weatherapp.ui.adapters.DayForecastAdapter;
import com.example.weatherapp.ui.adapters.FiveDaysForecastAdapter;
import com.example.weatherapp.ui.base_fragment.BaseFragment;
import com.example.weatherapp.ui.select_fragment.SelectCityFragment;

import java.util.ArrayList;
import java.util.Date;

public class WeatherInfoFragment extends BaseFragment<WeatherInfoBinding> {
    private ForecastForFiveDays forecastForFiveDays;
    private CurrentDayWeather currentDayWeather;
    private java.util.List<List> lists = new ArrayList<>();
    private final java.util.List<List> list = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            forecastForFiveDays = (ForecastForFiveDays) getArguments().getSerializable(SelectCityFragment.FORECASTKEY);
            currentDayWeather = (CurrentDayWeather) getArguments().getSerializable(SelectCityFragment.CURRENTKEY);
        }
    }

    @Override
    protected WeatherInfoBinding fetchTheView() {
        return WeatherInfoBinding.inflate(getLayoutInflater());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getSortedListAndSend();
        getsortedlistOf();
        setAdapters();
        setFields();
    }

    private void setAdapters() {
        bind.thirdforecast.setAdapter(new DayForecastAdapter(list,getContext()));
        bind.daylyforecast.setAdapter(new FiveDaysForecastAdapter(lists,getContext()));
    }

    private void getsortedlistOf() {
        int count =0;
        Date now = new Date();
        long longTime = now.getTime() / 1000;
        for (List listl:forecastForFiveDays.getList()) {
            if (longTime<listl.getDt() && count==0){
                count++;
            }
            if (count>0){
                list.add(listl);
            }
        }
    }

    private void setFields() {
        if (currentDayWeather != null && forecastForFiveDays != null) {
            String temp = currentDayWeather.getCurrentMain().getTemp().toString() + "°";
            bind.city.setText(currentDayWeather.getName());
            bind.description.setText(currentDayWeather.getCurrentWeather().get(0).getDescription());
            bind.temperature.setText(temp);
            Glide.with(requireContext())
                    .load("http://openweathermap.org/img/w/" + currentDayWeather.getCurrentWeather().get(0).getIcon() + ".png")
                    .into(bind.iconForUi);
        }
    }

    private void getSortedListAndSend() {
        lists = DataParser.getParsedList(forecastForFiveDays.getList());
    }


}