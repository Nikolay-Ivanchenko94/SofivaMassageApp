package com.example.sofivamassageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sofivamassageapp.databinding.ActivityMassageOverBinding;

public class MassageOverActivity extends AppCompatActivity {
    ActivityMassageOverBinding binding;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMassageOverBinding binding = ActivityMassageOverBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.TextViewActivityMassage.setText("Soul and Body");
        TextView TextViewActivityMassage = binding.TextViewActivityMassage;
        String TextViewMassage = binding.TextViewActivityMassage.getText().toString();
        binding.TextViewMassageOver.setText("Загальний массаж тіла");
        TextView TextViewMassageOver = binding.TextViewMassageOver;
        String TextViewOver = binding.TextViewMassageOver.getText().toString();
        binding.TextViewMassageOverText.getText();
        TextView TextViewMassageOverText = binding.TextViewMassageOverText;
        String TextViewOverText = binding.TextViewMassageOverText.getText().toString();
        binding.TextViewMassageOverTime.setText("90 хвилин");
        TextView TextViewMassageOverTime = binding.TextViewMassageOverTime;
        String TextViewMassageTime = binding.TextViewMassageOverTime.getText().toString();
        binding.TextViewMassageOverCash.setText("900 гривень");
        TextView TextViewMassageOverCash = binding.TextViewMassageOverCash;
        String TextViewOverCash = binding.TextViewMassageOverCash.getText().toString();
        binding.BtnMassageOverFAQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MassageOverActivity.this, FAQActivity.class);
                startActivity(intent);
                finish();

            }
        });
        binding.BtnMassageOverAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MassageOverActivity.this, UserProfileActivity.class);
                startActivity(intent);
                finish();
            }
        });
        binding.BtnMassageOverServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MassageOverActivity.this, MassageOverActivity.class);
                startActivity(intent);
                finish();
            }
        });
        binding.BtnMassageOverSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MassageOverActivity.this, SettingsActivity.class);
                startActivity(intent);
                finish();
            }
        });
        binding.BtnMassageOverAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MassageOverActivity.this, AboutActivity.class);
                startActivity(intent);
                finish();
            }
        });
        binding.BtnNextPageMassageOver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MassageOverActivity.this, MassageFaceActivity.class);
                startActivity(intent);
                finish();

            }
        });
        binding.BtnArrowMassageOver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MassageOverActivity.this, UserInterfeaceActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}