package com.example.weatherapp.ui.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapp.databinding.CityItemBinding;

import java.util.List;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.ViewHolder> {

    private final List<String> list;
    private final click listener;

    public CityAdapter(List<String> list, click listener) {
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CityItemBinding binding = CityItemBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private final CityItemBinding ui;

        public ViewHolder(@NonNull CityItemBinding ui) {
            super(ui.getRoot());
            this.ui = ui;
            ui.getRoot().setOnClickListener(v -> {
                listener.click(list.get(getAdapterPosition()));
            });
        }
        public void onBind(String s) {
            ui.txCity.setText(s);
        }
    }

    public interface click {
        void click(String cityName);
    }
}
