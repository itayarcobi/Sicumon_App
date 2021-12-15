package com.example.sicumon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class Sign_in extends AppCompatActivity {
    private FirebaseAuth mAuth;
    EditText email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        email=(EditText) findViewById(R.id.sign_in_email);
        password=(EditText) findViewById(R.id.sign_in_password);
        FirebaseAuth mAuth = FirebaseAuth.getInstance();


    }
}