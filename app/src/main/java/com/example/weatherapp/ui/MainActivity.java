package com.example.weatherapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.weatherapp.R;
import com.example.weatherapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.example.weatherapp.databinding.ActivityMainBinding bind = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());
    }
}