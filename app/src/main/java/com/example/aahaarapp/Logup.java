package com.example.aahaarapp;


import android.content.Intent;
import android.text.TextUtils;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Logup extends AppCompatActivity {

    EditText mnumber,mmpin;
    Button mLoginBtn;
    TextView mRegisterBtn,forgotMpin,issue;


    MyDBHeplerRegister helper = new MyDBHeplerRegister(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logup);

        mnumber=findViewById(R.id.number1);
        mmpin=findViewById(R.id.mpin);
        mRegisterBtn = findViewById(R.id.register);
        mLoginBtn = findViewById(R.id.login);
        forgotMpin=findViewById(R.id.ForgotMPIN);
        issue=findViewById(R.id.issue);



        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mnumber.getText().toString().trim();
                String password= mmpin.getText().toString().trim();
                Boolean status = helper.checkmpin(email,password);
                if(TextUtils.isEmpty(email))
                {
                    mnumber.setError("Email is Required.");
                    return;
                }

                if(TextUtils.isEmpty(password))
                {
                    mmpin.setError("Password is Required.");
                    return;
                }
                if(status==Boolean.TRUE)
                {
                    Toast.makeText(Logup.this, "Login SuccessFully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
                else if(status==Boolean.FALSE)
                {
                    Toast.makeText(Logup.this, "You Have Not Registered", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to RegisterActivity
                Intent intent = new Intent(getApplicationContext(), Signup.class);
                startActivity(intent);
            }
        });

        forgotMpin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to RegisterActivity
                Intent intent = new Intent(getApplicationContext(), ForgotIssue.class);
                startActivity(intent);
            }
        });
        issue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to RegisterActivity
                Intent intent = new Intent(getApplicationContext(), Issue.class);
                startActivity(intent);
            }
        });
    }

}

