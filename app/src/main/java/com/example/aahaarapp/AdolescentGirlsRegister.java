package com.example.aahaarapp;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.tabs.TabLayout;

public class AdolescentGirlsRegister extends AppCompatActivity
{
    EditText mobile1,name1,dob1,yob1,mother1,father1;
    Button register;
    String email,pass,repass;
    TabLayout tabLayout;
    MyDBHelperAdolescentGirls helper;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState) ;

        setContentView(R.layout.adolescent_girls_register);
        tabLayout = findViewById(R.id.tabLayout);
        mobile1 =findViewById(R.id.mobile);
        name1 = findViewById(R.id.Name);
        dob1 = findViewById(R.id.Dob);
        yob1 = findViewById((R.id.Yob));
        register=findViewById((R.id.Register));


        helper= new MyDBHelperAdolescentGirls(this);


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
            register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String mobile = mobile1.getText().toString();
                    String name = name1.getText().toString();
                    String dob = dob1.getText().toString();
                    String yob = yob1.getText().toString();
                    String father=father1.getText().toString();
                    String mother=mother1.getText().toString();

                    helper.registeruser(name, dob, yob, mobile, father,mother);
                    sendSms(mobile,"Your data has been successfully registered for Adolescent Girls Program.We will keep you updated with the latest information. Thank you for registering with us.");

                    Toast.makeText(AdolescentGirlsRegister.this, "Data Saved Successfully", Toast.LENGTH_SHORT).show();


                    Intent intent = new Intent(getApplicationContext(), AdolescentGirlsAdd.class);
                    startActivity(intent);


                }
            });

    }
    public void sendSms(String number,String message) {
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(number, null, message, null, null);

    }
}
