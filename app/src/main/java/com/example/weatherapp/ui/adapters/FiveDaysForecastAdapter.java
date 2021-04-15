package com.example.weatherapp.ui.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.weatherapp.data.model.forecastDays.List;
import com.example.weatherapp.data.utils.DataParser;
import com.example.weatherapp.databinding.ItemForFiveDaysForecastBinding;

public class FiveDaysForecastAdapter extends RecyclerView.Adapter<FiveDaysForecastAdapter.ViewHolder> {
    private final java.util.List<List> list;
    private final Context context;

    public FiveDaysForecastAdapter(java.util.List<List> list,Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public FiveDaysForecastAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        com.example.weatherapp.databinding.ItemForFiveDaysForecastBinding bind = ItemForFiveDaysForecastBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new ViewHolder(bind);
    }

    @Override
    public void onBindViewHolder(@NonNull FiveDaysForecastAdapter.ViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemForFiveDaysForecastBinding ui;
        public ViewHolder(@NonNull ItemForFiveDaysForecastBinding ui) {
            super(ui.getRoot());
            this.ui = ui;
        }

        @SuppressLint("SetTextI18n")
        public void onBind(List list) {
            String date = DataParser.getDay(list.getDt());
            ui.whichDay.setText(date);
            Glide.with(context)
                    .load("http://openweathermap.org/img/w/" + list
                            .getWeather()
                            .get(0)
                            .getIcon() + ".png")
                    .into(ui.whichImage);
            ui.whichTemp.setText(list.getMain().getTemp()+"°");
            ui.whichSpeed.setText(list.getWind().getSpeed()+"km/h");
        }
    }
}
