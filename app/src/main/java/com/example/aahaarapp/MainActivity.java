package com.example.aahaarapp;

import android.content.Intent;
import android.os.Bundle;
import android.service.carrier.CarrierService;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CardView pregnent=findViewById(R.id.Pregnant);
        CardView lactating=findViewById(R.id.Lactating);
        CardView child0m_6m=findViewById(R.id.Children_0_6);
        CardView child6m_3y=findViewById(R.id.Children_6_3);
        CardView child3y_6y=findViewById(R.id.Children_3_6);
        CardView adolsentgirls=findViewById(R.id.Adolescent_Girls);
        CardView adolsentboys=findViewById(R.id.Adolescent_Boys);


        pregnent.setOnClickListener(new View.OnClickListener ()
        {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Preganent_add.class));
            }
        });

        lactating.setOnClickListener(new View.OnClickListener ()
        {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LactatingMother_add.class));
            }
        });

        child3y_6y.setOnClickListener(new View.OnClickListener ()
        {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Children0M6MAdd.class));
            }
        });

        child6m_3y.setOnClickListener(new View.OnClickListener ()
        {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Children6M3YAdd.class));
            }
        });
        child3y_6y.setOnClickListener(new View.OnClickListener ()
        {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Children3Y6YAdd.class));
            }
        });

        child3y_6y.setOnClickListener(new View.OnClickListener ()
        {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Children3Y6YRegister.class));
            }
        });

        child3y_6y.setOnClickListener(new View.OnClickListener ()
        {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Children3Y6YRegister.class));
            }
        });
    }
}