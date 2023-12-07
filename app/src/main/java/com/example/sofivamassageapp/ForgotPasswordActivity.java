package com.example.sofivamassageapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.test.espresso.remote.EspressoRemoteMessage;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sofivamassageapp.databinding.ActivityForgotPasswordBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class ForgotPasswordActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    private ImageView view;

    ActivityForgotPasswordBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActivityForgotPasswordBinding binding = ActivityForgotPasswordBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        binding.TextViewForgotPassword.setText("Забули пароль");
        TextView TextViewForgotPassword = binding.TextViewForgotPassword;
        String TextForgotPassword = binding.TextViewForgotPassword.getText().toString();
        binding.TextViewForgotPassword1.setText("Введіть ваш E-mail для відновлення пароля");
        TextView TextViewForgotPassword1 = binding.TextViewForgotPassword1;
        String ForgotPassword = binding.TextViewForgotPassword1.getText().toString();
        binding.TextViewForgotPasswordEmail.setText("Введіть ваш E-mail");
        TextView TextViewForgotPasswordEmail = binding.TextViewForgotPasswordEmail;
        String ForgotEmail = binding.TextViewForgotPasswordEmail.getText().toString();
        binding.BtnForgotPassword.getText();
        binding.BtnForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.EditTextForgotPasswordEmail.getText();
                EditText EditTextForgotPasswordEmail = binding.EditTextForgotPasswordEmail;
                String Email = binding.EditTextForgotPasswordEmail.getText().toString();
                if (TextUtils.isEmpty(Email)) {
                    Toast.makeText(ForgotPasswordActivity.this,"Будь Ласка введіть зареєстрований E-mail",Toast.LENGTH_LONG).show();
                    EditTextForgotPasswordEmail.setError("E-mail не доступний");
                    EditTextForgotPasswordEmail.requestFocus();
                } if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
                    Toast.makeText(ForgotPasswordActivity.this,"Будь Ласка введіть зареєстрований E-mail",Toast.LENGTH_LONG).show();
                    EditTextForgotPasswordEmail.setError("E-mail не доступний");
                    EditTextForgotPasswordEmail.requestFocus();
                } else {
                    resetPassword(Email);
                }
            }
        });

    }

    private void resetPassword(String Email) {
        auth = FirebaseAuth.getInstance();
        auth.sendPasswordResetEmail(Email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(ForgotPasswordActivity.this,"Будь ласка перевірте ваш E-mail",Toast.LENGTH_LONG).show();
                     Intent intent = new Intent(ForgotPasswordActivity.this,LogoActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK
                            | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();

                }
            }
        });

    }
}