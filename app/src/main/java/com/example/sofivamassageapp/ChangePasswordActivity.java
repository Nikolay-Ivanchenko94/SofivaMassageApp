package com.example.sofivamassageapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.test.espresso.remote.EspressoRemoteMessage;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sofivamassageapp.databinding.AcivityChangePasswordBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ChangePasswordActivity extends AppCompatActivity {

    FirebaseUser firebaseUser;

    ImageView view;

    FirebaseAuth auth;


    AcivityChangePasswordBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AcivityChangePasswordBinding binding = AcivityChangePasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        binding.TextViewChangePassword.setText("Поточний пароль");
        TextView TextViewChangePassword = binding.TextViewChangePassword;
        String TextChangePassword = binding.TextViewChangePassword.getText().toString();
        binding.EditTextCurrentPassword.getText();
        EditText EditTextCurrentPassword = binding.EditTextCurrentPassword;
        String CurrentPassword = binding.EditTextCurrentPassword.getText().toString();
        binding.TextViewNewPassword.setText("Новий пароль");
        TextView TextViewNewPassword = binding.TextViewNewPassword;
        String TextNewPassword = binding.TextViewNewPassword.getText().toString();
        binding.EditTextNewPassword.getText();
        EditText EditTextNewPassword = binding.EditTextNewPassword;
        String NewPassword = binding.EditTextNewPassword.getText().toString();
        binding.TextViewConfirmPassword.setText("Пітвердження пароля");
        TextView TextViewConfirmPassword = binding.TextViewConfirmPassword;
        String TextConfirmPassword = binding.TextViewConfirmPassword.getText().toString();
        binding.EditTextConfirmPassword.getText();
        EditText EditTextConfirmPassword = binding.EditTextConfirmPassword;
        String ConfirmPassword = binding.EditTextConfirmPassword.getText().toString();

        binding.BtnSetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChangePasswordActivity.this, UserProfileActivity.class);
                startActivity(intent);
                finish();
            }
        });
        if (TextUtils.isEmpty(CurrentPassword)) {
            Toast.makeText(ChangePasswordActivity.this, "Введіть ваш старий пароль", Toast.LENGTH_LONG).show();
            EditTextCurrentPassword.setError("Невірний пароль");
            EditTextCurrentPassword.requestFocus();
        } if (CurrentPassword.matches(CurrentPassword)) {
            Toast.makeText(ChangePasswordActivity.this,"Старий пароль має містити от 5 симвоілв",Toast.LENGTH_LONG).show();
            EditTextCurrentPassword.setError("Надто слабкий пароль");
            EditTextCurrentPassword.requestFocus();
        } if (TextUtils.isEmpty(NewPassword)) {
            Toast.makeText(ChangePasswordActivity.this,"Введіть ваш новий пароль",Toast.LENGTH_LONG).show();
            EditTextNewPassword.setError("Невірний пароль");
            EditTextNewPassword.requestFocus();
        } if (NewPassword.matches(NewPassword)) {
            Toast.makeText(ChangePasswordActivity.this,"Новий пароль має містити от 5 символів",Toast.LENGTH_LONG).show();
            EditTextNewPassword.setError("Надто слабкий пароль");
            EditTextNewPassword.requestFocus();
        } if (TextUtils.isEmpty(ConfirmPassword)) {
            Toast.makeText(ChangePasswordActivity.this,"Підтвердіть ваш новий пароль",Toast.LENGTH_LONG).show();
            EditTextConfirmPassword.setError("Невірний пароль");
            EditTextConfirmPassword.requestFocus();
        } if (ConfirmPassword.matches(ConfirmPassword)) {
            Toast.makeText(ChangePasswordActivity.this,"Пароль має містити от 5 символів",Toast.LENGTH_LONG).show();
            EditTextConfirmPassword.setError("Надто слабкий пароль");
            EditTextConfirmPassword.requestFocus();
        }

        }

    private void changepassword(FirebaseUser firebaseUser) {
        String UserID = firebaseUser.getUid();
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Заміна Пароля");
    }


}

