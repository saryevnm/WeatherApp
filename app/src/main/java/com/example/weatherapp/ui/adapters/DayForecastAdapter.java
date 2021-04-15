package com.example.weatherapp.ui.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.weatherapp.data.model.currentDay.CurrentWeather;
import com.example.weatherapp.data.model.forecastDays.List;
import com.example.weatherapp.data.utils.DataParser;
import com.example.weatherapp.databinding.ItemForDayForecastBinding;

import java.util.Date;

public class DayForecastAdapter extends RecyclerView.Adapter<DayForecastAdapter.ViewHolder> {
    private final java.util.List<List> list;
    private final Context context;


    public DayForecastAdapter(java.util.List<List> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public DayForecastAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemForDayForecastBinding bind = ItemForDayForecastBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new ViewHolder(bind);
    }

    @Override
    public void onBindViewHolder(@NonNull DayForecastAdapter.ViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemForDayForecastBinding ui;

        public ViewHolder(@NonNull ItemForDayForecastBinding ui) {
            super(ui.getRoot());
            this.ui = ui;
        }

        @SuppressLint("SetTextI18n")
        public void onBind(List list) {
            ui.timeForDay.setText(DataParser.getTime(list.getDt()));
            ui.tempForDay.setText(list.getMain().getTemp() + "°");
            Glide.with(context)
                    .load("http://openweathermap.org/img/w/" + list.getWeather().get(0).getIcon() + ".png")
                    .into(ui.iconForDay);
        }
    }
}
