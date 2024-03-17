package com.example.aahaarapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.appcompat.app.AppCompatActivity;

public class LactatingMother_Nutrition extends AppCompatActivity {
    CheckBox THR,HCM,alopathy,homeopathy,ayush;
    EditText height,weight,hemoglobin;
    RadioGroup radio;
    RadioButton r;
    Button btn;
    MyDBHelperLactatingMother helper;
    String nurtrition="",service="";
    String item;

    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lactating_nutrition);

        String value = getIntent().getStringExtra("number");
        THR = findViewById(R.id.THR);
        HCM = findViewById(R.id.HCM);
        alopathy = findViewById(R.id.allopath);
        homeopathy = findViewById(R.id.homeopathy);
        ayush = findViewById(R.id.ayush);

        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        hemoglobin = findViewById(R.id.hemoglobin);


        if(THR.isSelected())
        {
            nurtrition=nurtrition+","+(THR.getText().toString());
        }
        if(HCM.isSelected()) {
            nurtrition = nurtrition + "," + (HCM.getText().toString());
        }

        if(alopathy.isSelected())
        {
            service=service+","+(alopathy.getText().toString());
        }
        if(homeopathy.isSelected())
        {
            service=service+","+(homeopathy.getText().toString());
        }
        if(ayush.isSelected())
        {
            service=service+","+(ayush.getText().toString());
        }


        radio = findViewById(R.id.radioheight);

        btn = findViewById(R.id.submitI);

        helper = new MyDBHelperLactatingMother(this);

        String[] vaccin = getResources().getStringArray(R.array.Vaccination);
        // create an array adapter and pass the required parameter
        // in our case pass the context, drop down layout , and array.
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.dropdown_menu, vaccin);
        // get reference to the autocomplete text view
        AutoCompleteTextView autocompleteTV = findViewById(R.id.autoCompleteTextView);
        // set adapter to the autocomplete tv to the arrayAdapter
        autocompleteTV.setAdapter(arrayAdapter);

        autocompleteTV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                item = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(LactatingMother_Nutrition.this, "item: "+item, Toast.LENGTH_SHORT).show();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String heightn = height.getText().toString();
                String weightn = weight.getText().toString();
                String hemoglobinn = hemoglobin.getText().toString();


                // Retrieve the selected RadioButton text

                // inside the OnClickListener
                int selectedId = radio.getCheckedRadioButtonId();
                if (selectedId != -1) {
                    r = findViewById(selectedId);
                    String radion = r.getText().toString();

                    helper.updateColumns(value,radion,heightn,weightn,hemoglobinn,nurtrition,service,item);
                    Toast.makeText(LactatingMother_Nutrition.this, "Data Saved Successfully", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(), Logup.class);
                    startActivity(intent);
                } else {
                    // Handle the case where no RadioButton is selected
                    Toast.makeText(LactatingMother_Nutrition.this, "Please Select ALl the Fields", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
