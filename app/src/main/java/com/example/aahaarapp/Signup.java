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


    EditText mobile1,pass1,repass1;
    Button register;
    String email,pass,repass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mobile1=findViewById(R.id.mobile);
        pass1=findViewById(R.id.mpin);
        repass1=findViewById(R.id.reMpin);
        register=findViewById((R.id.register));
        MyDBHeplerRegister helper = new MyDBHeplerRegister(this);
        
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=mobile1.getText().toString();
                String pass=pass1.getText().toString();
                String repass=repass1.getText().toString();
                
                if(pass.equals(repass)){
                    helper.registeruser(email,pass);
                    Toast.makeText(Signup.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Signup.this, "Enter the same MPIN", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}