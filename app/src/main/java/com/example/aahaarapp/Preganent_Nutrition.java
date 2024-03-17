package com.example.aahaarapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;
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
    StringBuilder nurtrition = new StringBuilder();
    Button submit;
    String value,item;
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


        height = findViewById(R.id.height2);
        weight = findViewById(R.id.weight);
        hemoglobin = findViewById(R.id.hemo);


        //get the selected checkbox in single string
        if(FalicAcid1.isChecked())
        {
            nurtrition=nurtrition.append(FalicAcid1.getText().toString());
        }
        if(Iron1.isChecked())
        {
            nurtrition=nurtrition.append(Iron1.getText().toString());
        }
        if(Vitamin1.isChecked())
        {
            nurtrition=nurtrition.append(Vitamin1.getText().toString());
        }
        if(Calcium1.isChecked())
        {
            nurtrition=nurtrition.append(Calcium1.getText().toString());
        }


        radio = findViewById(R.id.radioheight);

        btn = findViewById(R.id.submitI);

        helper = new MyDBHelperPregnantWomen(this);

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
                Toast.makeText(Preganent_Nutrition.this, "item: "+item, Toast.LENGTH_SHORT).show();
            }
        });
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

                    helper.updateColumns(value,radion,heightn,weightn,hemoglobinn,nurtrition.toString(),energy,protein,item);
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
