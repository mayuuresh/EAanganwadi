package com.example.aahaarapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AdolescentGirlsNutrition extends AppCompatActivity {
    CheckBox FalicAcid1,Iron1,Vitamin1,Calcium1,allopath,homopathy,ayush;
    EditText height,weight,iron1,hemoglobin;
    RadioGroup radio,radio1;
    RadioButton r,r1;
    Button btn;
    MyDBHelperChildren3y6yRegister helper;
    String mobileno="",nurtrition="",service="";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adolescent_girls_nutrition);
        allopath = findViewById(R.id.allopath2);
        homopathy = findViewById(R.id.homopathy2);
        ayush = findViewById(R.id.ayush2);
        iron1 = findViewById(R.id.iron);
        if(allopath.isSelected())
        {
            service=service+","+(allopath.getText().toString());
        }
        if(homopathy.isSelected())
        {
            service=service+","+(homopathy.getText().toString());
        }
        if (ayush.isSelected())
        {
            service=service+","+(ayush.getText().toString());
        }
        radio = findViewById(R.id.radioheight);
        radio1=findViewById(R.id.cycle);

        btn = findViewById(R.id.submitI);

        helper = new MyDBHelperChildren3y6yRegister(this);

        btn.setOnClickListener(view -> {
            String heightn = height.getText().toString();
            String weightn = weight.getText().toString();
            String iron = iron1.getText().toString();
            String hemoglobinn = hemoglobin.getText().toString();

            // Retrieve the selected RadioButton text
            // inside the OnClickListener
            int selectedId = radio.getCheckedRadioButtonId();
            int selectedId1 = radio1.getCheckedRadioButtonId();
            if (selectedId != -1) {
                r = findViewById(selectedId);
                String radion = r.getText().toString();

                if (selectedId != -1) {
                    r = findViewById(selectedId);
                    String radion1 = r.getText().toString();

                    helper.updateColumns(mobileno, radion1, iron, hemoglobinn, service, radion, heightn, weightn);
                    Toast.makeText(AdolescentGirlsNutrition.this, "Data Saved Successfully", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(), Logup.class);
                    startActivity(intent);
                } else {
                    // Handle the case where no RadioButton is selected
                    Toast.makeText(AdolescentGirlsNutrition.this, "Please Select ALl the Fields", Toast.LENGTH_SHORT).show();
                }
            } });
    }
}