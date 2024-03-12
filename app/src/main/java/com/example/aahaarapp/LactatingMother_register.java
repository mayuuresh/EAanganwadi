    package com.example.aahaarapp;

    import android.content.Intent;
    import android.os.Bundle;
    import android.telephony.SmsManager;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.RadioButton;
    import android.widget.RadioGroup;
    import android.widget.Toast;

    import androidx.appcompat.app.AppCompatActivity;

    import com.google.android.material.tabs.TabLayout;

    import java.util.LinkedList;
    import java.util.List;

    public class LactatingMother_register extends AppCompatActivity {
        EditText name, birthDate, birthYear, mobileNo, deliveryDate;
        RadioGroup gender;
        RadioButton r;
        Button btn;
        MyDBHelperLactatingMother helper;
        TabLayout tabLayout;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.lactating_register);
            ButtonClickListener listener;
            tabLayout = findViewById(R.id.tabLayout);
            name = findViewById(R.id.edit1);
            birthDate = findViewById(R.id.edit2);
            birthYear = findViewById(R.id.edit3);
            mobileNo = findViewById(R.id.edit4);
            deliveryDate = findViewById(R.id.edit5);
            gender = findViewById(R.id.radioGroup);
            btn = findViewById(R.id.submit);


            helper = new MyDBHelperLactatingMother(this);
            List<String> items = new LinkedList<>();
           // DemoAdapter da=new DemoAdapter(items);

            tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    // Handle tab selection (which effectively is a click)
                    int position = tab.getPosition();
                    switch (position) {
                        case 0:
                            // Handle click on Tab 1
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                            break;
                        case 1:
                            // Handle click on Tab 2
                            Intent intent1 = new Intent(getApplicationContext(), Profile.class);
                            startActivity(intent1);
                            break;
                        case 2:
                            // Handle click on Tab 3
                            Intent intent2 = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent2);
                            break;
                    }
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {
                    // Handle tab unselection (optional)
                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {
                    // Handle tab reselection (optional)
                }
            });
            btn.setOnClickListener(view -> {
                String namestr = name.getText().toString();
                String birthDaten = birthDate.getText().toString();
                String birthYearn = birthYear.getText().toString();
                String mobileNon = mobileNo.getText().toString();
                String deliveryDaten = deliveryDate.getText().toString();
                int age=(2024-Integer.parseInt(birthYearn));
                // Retrieve the selected RadioButton text
                // inside the OnClickListener
                int selectedId = gender.getCheckedRadioButtonId();
                if (selectedId != -1) {
                    r = findViewById(selectedId);
                    String gendern = r.getText().toString();

                    helper.lactatingRegister(namestr, birthDaten, birthYearn, mobileNon, deliveryDaten, gendern);
                    sendSms(mobileNon,"Your data has been successfully registered for Lactating Mother.We will keep you updated with the latest information. Thank you for registering with us.");
                    Toast.makeText(LactatingMother_register.this, "Data Saved Successfully", Toast.LENGTH_SHORT).show();

//                    Intent intent = new Intent(getApplicationContext(), LactatingMother_add.class);
//                    startActivity(intent);
                } else {
                    // Handle the case where no RadioButton is selected
                    Toast.makeText(LactatingMother_register.this, "Please select gender", Toast.LENGTH_SHORT).show();
                }
                startActivity(new Intent(getApplicationContext(),Pregnant_add.class));


            });
        }
        public void sendSms(String number,String message) {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(number, null, message, null, null);

        }
    }