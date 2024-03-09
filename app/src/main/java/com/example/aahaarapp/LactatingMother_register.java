package com.example.aahaarapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LactatingMother_register extends AppCompatActivity {
    EditText name, birthDate, birthYear, mobileNo, deliveryDate;
    RadioGroup gender;
    RadioButton r;
    Button btn;
    MyDBHelperLactatingMother helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lactating_register);

        name = findViewById(R.id.edit1);
        birthDate = findViewById(R.id.edit2);
        birthYear = findViewById(R.id.edit3);
        mobileNo = findViewById(R.id.edit4);
        deliveryDate = findViewById(R.id.edit5);
        gender = findViewById(R.id.radioGroup);
        btn = findViewById(R.id.submit);
        helper = new MyDBHelperLactatingMother(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namestr = name.getText().toString();
                String birthDaten = birthDate.getText().toString();
                String birthYearn = birthYear.getText().toString();
                String mobileNon = mobileNo.getText().toString();
                String deliveryDaten = deliveryDate.getText().toString();

                // Retrieve the selected RadioButton text
                // inside the OnClickListener
                int selectedId = gender.getCheckedRadioButtonId();
                if (selectedId != -1) {
                    r = findViewById(selectedId);
                    String gendern = r.getText().toString();

                    helper.lactatingRegister(namestr, birthDaten, birthYearn, mobileNon, deliveryDaten, gendern);
                    Toast.makeText(LactatingMother_register.this, "Data Saved Successfully", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(), Logup.class);
                    startActivity(intent);
                } else {
                    // Handle the case where no RadioButton is selected
                    Toast.makeText(LactatingMother_register.this, "Please select gender", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}




