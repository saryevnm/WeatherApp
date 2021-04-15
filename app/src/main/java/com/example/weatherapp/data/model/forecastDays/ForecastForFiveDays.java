package com.example.weatherapp.data.model.forecastDays;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ForecastForFiveDays implements Serializable {

    @SerializedName("cod")
    private String cod;

    @SerializedName("message")
    private Integer message;

    @SerializedName("cnt")
    private Integer cnt;

    @SerializedName("list")
    private java.util.List<List> list = null;

    @SerializedName("city")
    private City city;

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Integer getMessage() {
        return message;
    }

    public void setMessage(Integer message) {
        this.message = message;
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public java.util.List<List> getList() {
        return list;
    }

    public void setList(java.util.List<List> list) {
        this.list = list;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
