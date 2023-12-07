package com.example.sofivamassageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.sofivamassageapp.databinding.ActivityMassagePregnantWomenBinding;

public class MassagePregnantWomenActivity extends AppCompatActivity {
    ActivityMassagePregnantWomenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMassagePregnantWomenBinding binding = ActivityMassagePregnantWomenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.TextViewMassagePregnantWoomen.setText("Soul and Body");
        TextView TextViewMassagePregnantWomen = binding.TextViewMassagePregnantWoomen;
        String TextViewMassageWomen = binding.TextViewMassagePregnantWoomen.getText().toString();
        binding.TextViewMassagePregnant.setText("Массаж для вагітних");
        TextView TextViewMassagePregnant = binding.TextViewMassagePregnant;
        String TextViewWomen = binding.TextViewMassagePregnant.getText().toString();
        binding.TextViewPregnant.getText();
        TextView TextViewPregnant = binding.TextViewPregnant;
        String MassagePregnantWomen = binding.TextViewPregnant.getText().toString();
        binding.TextViewPregnantTime.setText("60 хвилин");
        TextView TextViewPregnantTime = binding.TextViewPregnantTime;
        String TextViewTime = binding.TextViewPregnantTime.getText().toString();
        binding.TextViewPregnantCash.setText("600 гривень");
        TextView TextViewPregnantCash = binding.TextViewPregnantCash;
        String TextViewCash = binding.TextViewPregnantCash.getText().toString();
        binding.BtnMassagePregnantWomenFAQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MassagePregnantWomenActivity.this, FAQActivity.class);
                startActivity(intent);
                finish();
            }
        });
        binding.BtnMassagePregnantAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MassagePregnantWomenActivity.this, UserProfileActivity.class);
                startActivity(intent);
                finish();
            }
        });
        binding.BtnMassagePregnantServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MassagePregnantWomenActivity.this, MassagePregnantWomenActivity.class);
                startActivity(intent);
                finish();
            }
        });
        binding.BtnMassagePregnantSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(MassagePregnantWomenActivity.this, SettingsActivity.class);
                startActivity(intent);
                finish();
            }
        });
        binding.BtnMassagePregnantWomenAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MassagePregnantWomenActivity.this, AboutActivity.class);
                startActivity(intent);
                finish();
            }
        });




    }
}