package com.example.weatherapp.ui.select_Frag;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;

import com.example.weatherapp.R;
import com.example.weatherapp.data.model.currentDay.CurrentDayWeather;
import com.example.weatherapp.data.model.currentDay.ListOfCities;
import com.example.weatherapp.data.model.forecastDays.ForecastForFiveDays;
import com.example.weatherapp.data.utils.WeatherDataRetriever;
import com.example.weatherapp.databinding.FragmentSelectCityBinding;
import com.example.weatherapp.ui.adapters.CityAdapter;
import com.example.weatherapp.ui.base_Frag.BaseFragment;

public class SelectCityFragment extends BaseFragment<FragmentSelectCityBinding> implements CityAdapter.click, WeatherDataRetriever.Callback {
    private final Bundle bundle = new Bundle();
    public static final String CURRENTKEY = "currentkey";
    public static final String FORECASTKEY = "forecastkey";
    @Override
    protected FragmentSelectCityBinding fetchTheView() {
        return FragmentSelectCityBinding.inflate(getLayoutInflater());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CityAdapter adapter = new CityAdapter(ListOfCities.cities,this);
        bind.recyclerForCities.setAdapter(adapter);
        bind.search.setOnClickListener(v -> {

        });
    }

    @Override
    public void click(String cityName) {
        WeatherDataRetriever.getInstance().getCurrentWeather(cityName,this);
    }


    @Override
    public void success(CurrentDayWeather currentDayWeather) {
        bundle.putSerializable(CURRENTKEY,currentDayWeather);
        WeatherDataRetriever.getInstance().getForecast(this);
    }

    @Override
    public void success(ForecastForFiveDays forecastForFiveDays) {
        bundle.putSerializable(FORECASTKEY,forecastForFiveDays);
        navigate(R.id.weatherInfoFragment,bundle);
    }
}