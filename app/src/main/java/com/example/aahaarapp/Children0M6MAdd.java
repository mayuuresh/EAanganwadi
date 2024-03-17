package com.example.aahaarapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class Children0M6MAdd extends AppCompatActivity {
    Button btn;
    TabLayout tabLayout;
    ArrayList<String> listItem;
    ArrayAdapter adapter;
    MyDBHelper0m6m helper;
    public String data;
    ListView userlist;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.children_0m_6m_add);
        tabLayout = findViewById(R.id.tabLayout2);
        btn = findViewById(R.id.button6);
        userlist = findViewById(R.id.list);
        listItem = new ArrayList<>();
        helper=new MyDBHelper0m6m(this);
        viewData();
        btn.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(),Children0M6MRegister.class)));
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
                        Intent intent1 = new Intent(getApplicationContext(), Awc.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        // Handle click on Tab 3
                        Intent intent2 = new Intent(getApplicationContext(), Profile.class);
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

        userlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String text=userlist.getItemAtPosition(i).toString();
                data = text.substring(text.indexOf("Mobile:-")+8,text.indexOf("Date of Birth")).trim();
                Toast.makeText(Children0M6MAdd.this,""+text,Toast.LENGTH_SHORT).show();
                Bundle  bundle = new Bundle();
                bundle.putString("number",data);
                Toast.makeText(Children0M6MAdd.this, data, Toast.LENGTH_SHORT).show();
                Fragment0m6m v = new Fragment0m6m();
                v.setArguments(bundle);
                v.show(getSupportFragmentManager(),"Fragment_view");

            }
        });

    }
    private void viewData() {
        Cursor cursor = helper.viewData();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No data to show", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                listItem.add("Name:-" + cursor.getString(1) + "\nMobile:- " + cursor.getString(0) + "           Date of Birth:-" + cursor.getString(2));
            }
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItem);
            userlist.setAdapter(adapter);
        }
    }
}
