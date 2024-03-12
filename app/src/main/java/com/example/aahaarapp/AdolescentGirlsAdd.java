package com.example.aahaarapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class AdolescentGirlsAdd extends AppCompatActivity {
    Button btn;
    TabLayout tabLayout;
    TabItem home,awc,profile;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState) ;
        setContentView(R.layout.adolescent_girls_add);

        btn = findViewById(R.id.button6);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),AdolescentGirlsRegister.class));
            }
        });


    }
}
