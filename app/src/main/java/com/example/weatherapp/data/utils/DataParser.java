package com.example.weatherapp.data.utils;

import android.annotation.SuppressLint;

import com.example.weatherapp.data.model.forecastDays.List;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

public class DataParser {
    @SuppressLint("SimpleDateFormat")
    static SimpleDateFormat df1 = new SimpleDateFormat("EEEE");
    @SuppressLint("SimpleDateFormat")
    static SimpleDateFormat df3 = new SimpleDateFormat("h:mm a");

    public static java.util.List<List> getParsedList(java.util.List<List> data) {
        java.util.List<List> lists = new ArrayList<>();
        df1.setTimeZone(java.util.TimeZone.getTimeZone("UTC+6"));
        Date date1 = new Date();
        for (List list : data) {
            if (!(getDay(list.getDt()).equals(df1.format(date1)))
                    && getTime(list.getDt()).equals("3:00 PM")) {
                lists.add(list);
            }
        }
        return lists;
    }

    public static String getTime(Integer dt) {
        Date date = new java.util.Date(dt * 1000L);
        df3.setTimeZone(TimeZone.getTimeZone("GMT+0600"));
        return df3.format(date);
    }

    public static String getDay(Integer dt) {
        Date date = new java.util.Date(dt * 1000L);
        df1.setTimeZone(java.util.TimeZone.getTimeZone("GMT+0600"));
        return df1.format(date);
    }
}
