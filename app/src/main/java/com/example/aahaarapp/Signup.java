package com.example.aahaarapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class Signup extends AppCompatActivity {


    EditText email1,pass1,repass1;
    Button register,login;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mAuth =FirebaseAuth.getInstance();
        email1=findViewById(R.id.mobile);
        pass1=findViewById(R.id.mpin);
        repass1=findViewById(R.id.reMpin);
        String email=email1.getText().toString();
        String pass=pass1.getText().toString();
        String repass=repass1.getText().toString();



    }
}