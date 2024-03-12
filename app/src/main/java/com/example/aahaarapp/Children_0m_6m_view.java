package com.example.aahaarapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.tabs.TabLayout;

public class Children_0m_6m_view extends AppCompatActivity {
    TabLayout tabLayout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.children_0m_6m_view);
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
