package com.example.sofivamassageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.sofivamassageapp.databinding.ActivityLanguageBinding;

import java.util.Locale;

public class LanguageActivity extends AppCompatActivity {
    ActivityLanguageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLanguageBinding binding = ActivityLanguageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.TextViewPolishLanguage.setText("Polska");
        TextView TextViewPolishLanguage = binding.TextViewPolishLanguage;
        String TextViewPolish = binding.TextViewPolishLanguage.getText().toString();
        binding.BtnPolishArrowRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Locale locale = new Locale("PL");
                Configuration configuration = getBaseContext().getResources().getConfiguration();
                configuration.locale = locale;
                getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());
                Intent intent = new Intent(LanguageActivity.this, UserInterfeaceActivity.class);
                startActivity(intent);
            }
        });
        binding.BtnLanguageArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LanguageActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });
        binding.BtnCzechArrowRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Locale locale = new Locale("CZ");
                Configuration configuration = getBaseContext().getResources().getConfiguration();
                configuration.locale = locale;
                getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());
                Intent intent = new Intent(LanguageActivity.this,UserInterfeaceActivity.class);
                startActivity(intent);
            }
        });

    }
}