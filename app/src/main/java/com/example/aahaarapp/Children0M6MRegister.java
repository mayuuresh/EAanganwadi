package com.example.aahaarapp;

import android.content.Intent;
import android.os.Bundle;

import android.telephony.SmsManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.tabs.TabLayout;

public class Children0M6MRegister extends AppCompatActivity {
    EditText name, mother, mobile, weight, height;
    RadioGroup height_ut;
    RadioButton r;
    Button btn;
    MyDBHelper0m6m helper;
    TabLayout tabLayout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.children_0m_6m_register);
        tabLayout = findViewById(R.id.tabLayout);
        name = findViewById(R.id.edit1);
        mother = findViewById(R.id.edit2);
        mobile = findViewById(R.id.edit3);
        weight = findViewById(R.id.edit4);
        height = findViewById(R.id.edit5);
        height_ut = findViewById(R.id.rg1);
        btn = findViewById(R.id.submit);
        helper = new MyDBHelper0m6m(this);

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
        btn.setOnClickListener(view -> {
            String namestr = name.getText().toString();
            String motherstr = mother.getText().toString();
            String mobilestr = mobile.getText().toString();
            String weigthstr = weight.getText().toString();
            String heightstr = height.getText().toString();

            // Retrieve the selected RadioButton text inside the OnClickListener
            int selectedId = height_ut.getCheckedRadioButtonId();
            if (selectedId != -1) {
                r = findViewById(selectedId);
                String heightn = r.getText().toString();

                helper.children0M6MRegister(namestr, motherstr, mobilestr, weigthstr, heightn, heightstr);
                sendSms(mobilestr,"Your data has been successfully registered for Children 0 month to 6 month " +
                        "Program.We will keep you updated with the latest information. Thank you for registering with us.");

                Toast.makeText(Children0M6MRegister.this, "Data Saved Successfully", Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(getApplicationContext(),Children0M6MAdd.class);
                startActivity(intent);
            } else {
                // Handle the case where no RadioButton is selected
                Toast.makeText(Children0M6MRegister.this, "Please select gender", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void sendSms(String number,String message) {
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(number, null, message, null, null);

    }
}
