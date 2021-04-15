package com.example.weatherapp.data.model.forecastDays;

import com.google.gson.annotations.SerializedName;

public class Clouds {


    @SerializedName("all")
    private Integer all;

    public Integer getAll() {
        return all;
    }

    public void setAll(Integer all) {
        this.all = all;
    }
}
