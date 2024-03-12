package com.example.aahaarapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Preganent_Nutrition extends AppCompatActivity {
    CheckBox FalicAcid1,Iron1,Vitamin1,Calcium1;
    EditText height,weight,fat,hemoglobin,Energy,Protein;
    RadioGroup radio;
    RadioButton r;
    Button btn;
    MyDBHelperPregnantWomen helper;
    String nurtrition="",service="";
    Button submit;
    String value;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preganent_nutrition);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        String currentDateAndTime = sdf.format(new Date());

        // Find the TextView in your XML layout
        TextView textViewDateTime = findViewById(R.id.textViewDateTime);

        // Set the current date and time to the TextView
        textViewDateTime.setText(currentDateAndTime);

        value = getIntent().getStringExtra("number");
        FalicAcid1 = findViewById(R.id.FalicAcid);
        Iron1 = findViewById(R.id.Iron);
        Vitamin1 = findViewById(R.id.Vitamin);
        Calcium1 = findViewById(R.id.Calcium);

        Energy = findViewById(R.id.energy);
        Protein= findViewById(R.id.protein);


        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        hemoglobin = findViewById(R.id.hemoglobin);


        if(FalicAcid1.isSelected())
        {
            nurtrition=nurtrition+","+(FalicAcid1.getText().toString());
        }
        if(Iron1.isSelected())
        {
            nurtrition=nurtrition+","+(Iron1.getText().toString());
        }
        if(Vitamin1.isSelected())
        {
            nurtrition=nurtrition+","+(Vitamin1.getText().toString());
        }
        if(Calcium1.isSelected())
        {
            nurtrition=nurtrition+","+(Calcium1.getText().toString());
        }


        radio = findViewById(R.id.radioheight);

        btn = findViewById(R.id.submitI);

        helper = new MyDBHelperPregnantWomen(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String heightn = height.getText().toString();
                String weightn = weight.getText().toString();

                String hemoglobinn = hemoglobin.getText().toString();
                String energy = Energy.getText().toString();
                String protein = Protein.getText().toString();

                // Retrieve the selected RadioButton text
                // inside the OnClickListener
                int selectedId = radio.getCheckedRadioButtonId();
                if (selectedId != -1) {
                    r = findViewById(selectedId);
                    String radion = r.getText().toString();

                    helper.updateColumns(value,radion,heightn,weightn,hemoglobinn,nurtrition,energy,protein);
                    Toast.makeText(Preganent_Nutrition.this, value, Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(), Pregnant_add.class);
                    startActivity(intent);
                } else {
                    // Handle the case where no RadioButton is selected
                    Toast.makeText(Preganent_Nutrition.this, "Please Select ALl the Fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
