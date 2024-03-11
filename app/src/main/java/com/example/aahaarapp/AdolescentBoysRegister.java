package com.example.aahaarapp;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AdolescentBoysRegister extends AppCompatActivity {
    EditText mobile1,name1,dob1,yob1,mother1,father1;
    Button register;
    String email,pass,repass;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState) ;

        setContentView(R.layout.adolescent_boys_register);
        mobile1 =findViewById(R.id.Mobile);
        name1 = findViewById(R.id.Name);
        dob1 = findViewById(R.id.Dob);
        yob1 = findViewById((R.id.Yob));
        register=findViewById((R.id.Register));
        father1 = findViewById((R.id.Father));
        mother1 = findViewById((R.id.Mother));

        MyDBHelperAdolescentGirls helper = new MyDBHelperAdolescentGirls(this);



            register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String mobile = mobile1.getText().toString();
                    String name = name1.getText().toString();
                    String dob = dob1.getText().toString();
                    String yob = yob1.getText().toString();
                    String father=father1.getText().toString();
                    String mother=mother1.getText().toString();


                    // Now, you have the text of the checked RadioButtons
                    // Proceed with further processing

                    helper.registeruser(name, dob, yob, mobile, father,mother);
                    sendSms(mobile,"Your data has been successfully registered for Adolescent Boys Program.We will keep you updated with the latest information. Thank you for registering with us.");

                    Toast.makeText(AdolescentBoysRegister.this, "Data Saved Successfully", Toast.LENGTH_SHORT).show();


                    Intent intent = new Intent(getApplicationContext(), Logup.class);
                    startActivity(intent);


                }
            });
    }
    public void sendSms(String number,String message) {
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(number, null, message, null, null);

    }


}