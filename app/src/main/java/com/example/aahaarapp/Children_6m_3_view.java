package com.example.aahaarapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.tabs.TabLayout;

public class Children_6m_3_view extends AppCompatActivity {
    TabLayout tabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.children_6m_3y_view);
        tabLayout = findViewById(R.id.tabLayout);
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
