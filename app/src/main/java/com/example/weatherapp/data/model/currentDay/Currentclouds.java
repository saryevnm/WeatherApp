package com.example.weatherapp.data.model.currentDay;

import com.google.gson.annotations.SerializedName;

public class Currentclouds {

    @SerializedName("all")
    private Integer all;

    public Integer getAll() {
        return all;
    }

    public void setAll(Integer all) {
        this.all = all;
    }
}
