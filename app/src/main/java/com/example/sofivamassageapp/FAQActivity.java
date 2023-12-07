package com.example.sofivamassageapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sofivamassageapp.databinding.ActivityFaqactivityBinding;

public class FAQActivity extends AppCompatActivity {

String title;
String description;
boolean isVisible;

    ActivityFaqactivityBinding binding;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityFaqactivityBinding binding = ActivityFaqactivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
public FAQActivity(String title,String description, boolean isVisible) {
        this.title = title;
        this.description = description;
        this.isVisible = isVisible;
}
}