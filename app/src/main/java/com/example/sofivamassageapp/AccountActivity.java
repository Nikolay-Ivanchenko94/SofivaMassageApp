package com.example.sofivamassageapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sofivamassageapp.databinding.ActivityAccountBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AccountActivity extends AppCompatActivity {
    private  ReadWriteUserDetails readWriteUserDetails;
    private TextView TextViewAccount,TextViewName,TextViewBd,TextViewPhone,TextViewEmail,TextViewChangePassword;
    String Account,Name,Bd,Phone,Email,ChangePassword;
    private FirebaseAuth auth;
    private ImageView imageView;
    ActivityAccountBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityAccountBinding binding = ActivityAccountBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.TextViewAccount.setText("Налаштування");
        TextView TextViewAccount = binding.TextViewAccount;
        String TextAccount = binding.TextViewAccount.getText().toString();
        binding.TextViewUserName.setText("Налаштування");
        TextView TextViewUserName = binding.TextViewUserName;
        String TextName = binding.TextViewUserName.getText().toString();
        binding.TextViewBirthday.setText("Налаштування");
        TextView TextViewBirthday = binding.TextViewBirthday;
        String TextBirthday = binding.TextViewBirthday.getText().toString();
        binding.TextViewPhone.setText("Налаштування");
        TextView TextViewPhone = binding.TextViewPhone;
        String TextPhone = binding.TextViewPhone.getText().toString();
        binding.TextViewUserEmail.setText("Налаштування");
        TextView TextViewEmail = binding.TextViewUserEmail;
        String TextUserEmail = binding.TextViewUserEmail.getText().toString();
        binding.TextViewChangePassword.setText("Налаштування");
        TextView TextViewChangePassword = binding.TextViewChangePassword;
        String TextChangePassword = binding.TextViewChangePassword.getText().toString();
        binding.BtnChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccountActivity.this, ChangePasswordActivity.class);
                startActivity(intent);
                finish();
            }
        });
        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        if (firebaseUser == null) {
            Toast.makeText(AccountActivity.this,"Щось пішло не так! Користувач не доступний",Toast.LENGTH_LONG).show();
        } else {
            showUserProfile(firebaseUser);
        }



    }

    private void showUserProfile(FirebaseUser firebaseUser) {
        String UserID = firebaseUser.getUid();
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Зареєстрований користувач");
        databaseReference.child(UserID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ReadWriteUserDetails readWriteUserDetails = snapshot.getValue(ReadWriteUserDetails.class);
                if (readWriteUserDetails !=null) {
                     Account = firebaseUser.getDisplayName();
                     Name = firebaseUser.getDisplayName();
                     Bd = readWriteUserDetails.dob;
                     Phone = readWriteUserDetails.phone;
                     Email = firebaseUser.getEmail();
                     ChangePassword = firebaseUser.getUid();


                     TextViewAccount.setText("Привіт" + Name );
                     TextViewName.setText(Name);
                     TextViewBd.setText(Bd);
                     TextViewPhone.setText(Phone);
                     TextViewEmail.setText(Email);
                     TextViewChangePassword.setText(ChangePassword);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
