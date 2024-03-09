package com.example.aahaarapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LactatingMother_add extends AppCompatActivity {

    Button btn;
    MyDBHelperLactatingMother helper;
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lactating_add);
        btn=findViewById(R.id.button6);
        helper = new MyDBHelperLactatingMother(this);
        Cursor cursor = helper.readAllData();

        if (cursor.getCount() == 0) {
            Toast.makeText(this, "NO Data Found", Toast.LENGTH_SHORT).show();
        }
        else {
            StringBuffer buffer = new StringBuffer();
            while (cursor.moveToNext()) {
                buffer.append("Name: " + cursor.getString(0) + "\n");
                buffer.append("Age: " + cursor.getString(1) + "\n");
                buffer.append("Phone: " + cursor.getString(2) + "\n");
                buffer.append("Address: " + cursor.getString(3) + "\n");
                buffer.append("Email: " + cursor.getString(4) + "\n");
                buffer.append("Password: " + cursor.getString(5) + "\n");
            }
            Toast.makeText(this, buffer.toString(), Toast.LENGTH_SHORT).show();
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),LactatingMother_register.class));
            }
        });
    }
}
