package com.example.aahaarapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.tabs.TabLayout;

public class Lactating_View extends AppCompatActivity {
    TabLayout tabLayout;
    MyDBHelperLactatingMother helper;
    String number;
    EditText name, dob, yob, mobile, heightut, height, weight, hemoglobin, nutrition, energy;

    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lactating_view);
        tabLayout = findViewById(R.id.tabLayout);
        helper = new MyDBHelperLactatingMother(this);
        number=getIntent().getStringExtra("number");
        name=findViewById(R.id.name);
        dob=findViewById(R.id.date);
        mobile=findViewById(R.id.mobile);
        yob=findViewById(R.id.yob);
        heightut=findViewById(R.id.height3);
        height=findViewById(R.id.height);
        weight=findViewById(R.id.weight);
        hemoglobin=findViewById(R.id.hemo);
        nutrition=findViewById(R.id.provided);
        energy=findViewById(R.id.avail);


        Cursor data = helper.readAllData(number);
        data.moveToFirst();
        mobile.setText(data.getString(0));
        name.setText(data.getString(1));
        dob.setText(data.getString(2));
        yob.setText(data.getString(4));
        heightut.setText(data.getString(6));
        height.setText(data.getString(7));
        weight.setText(data.getString(8));
        hemoglobin.setText(data.getString(9));
        nutrition.setText(data.getString(10));
        energy.setText(data.getString(11));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // Handle tab selection (which effectively is a click)
                int position = tab.getPosition();
                switch (position) {
                    case 0:
                        // Handle click on Tab 1
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        // Handle click on Tab 2
                        Intent intent1 = new Intent(getApplicationContext(), Profile.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        // Handle click on Tab 3
                        Intent intent2 = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent2);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // Handle tab unselection (optional)
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // Handle tab reselection (optional)
            }
        });

    }
}
