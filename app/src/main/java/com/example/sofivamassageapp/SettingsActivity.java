package com.example.sofivamassageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sofivamassageapp.databinding.ActivitySettingsBinding;

public class SettingsActivity extends AppCompatActivity {
    ActivitySettingsBinding binding;
    ImageView view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActivitySettingsBinding binding = ActivitySettingsBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        binding.TextViewSetting.setText("Налаштування");
        TextView TextViewSetting = binding.TextViewSetting;
        String TextSetting = binding.TextViewSetting.getText().toString();
        binding.TextViewUserSettings.setText("Акаунт");
        TextView TextViewUserSettings = binding.TextViewUserSettings;
        String TextUserSettings = binding.TextViewUserSettings.getText().toString();
        binding.TextViewNotification.setText("Повідомлення");
        TextView TextViewNotification = binding.TextViewNotification;
        String TextNotification = binding.TextViewNotification.getText().toString();
        binding.TextViewLanguage.setText("Мова");
        TextView TextViewLanguage = binding.TextViewLanguage;
        String TextLanguage = binding.TextViewLanguage.getText().toString();
        binding.TextViewPrivacyPolicy.setText("Політіка конфідеційності");
        TextView TextViewPrivacyPolicy = binding.TextViewPrivacyPolicy;
        String TextPrivacyPolicy = binding.TextViewPrivacyPolicy.getText().toString();
        binding.TextViewHelpSupport.setText(" Допомога і Підтримка ");
        TextView TextViewHelpSupport = binding.TextViewHelpSupport;
        String TextSupport = binding.TextViewHelpSupport.getText().toString();
        binding.TextViewAbout.setText("Про нас");
        TextView TextViewAbout = binding.TextViewAbout;
        String TextAbout = binding.TextViewAbout.getText().toString();
        binding.TextViewLogOut.setText("Вийти");
        TextView TextViewLogOut = binding.TextViewLogOut;
        String TextLogOut = binding.TextViewAbout.getText().toString();

        binding.BtnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this,UserInterfeaceActivity.class);
                startActivity(intent);
                finish();
            }
        });

        binding.BtnAccountArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this,AccountActivity.class);
                startActivity(intent);
                finish();
            }
        });
        binding.BtnLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, LanguageActivity.class);
                startActivity(intent);
                finish();
            }
        });
        binding.BtnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(SettingsActivity.this,LogoActivity.class);
               startActivity(intent);
            }
        });

    }

}