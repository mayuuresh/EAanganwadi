package com.example.aahaarapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class List1 extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item);
        TextView name=findViewById(R.id.a1);
        TextView mobile1=findViewById(R.id.m1);
        String age = getIntent().getStringExtra("age");
        String mobile=getIntent().getStringExtra("mobile");


        name.setText("50");
        mobile1.setText("7559231221");
    }
}
