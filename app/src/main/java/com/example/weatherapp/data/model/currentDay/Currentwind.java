package com.example.weatherapp.data.model.currentDay;

import com.google.gson.annotations.SerializedName;

public class Currentwind {



    @SerializedName("speed")
    private Double speed;

    @SerializedName("deg")
    private Integer deg;

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Integer getDeg() {
        return deg;
    }

    public void setDeg(Integer deg) {
        this.deg = deg;
    }
}
