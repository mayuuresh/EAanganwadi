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

public class Children3Y6YRegister extends AppCompatActivity {

    EditText name, motherName, mobileNo, weight,height;
    RadioGroup heightUnit;
    RadioButton r;
    Button btn;
    MyDBHelperChildren3y6yRegister helper;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.children_3y_6y_register);

        name = findViewById(R.id.edit1);
        motherName = findViewById(R.id.edit2);
        mobileNo = findViewById(R.id.edit3);
        weight = findViewById(R.id.edit4);
        height = findViewById(R.id.edit5);

        btn = findViewById(R.id.submit);
        helper = new MyDBHelperChildren3y6yRegister(this);

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

                    helper.childrenRegister(namestr, mothern, mobilen, weightn,heightUnitn, heightn);
                    sendSms(mobilen,"Your data has been successfully registered for Children 3 year to 6 year Program.We will keep you updated with the latest information. Thank you for registering with us.");
                    Toast.makeText(Children3Y6YRegister.this, "Data Saved Successfully", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(), Logup.class);
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
