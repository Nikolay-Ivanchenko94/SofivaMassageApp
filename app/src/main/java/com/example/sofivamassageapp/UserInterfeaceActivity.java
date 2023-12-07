package com.example.sofivamassageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.slice.SliceItem;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sofivamassageapp.databinding.ActivityUserInterfeceBinding;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class UserInterfeaceActivity extends AppCompatActivity {
    private ImageView imageView;

    ActivityUserInterfeceBinding binding;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActivityUserInterfeceBinding binding = ActivityUserInterfeceBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        binding.TextViewActivityUser.setText("Soul and Body");
        TextView TextViewActivityUser = binding.TextViewActivityUser;
        String TextViewUser = binding.TextViewActivityUser.getText().toString();
        binding.TextViewMassage.setText("Лікувальний масаж спини");
        TextView TextViewMassage = binding.TextViewMassage;
        String TextVieUserMassage = binding.TextViewMassage.getText().toString();
        binding.TextViewMassageBack.getText();
        TextView TextViewMassageBack = binding.TextViewMassageBack;
        String TextViewActivityMassageBack = binding.TextViewMassageBack.getText().toString();
        binding.TextViewActivityTime.setText("40 хвилин");
        TextView TextViewActivityTime = binding.TextViewActivityTime;
        String TextViewTime = binding.TextViewActivityTime.getText().toString();
        binding.TextViewActivityCash.setText("400 гривень");
        TextView TextViewCash = binding.TextViewActivityCash;
        String TextViewMoney = binding.TextViewActivityCash.getText().toString();
        binding.BtnFAQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserInterfeaceActivity.this,FAQActivity.class);
                startActivity(intent);
                finish();
            }
        });
        binding.BtnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserInterfeaceActivity.this,UserProfileActivity.class);
                startActivity(intent);
                finish();
            }
        });
        binding.BtnServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserInterfeaceActivity.this,UserInterfeaceActivity.class);
                startActivity(intent);
                finish();
            }
        });
        binding.BtnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserInterfeaceActivity.this, SettingsActivity.class);
                startActivity(intent);
                finish();
            }
        });
        binding.BtnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserInterfeaceActivity.this,AboutActivity.class);
                startActivity(intent);
                finish();

            }
        });
        binding.BtnNextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserInterfeaceActivity.this, MassageOverActivity.class);
                startActivity(intent);

            }
        });
        binding.BtnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}