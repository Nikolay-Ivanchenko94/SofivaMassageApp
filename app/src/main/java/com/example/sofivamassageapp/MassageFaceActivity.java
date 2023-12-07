package com.example.sofivamassageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sofivamassageapp.databinding.ActivityMassageFaceBinding;
import com.example.sofivamassageapp.databinding.ActivityMassagePregnantWomenBinding;

public class MassageFaceActivity extends AppCompatActivity {
    ActivityMassageFaceBinding binding;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMassageFaceBinding binding = ActivityMassageFaceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        binding.TextViewMassageFace.setText("Soul and Body");
        TextView TextViewMassageFace = binding.TextViewMassageFace;
        String TextViewFace = binding.TextViewMassageFace.getText().toString();
        binding.TextViewMassageTotalFace.setText("Масаж обличчя");
        TextView TextViewMassageTotalFace = binding.TextViewMassageTotalFace;
        String TextViewTotalFace = binding.TextViewMassageTotalFace.getText().toString();
        binding.TextViewMassageFace.getText();
        TextView TextViewMassage = binding.TextViewMassageFace;
        String TextViewMassageFaceTotal = binding.TextViewMassageFace.getText().toString();
        binding.TextViewMassageFaceTime.setText("30 хвилин");
        TextView TextViewMassageFaceTime = binding.TextViewMassageFaceTime;
        String TextViewMassageTime = binding.TextViewMassageFaceTime.getText().toString();
        binding.TextViewMassageCash.setText("400 гривень");
        TextView TextViewMassageCash = binding.TextViewMassageCash;
        String TextViewCash = binding.TextViewMassageCash.getText().toString();
        binding.BtnMassageFaceFAQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MassageFaceActivity.this, FAQActivity.class);
                startActivity(intent);
                finish();

            }
        });
        binding.BtnMassageFaceAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MassageFaceActivity.this, UserProfileActivity.class);
                startActivity(intent);
                finish();
            }
        });
        binding.BtnMassageFaceServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MassageFaceActivity.this, MassageFaceActivity.class);
                startActivity(intent);
                finish();
            }
        });
        binding.BtnMassageFaceSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MassageFaceActivity.this, SettingsActivity.class);
                startActivity(intent);
                finish();
            }
        });
        binding.BtnMassageFaceAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MassageFaceActivity.this,AboutActivity.class);
                startActivity(intent);
                finish();
            }
        });
        binding.BtnMassageNextPageFace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Intent intent = new Intent(MassageFaceActivity.this,MassagePregnantWomenActivity.class);
             startActivity(intent);
             finish();
            }
        });
        binding.BtnArrowMassageFace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MassageFaceActivity.this,MassageOverActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}