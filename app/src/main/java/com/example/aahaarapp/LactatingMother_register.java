    package com.example.aahaarapp;

    import android.content.Intent;
    import android.os.Bundle;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.RadioButton;
    import android.widget.RadioGroup;
    import android.widget.Toast;

    import androidx.appcompat.app.AppCompatActivity;

    import java.util.LinkedList;
    import java.util.List;

    public class LactatingMother_register extends AppCompatActivity {
        EditText name, birthDate, birthYear, mobileNo, deliveryDate;
        RadioGroup gender;
        RadioButton r;
        Button btn;
        MyDBHelperLactatingMother helper;
        DemoAdapter adapter;
        List<String> items;

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
            items = new LinkedList<>();
            adapter = new DemoAdapter(items);
//            recyclerView.setAdapter(adapter);

            btn.setOnClickListener(view -> {
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

                    Intent intent = new Intent(getApplicationContext(), LactatingMother_add.class);
                    startActivity(intent);
                } else {
                    // Handle the case where no RadioButton is selected
                    Toast.makeText(LactatingMother_register.this, "Please select gender", Toast.LENGTH_SHORT).show();
                }

                adapter.addNewLayout();
            });
        }
    }
