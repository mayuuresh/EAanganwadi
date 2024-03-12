    package com.example.aahaarapp;

    import android.content.BroadcastReceiver;
    import android.content.Context;
    import android.content.Intent;
    import android.database.Cursor;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;
    import android.widget.TextView;
    import android.widget.Toast;

    import androidx.appcompat.app.AppCompatActivity;
    import androidx.recyclerview.widget.LinearLayoutManager;
    import androidx.recyclerview.widget.RecyclerView;

    import com.google.android.material.tabs.TabLayout;

    import java.util.LinkedList;
    import java.util.List;

    public class LactatingMother_add extends AppCompatActivity{
        List<String> items = new LinkedList<>();
        DemoAdapter adapter = new DemoAdapter(items);
        Button btnadd;
        TabLayout tabLayout;


        MyDBHelperLactatingMother helper;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.lactating_add);
            tabLayout = findViewById(R.id.tabLayout);
            helper = new MyDBHelperLactatingMother(this);
            RecyclerView recyclerView = findViewById(R.id.Recycler);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            DemoAdapter adapter = new DemoAdapter(items);
            recyclerView.setAdapter(adapter);
            Cursor cursor = helper.readAllData();
            int i=0;
            while (cursor.moveToNext()) {
                adapter.addNewLayout();
            }
            btnadd = findViewById(R.id.button6);
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
            btnadd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(), LactatingMother_register.class));
                }
            });



        }



    }

