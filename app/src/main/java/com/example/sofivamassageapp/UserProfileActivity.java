package com.example.sofivamassageapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sofivamassageapp.databinding.ActivityUserProfileBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserProfileActivity extends AppCompatActivity {
    private ReadWriteUserDetails readWriteUserDetails;
    private TextView TextViewUserProfile,TextViewUserProfileNameSurname,TextViewUerProfileBd,TextViewUerProfileEmail,TextViewUserProfilePhone;
    private  FirebaseAuth auth;
    private  String nameSurname,Bd,Phone,Email;
    private ImageView imageView;


    ActivityUserProfileBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActivityUserProfileBinding binding = ActivityUserProfileBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        binding.TextViewUserProfileName.setText("Налаштування");
        TextView TextViewUerProfileName = binding.TextViewUserProfileName;
        String  nameSurname = binding.TextViewUserProfileName.getText().toString();
        binding.TextViewUserProfileBd.setText("Налаштування");
        TextView TextViewUserProfileBd = binding.TextViewUserProfileBd;
        String Bd = binding.TextViewUserProfileBd.getText().toString();
        binding.TextViewUserProfilePhone.setText("Налаштування");
        TextView TextViewUserProfilePhone = binding.TextViewUserProfilePhone;
        String Phone = binding.TextViewUserProfilePhone.getText().toString();
        binding.TextViewUserProfileEmail.setText("Налаштування");
        TextView TextViewUserProfileEmail = binding.TextViewUserProfileEmail;
        String Email = binding.TextViewUserProfileEmail.getText().toString();
        binding.BtnComeBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserProfileActivity.this,UserInterfeaceActivity.class);
                startActivity(intent);
                finish();
            }
        });

        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = auth.getCurrentUser();

        if (firebaseUser ==null) {
            Toast.makeText(UserProfileActivity.this,"Щось пішло не так! Зареєстрований користувач не доступний",Toast.LENGTH_LONG).show();

        } else {
            showUserProfile(firebaseUser);
        }
    }

    private void showUserProfile(FirebaseUser firebaseUser) {
        String userID = firebaseUser.getUid();
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Зареєстрований користувач");
        databaseReference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ReadWriteUserDetails readWriteUserDetails = snapshot.getValue(ReadWriteUserDetails.class);
                if (readWriteUserDetails !=null) {
                    nameSurname = firebaseUser.getDisplayName();
                    Bd = readWriteUserDetails.dob;
                    Email = firebaseUser.getEmail();
                    Phone = readWriteUserDetails.phone;

                    TextViewUserProfile.setText("Привіт" + nameSurname);
                    TextViewUserProfileNameSurname.setText(nameSurname);
                    TextViewUerProfileBd.setText(Bd);
                    TextViewUserProfilePhone.setText(Phone);
                    TextViewUerProfileEmail.setText(Email);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UserProfileActivity.this,"Щось пішло не так",Toast.LENGTH_LONG).show();


            }
        });
    }
}
