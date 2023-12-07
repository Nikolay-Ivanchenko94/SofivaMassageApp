package com.example.sofivamassageapp;


import static android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN;
import static com.example.sofivamassageapp.R.id.TextSplashScreen;
import static com.example.sofivamassageapp.R.id.TextViewAnimation;

import static kotlin.concurrent.ThreadsKt.thread;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.window.SplashScreen;

import com.example.sofivamassageapp.databinding.ActivitySplashBinding;

import org.w3c.dom.Text;

import kotlin.Pair;

public class SplashActivity extends AppCompatActivity {
    private static int SPLASH_SCREEN_DELAY = 3000;
    Handler handler = new Handler();
    private Object Window;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);

        TextView textView = findViewById(R.id.TextSplashScreen);
        ImageView imageView = findViewById(R.id.TextViewAnimation);

        textView.animate().translationX(1000).setDuration(1000).setStartDelay(2500);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, LogoActivity.class);
                startActivity(intent);
                finish();

                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<>(imageView, "logo_image");
                pairs[1] = new Pair<>(textView, "logo_text");








            }
        },SPLASH_SCREEN_DELAY);


            };

                }





