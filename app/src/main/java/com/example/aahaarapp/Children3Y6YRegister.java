package com.example.aahaarapp;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.tabs.TabLayout;

public class Children3Y6YRegister extends AppCompatActivity {

    EditText name, motherName, mobileNo, weight,height;
    RadioGroup heightUnit;
    RadioButton r;
    Button btn;
    MyDBHelperChildren3y6yRegister helper;
    TabLayout tabLayout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.children_3y_6y_register);
        tabLayout = findViewById(R.id.tabLayout1);
        name = findViewById(R.id.edit1);
        motherName = findViewById(R.id.edit2);
        mobileNo = findViewById(R.id.edit3);
        weight = findViewById(R.id.edit4);
        height = findViewById(R.id.edit5);
        btn = findViewById(R.id.submit);
        helper = new MyDBHelperChildren3y6yRegister(this);
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
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namestr = name.getText().toString();
                String mothern = motherName.getText().toString();
                String mobilen = mobileNo.getText().toString();
                String weightn = weight.getText().toString();
                String heightn = height.getText().toString();

                int selectedId = heightUnit.getCheckedRadioButtonId();
                if (selectedId != -1) {
                    r = findViewById(selectedId);
                    String heightUnitn = r.getText().toString();
                    Toast.makeText(Children3Y6YRegister.this, namestr+mothern+mothern+weightn+heightUnitn+heightn, Toast.LENGTH_SHORT).show();
                    helper.childrenRegister( mobilen,namestr, mothern, weightn,heightUnitn, heightn);
                    sendSms(mobilen,"Your data has been successfully registered for Children 3 year to 6 year Program.We will keep you updated with the latest information. Thank you for registering with us.");
                    Toast.makeText(Children3Y6YRegister.this, "Data Saved Successfully", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(), Children3Y6YAdd.class);
                    startActivity(intent);
                } else {
                    // Handle the case where no RadioButton is selected
                    Toast.makeText(Children3Y6YRegister.this, "Please select gender", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    public void sendSms(String number,String message) {
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(number, null, message, null, null);

    }
}
