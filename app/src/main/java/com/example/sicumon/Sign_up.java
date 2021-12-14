package com.example.sicumon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Sign_up extends AppCompatActivity {
    private FirebaseAuth mAuth;
    EditText first_name, last_name, id, email, password;
    Button sign_up_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        sign_up_button = (Button) findViewById(R.id.sign_up_button);
        first_name = (EditText) findViewById(R.id.sign_up_first_name);
        last_name = (EditText) findViewById(R.id.sign_up_last_name);
        id = (EditText) findViewById(R.id.sign_up_id);
        email = (EditText) findViewById(R.id.sign_up_au_email);
        password = (EditText) findViewById(R.id.sign_up_password);

        sign_up_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String first_name_string = first_name.getText().toString();
                String last_name_string = last_name.getText().toString();
                String id_string = id.getText().toString();
                String email_string = email.getText().toString();
                String password_string = password.getText().toString();

                if (TextUtils.isEmpty(first_name_string)) {
                    first_name.setError("מי אתה?");
                    return;
                }

                mAuth.createUserWithEmailAndPassword(email_string, password_string).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            startActivity(new Intent(getApplicationContext(), com.example.sicumon.Sign_in.class));
                        } else {

                            Toast.makeText(getApplicationContext(), "failed", Toast.LENGTH_LONG).show();

                        }
                    }

                });
            }




        });
    }
}