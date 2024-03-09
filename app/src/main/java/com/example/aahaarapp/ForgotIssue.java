package com.example.aahaarapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ForgotIssue extends AppCompatActivity {

    EditText number,mpin;
    Button btn;
    MyDBHeplerRegister helper = new MyDBHeplerRegister(this);
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);

        number = findViewById(R.id.mobile2);
        mpin = findViewById(R.id.mpin3);
        btn = findViewById(R.id.loginbutton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number1= number.getText().toString();
                String mpin1 = mpin.getText().toString();
                if(TextUtils.isEmpty(number1))
                {
                    number.setError("Number is Required.");
                    return;
                }

                if(TextUtils.isEmpty(mpin1))
                {
                    mpin.setError("MPIN is Required.");
                    return;
                }
                if(helper.checkNumber(number1))
                {
                   helper.updatePassword(number1,mpin1);
                   Toast.makeText(ForgotIssue.this, "Password is Updated", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),Logup.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(ForgotIssue.this, "You Have Not Registered", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
