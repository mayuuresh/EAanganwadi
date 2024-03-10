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
    public static final String ACCOUNT_SID = "AC4c83b856d6e2158365a43f0d0e0f85dc";
    public static final String AUTH_TOKEN = "8133253477f3a026dd9b03729eb7b631";

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

                // after adding the data we are displaying a toast message.
                Toast.makeText(Issue.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                sendSms();
                Toast.makeText(Issue.this,"Success",Toast.LENGTH_SHORT).show();


                }
        });

    }
    public void sendSms() {
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage("+919423929864", null, "Thank you for your feedback. We will get back to you soon.", null, null);
    }

}
