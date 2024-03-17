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

public class Children0M6MNutrition extends AppCompatActivity {
    CheckBox FalicAcid1,Iron1,Vitamin1,Calcium1,allopath,homopathy,ayush;
    EditText height,weight,fat,hemoglobin;
    RadioGroup radio;
    RadioButton r;
    Button btn;
    MyDBHelper0m6m helper;;
    StringBuilder nurtrition = new StringBuilder();
    StringBuilder service = new StringBuilder();
    String item;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.children_0m_6m_nutrition);
        String value = getIntent().getStringExtra("number");
        Toast.makeText(this, value, Toast.LENGTH_SHORT).show();
        FalicAcid1 = findViewById(R.id.FalicAcid1);
        Iron1 = findViewById(R.id.Iron1);
        Vitamin1 = findViewById(R.id.Vitamin1);
        Calcium1 = findViewById(R.id.Calcium1);

        allopath = findViewById(R.id.FalicAcid);
        homopathy = findViewById(R.id.Iron);
        ayush = findViewById(R.id.Vitamin);

        height = findViewById(R.id.height2);
        weight = findViewById(R.id.weight);
        fat = findViewById(R.id.hemo);
        hemoglobin = findViewById(R.id.hemo);


        if(FalicAcid1.isSelected())
        {
            nurtrition=nurtrition.append(FalicAcid1.getText().toString());
        }
        if(Iron1.isSelected())
        {
            nurtrition=nurtrition.append(Iron1.getText().toString());
        }
        if(Vitamin1.isSelected())
        {
            nurtrition=nurtrition.append(Vitamin1.getText().toString());
        }
        if(Calcium1.isSelected())
        {
            nurtrition=nurtrition.append(Calcium1.getText().toString());
        }

        if(allopath.isSelected())
        {
            service=service.append(allopath.getText().toString());
        }
        if(homopathy.isSelected())
        {
            service=service.append(homopathy.getText().toString());
        }
        if (ayush.isSelected())
        {
            service=service.append(ayush.getText().toString());
        }

        radio = findViewById(R.id.radioheight);

        btn = findViewById(R.id.submitI);

        helper = new MyDBHelper0m6m(this);


        String[] vaccin = getResources().getStringArray(R.array.Vaccination);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.dropdown_menu, vaccin);
        AutoCompleteTextView autocompleteTV = findViewById(R.id.autoComplete);
        autocompleteTV.setAdapter(arrayAdapter);

        autocompleteTV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                item = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(Children0M6MNutrition.this, "item: "+item, Toast.LENGTH_SHORT).show();
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String heightn = height.getText().toString();
                String weightn = weight.getText().toString();
                String fatn = fat.getText().toString();
                String hemoglobinn = hemoglobin.getText().toString();

                // Retrieve the selected RadioButton text
                // inside the OnClickListener
                int selectedId = radio.getCheckedRadioButtonId();
                if (selectedId != -1) {
                    r = findViewById(selectedId);
                    String radion = r.getText().toString();

                    helper.updateColumns(value,nurtrition.toString(),heightn,weightn,fatn,radion,hemoglobinn,service.toString(),item);
                    Toast.makeText(Children0M6MNutrition.this, "Data Saved Successfully", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(), Children0M6MAdd.class);
                    startActivity(intent);
                } else {
                    // Handle the case where no RadioButton is selected
                    Toast.makeText(Children0M6MNutrition.this, "Please Select ALl the Fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
