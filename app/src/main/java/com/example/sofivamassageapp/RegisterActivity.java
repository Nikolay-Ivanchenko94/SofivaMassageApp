package com.example.sofivamassageapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sofivamassageapp.databinding.ActivityRegisterBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class RegisterActivity extends AppCompatActivity {

    ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       ActivityRegisterBinding binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        binding.BtnRegisterBtn.getText();

        binding.EditTextRegisterNameSurname.getText();
        binding.EditTextRegisterBd.getText();
        binding.EditTextRegisterPhone.getText();
        binding.EditTextRegisterEmail.getText();
        binding.EditTextRegisterPsw.getText();
        binding.EditTextRegisterReturnPsw.getText();
        binding.BtnRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText EditTextRegisterNameSurname = binding.EditTextRegisterNameSurname;
                String NameSurname = binding.EditTextRegisterNameSurname.getText().toString();
                EditText EditTextRegisterBd = binding.EditTextRegisterBd;
                String Bd = binding.EditTextRegisterBd.getText().toString();
                EditText EditTextRegisterPhone = binding.EditTextRegisterPhone;
                String Phone = binding.EditTextRegisterPhone.getText().toString();
                EditText EditTextRegisterEmail = binding.EditTextRegisterEmail;
                String Email = binding.EditTextRegisterEmail.getText().toString().trim();
                EditText EditTextRegisterPsw = binding.EditTextRegisterPsw;
                String Psw = binding.EditTextRegisterPsw.getText().toString().trim();
                EditText EditTextRegisterReturnPsw = binding.EditTextRegisterReturnPsw;
                Button BtnRegisterBtn = binding.BtnRegisterBtn;
                String Btn = binding.BtnRegisterBtn.getText().toString();
                String ReturnPsw = binding.EditTextRegisterReturnPsw.getText().toString();
                Intent intent = new Intent(RegisterActivity.this, LogoActivity.class);
                startActivity(intent);
                finish();
                binding.BtnRegisterComeBack.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(RegisterActivity.this, LogoActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
                EditTextRegisterBd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final  Calendar calendar = Calendar.getInstance();
                        int day = calendar.get(Calendar.DAY_OF_MONTH);
                        int month = calendar.get(Calendar.MONTH);
                        int year = calendar.get(Calendar.YEAR);

                        //Date Picker Dialog
                        DatePickerDialog picker = new DatePickerDialog(RegisterActivity.this, new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                EditTextRegisterBd.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                            }
                        },day,month,year);
                        picker.show();
                    }
                });




                if (TextUtils.isEmpty(NameSurname)) {
                    Toast.makeText(RegisterActivity.this,"Введіть ваше Ім'я та прізвище",Toast.LENGTH_LONG).show();
                    EditTextRegisterNameSurname.setError("Невірно введені дані в полі Ім'я та прізвище");
                    EditTextRegisterNameSurname.requestFocus();
                } if (TextUtils.isEmpty(Bd)) {
                    Toast.makeText(RegisterActivity.this,"Введіть вашу дату народження",Toast.LENGTH_LONG).show();
                    EditTextRegisterBd.setError("Невірно введені дані в полі дата народження");
                    EditTextRegisterBd.requestFocus();
                } if (TextUtils.isEmpty(Phone)) {
                    Toast.makeText(RegisterActivity.this,"Введіть ваш номер телефону",Toast.LENGTH_LONG).show();
                    EditTextRegisterPhone.setError("Невірно введені дані в полі номер телефону");
                    EditTextRegisterPhone.requestFocus();
                } if (Phone.length() < 10 ) {
                    Toast.makeText(RegisterActivity.this,"Номер телефону повинен мати до 10 символів",Toast.LENGTH_LONG).show();
                    EditTextRegisterPhone.setError("Надто слабкий номер телефону");
                    EditTextRegisterPhone.requestFocus();
                } if (TextUtils.isEmpty(Email)) {
                    Toast.makeText(RegisterActivity.this,"Введіть ваш E-mail",Toast.LENGTH_LONG).show();
                    EditTextRegisterEmail.setError("Невірно введені дані в полі E-mail");
                    EditTextRegisterEmail.requestFocus();
                } if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
                    Toast.makeText(RegisterActivity.this,"Введіть ваш E-mail",Toast.LENGTH_LONG).show();
                    EditTextRegisterEmail.setError("Невірно введені дані в полі E-mail");
                    EditTextRegisterEmail.requestFocus();
                } if (TextUtils.isEmpty(Psw)) {
                    Toast.makeText(RegisterActivity.this,"Введіть ваш пароль",Toast.LENGTH_LONG).show();
                    EditTextRegisterPsw.setError("Невірно введені дані в полі пароль ");
                    EditTextRegisterPsw.requestFocus();
                } if (Psw.length() < 5 ) {
                    Toast.makeText(RegisterActivity.this,"Пароль повинен мати от 5 символів",Toast.LENGTH_LONG).show();
                    EditTextRegisterPsw.setError("Надто слабкий пароль");
                    EditTextRegisterPsw.requestFocus();
                } if (TextUtils.isEmpty(ReturnPsw)) {
                    Toast.makeText(RegisterActivity.this,"Введіть повторно пароль", Toast.LENGTH_LONG).show();
                    EditTextRegisterReturnPsw.setError("Невірно введені дані в полі пароль");
                    EditTextRegisterReturnPsw.requestFocus();
                } if (ReturnPsw.length() < 5 ) {
                    Toast.makeText(RegisterActivity.this,"Пароль повинен мати от 5 символів",Toast.LENGTH_LONG).show();
                    EditTextRegisterReturnPsw.setError("Невірно введені дані в полі пароль");
                    EditTextRegisterReturnPsw.requestFocus();
                    EditTextRegisterPsw.clearComposingText();
                    EditTextRegisterReturnPsw.clearComposingText();


                } else {
                    registeruser(Email,Psw,Phone,Bd,ReturnPsw,NameSurname);

                }
            }
        });
    }

    private void registeruser(String email, String psw, String phone, String bd, String returnPsw, String nameSurname) {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.createUserWithEmailAndPassword(email,psw).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(RegisterActivity.this,"Користувач успішно зареєстрован",Toast.LENGTH_LONG).show();
                    FirebaseUser firebaseUser = auth.getCurrentUser();
                    ReadWriteUserDetails writeUserDatails = new ReadWriteUserDetails(nameSurname,bd,phone);
                    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Зареєстрований користувач");

                    databaseReference.child(firebaseUser.getUid()).setValue(writeUserDatails).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                firebaseUser.sendEmailVerification();

                                Toast.makeText(RegisterActivity.this,"Користувач успішно зареєстрован.Будь Ласка перевірте ваш E-mail",Toast.LENGTH_LONG).show();
                                // Open User Profile after successful registration
                                Intent intent = new Intent(RegisterActivity.this,LogoActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK
                                        | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                                finish(); firebaseUser.sendEmailVerification();
                            } else {
                                Toast.makeText(RegisterActivity.this,"Щось пішло не так",Toast.LENGTH_LONG).show();

                            }


                        }
                    });




                }
                }

        });
    }



    }