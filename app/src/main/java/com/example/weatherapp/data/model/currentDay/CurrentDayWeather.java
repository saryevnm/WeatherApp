package com.example.weatherapp.data.model.currentDay;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class CurrentDayWeather implements Serializable {

    @SerializedName("coord")
    private Coord coord;

    @SerializedName("weather")
    private List<CurrentWeather> currentWeather = null;

    @SerializedName("base")
    private String base;

    @SerializedName("main")
    private CurrentMain currentMain;

    @SerializedName("visibility")
    private Integer visibility;

    @SerializedName("wind")
    private Currentwind wind;

    @SerializedName("clouds")
    private Currentclouds currentclouds;

    @SerializedName("dt")
    private Integer dt;

    @SerializedName("sys")
    private CurrentSys currentSys;

    @SerializedName("timezone")
    private Integer timezone;

    @SerializedName("id")
    private Integer id;

    @SerializedName("name")
    private String name;

    @SerializedName("cod")
    private Integer cod;

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public List<CurrentWeather> getCurrentWeather() {
        return currentWeather;
    }

    public void setCurrentWeather(List<CurrentWeather> currentWeather) {
        this.currentWeather = currentWeather;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public CurrentMain getCurrentMain() {
        return currentMain;
    }

    public void setCurrentMain(CurrentMain currentMain) {
        this.currentMain = currentMain;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    public Currentwind getWind() {
        return wind;
    }

    public void setWind(Currentwind wind) {
        this.wind = wind;
    }

    public Currentclouds getCurrentclouds() {
        return currentclouds;
    }

    public void setCurrentclouds(Currentclouds currentclouds) {
        this.currentclouds = currentclouds;
    }

    public Integer getDt() {
        return dt;
    }

    public void setDt(Integer dt) {
        this.dt = dt;
    }

    public CurrentSys getCurrentSys() {
        return currentSys;
    }

    public void setCurrentSys(CurrentSys currentSys) {
        this.currentSys = currentSys;
    }

    public Integer getTimezone() {
        return timezone;
    }

    public void setTimezone(Integer timezone) {
        this.timezone = timezone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }
}
