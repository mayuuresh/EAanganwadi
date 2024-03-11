package com.example.aahaarapp;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.telephony.SmsManager;

import androidx.appcompat.app.AppCompatActivity;


public class Preganent_Register extends AppCompatActivity
{
    EditText name1,mobile1,dob1,yob1;
    RadioButton radio1;
    RadioButton radio2;
    RadioGroup radioGroup,radioGroup1;
    Button register;
    protected void onCreate(Bundle savedInstanceState)
    {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.pregnant_register);
        mobile1 =findViewById(R.id.Yob);
        name1 = findViewById(R.id.Edit1);
        dob1 = findViewById(R.id.Edit2);
        yob1 = findViewById((R.id.Edit3));
        radioGroup=findViewById(R.id.rg1);
        radioGroup1=findViewById(R.id.rg2);
        radio1=findViewById(radioGroup.getCheckedRadioButtonId());
        radio2=findViewById(radioGroup1.getCheckedRadioButtonId());
      
        register = findViewById(R.id.Submit);

        MyDBHelperPregnantWomen helper = new   MyDBHelperPregnantWomen(this);

        register.setOnClickListener(new View.OnClickListener()
        {
                        @Override
                        public void onClick(View view) {
                            String mobile = mobile1.getText().toString();
                            String name = name1.getText().toString();
                            String dob = dob1.getText().toString();
                            String yob = yob1.getText().toString();

                            // Getting the checked RadioButtons
                            radio1=findViewById(radioGroup.getCheckedRadioButtonId());
                            radio2=findViewById(radioGroup1.getCheckedRadioButtonId());

                            // Extracting text from the checked RadioButtons
                            String r1 = radio1 != null ? radio1.getText().toString() : "";
                            String r2 = radio2 != null ? radio2.getText().toString() : "";

                            // Now, you have the text of the checked RadioButtons
                            // Proceed with further processing
                            helper.registeruser(name, dob, yob, mobile, r1, r2);
                            sendSms(mobile, "You have successfully registered for the pregnancy program. We will keep you updated with the latest information. Thank you for registering with us.");
                            Toast.makeText(Preganent_Register.this, "Data Saved Successfully", Toast.LENGTH_SHORT).show();


                            //Intent intent = new Intent(getApplicationContext(), Logup.class);
                            //startActivity(intent);
                        }
            });
    }
    public void sendSms(String number,String message) {
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(number, null, message, null, null);

    }
}


