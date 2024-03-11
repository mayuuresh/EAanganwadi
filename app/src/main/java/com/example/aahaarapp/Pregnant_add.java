package com.example.aahaarapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Pregnant_add extends AppCompatActivity {
    Button Add,update,view;
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    setContentView(R.layout.pregnant_add);
    Add = findViewById(R.id.button6);
   update = findViewById(R.id.button3);
   view = findViewById(R.id.button4);

    Add.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(getApplicationContext(),Preganent_Register.class));
        }
    });

    update.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(getApplicationContext(),Preganent_Nutrition.class));
        }
    });

    view.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(getApplicationContext(),Pregnant_view.class));
        }
    });
    }

    }

