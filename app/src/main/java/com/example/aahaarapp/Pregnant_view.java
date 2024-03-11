package com.example.aahaarapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Pregnant_view extends AppCompatActivity{
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preganent_view);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        String currentDateAndTime = sdf.format(new Date());

        // Find the TextView in your XML layout
        TextView textViewDateTime = findViewById(R.id.textViewDateTime);

        // Set the current date and time to the TextView
        textViewDateTime.setText(currentDateAndTime);

    }
}
