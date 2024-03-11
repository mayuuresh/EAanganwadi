package com.example.aahaarapp;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class Issue extends AppCompatActivity {
    EditText name,mobile,email,subject,issue;
    String str_name,str_email,str_subject,str_issue,str_mobile;
    Button sbt;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.issue_form);

        name=findViewById(R.id.nameI);
        mobile=findViewById(R.id.numberI);
        email=findViewById(R.id.emailI);
        subject=findViewById(R.id.subjectI);
        issue=findViewById(R.id.issueI);
        sbt=findViewById(R.id.submitI);
        MyDBHelper helper = new MyDBHelper(this);
        sbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Signup.class));
                str_name=name.getText().toString();
                str_mobile=mobile.getText().toString();
                str_email=email.getText().toString();
                str_subject=subject.getText().toString();
                str_issue=issue.getText().toString();

                helper.addNewCourse(str_name,str_mobile,str_email,str_subject,str_issue);
                String msg= "Name: "+str_name+"  Mobile: "+str_mobile+"  Subject: "+str_subject+"  Issue: "+str_issue;

                // after adding the data we are displaying a toast message.
                Toast.makeText(Issue.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                sendSms(msg);
                Toast.makeText(Issue.this,"Success",Toast.LENGTH_SHORT).show();

                }
        });
    }
    public void sendSms(String issue) {
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage("+919689919738", null, issue, null, null);
    }

}
