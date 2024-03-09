package com.example.aahaarapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class LactatingMother_register extends AppCompatActivity {
    EditText name,birthDate,birthYear,mobileNo,deliveryDate,heightUnit,height,weight,hemoglobin,provided,healthService;
    RadioGroup gender;
    RadioButton r;
    Button btn;
    MyDBHelperLactatingMother helper = new MyDBHelperLactatingMother(this);
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lactating_register);

        name = findViewById(R.id.edit1);
        birthDate = findViewById(R.id.edit2);
        birthYear = findViewById(R.id.edit3);
        mobileNo = findViewById(R.id.edit4);
        deliveryDate = findViewById(R.id.edit5);
        gender = findViewById(R.id.radioGroup);
        r=findViewById(gender.getCheckedRadioButtonId());
        btn=findViewById(R.id.submit);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String namestr = name.getText().toString();
                String birthDaten = birthDate.getText().toString();
                String birthYearn = birthYear.getText().toString();
                String mobileNon = mobileNo.getText().toString();
                String deliveryDaten = deliveryDate.getText().toString();
                String gendern = r.getText().toString();

                helper.lactatingRegister(namestr,birthDaten,birthYearn,mobileNon,deliveryDaten,gendern);
            }
        });

    }
}
