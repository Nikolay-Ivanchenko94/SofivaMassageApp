package com.example.sofivamassageapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sofivamassageapp.databinding.ActivityLogoBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogoActivity extends AppCompatActivity{

    private ActivityLogoBinding binding;
    CheckBox remember;
    boolean aBoolean;
    private FirebaseAuth authProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLogoBinding binding = ActivityLogoBinding.inflate(getLayoutInflater());
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(binding.getRoot());
        binding.EditTextEmail.getText();
        binding.EditTextPassword.getText();
        SharedPreferences sharedPreferences = getSharedPreferences("checkbox",MODE_PRIVATE);
        String checkbox = sharedPreferences.getString("remember","");
        if (checkbox.equals("true")) {
            Intent intent = new Intent(LogoActivity.this,UserInterfeaceActivity.class);
            startActivity(intent);
        } else if (checkbox.equals("false"))
            Toast.makeText(LogoActivity.this,"Будь ласка, увійдіть",Toast.LENGTH_LONG).show();
        binding.BtnClickForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogoActivity.this, ForgotPasswordActivity.class);
                startActivity(intent);
                finish();

            }
        });

        binding.BtnClickRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogoActivity.this,RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
        binding.CheckBoxLogo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.isChecked()) {
                    SharedPreferences sharedPreferences = getSharedPreferences("checkbox",MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("remember", "true");
                    editor.apply();
                    Toast.makeText(LogoActivity.this,"Перевіренно",Toast.LENGTH_LONG).show();
                } else if (buttonView.isChecked()) {
                    SharedPreferences sharedPreferences = getSharedPreferences("checkbox",MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("remember", "false");
                    editor.apply();
                    Toast.makeText(LogoActivity.this,"Помилка",Toast.LENGTH_LONG).show();

                }
                aBoolean = isChecked;

            }
        });


        binding.BtnLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (aBoolean) {
                    Intent intent = new Intent(LogoActivity.this, UserInterfeaceActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LogoActivity.this,"Будь ласка, прийміть політику",Toast.LENGTH_LONG).show();
                }
                EditText EditTextEmail = binding.EditTextEmail;
                String email = binding.EditTextEmail.getText().toString();
                EditText EditTextPassword = binding.EditTextPassword;
                String password = binding.EditTextPassword.getText().toString();
                Button BtnLogo = binding.BtnLogo;
                String Btnlogo = binding.BtnLogo.getText().toString();
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(LogoActivity.this,"Введіть ваш E-mail",Toast.LENGTH_LONG).show();
                    EditTextEmail.setError("Невірно введені дані в полі E-mail");
                    EditTextEmail.requestFocus();
                } if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(LogoActivity.this,"Введіть ваш E-mail",Toast.LENGTH_LONG).show();
                    EditTextEmail.setError("Невірно введені дані у полі E-mail");
                    EditTextEmail.requestFocus();
                } if (TextUtils.isEmpty(password)) {
                    Toast.makeText(LogoActivity.this,"Введіть ваш пароль",Toast.LENGTH_LONG).show();
                    EditTextPassword.setError("Невірно введені дані у полі пароль");
                    EditTextPassword.requestFocus();
                } if (password.length() < 5 ) {
                    Toast.makeText(LogoActivity.this,"Пароль повинен мати от 5 символів",Toast.LENGTH_LONG).show();
                    EditTextPassword.setError("Надто слабкий пароль");
                    EditTextPassword.requestFocus();
                    EditTextPassword.clearComposingText();

                }

            }
        });

        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

    }




}