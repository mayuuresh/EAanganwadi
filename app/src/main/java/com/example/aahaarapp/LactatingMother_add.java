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

    import java.util.LinkedList;
    import java.util.List;

    public class LactatingMother_add extends AppCompatActivity implements ButtonClickListener {
        List<String> items = new LinkedList<>();
        DemoAdapter adapter = new DemoAdapter(items);
        Button btnadd;
        MyDBHelperLactatingMother helper;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.lactating_add);
            helper = new MyDBHelperLactatingMother(this);
            RecyclerView recyclerView = findViewById(R.id.Recycler);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            DemoAdapter adapter = new DemoAdapter(items);
            recyclerView.setAdapter(adapter);
            Cursor cursor = helper.readAllData();
            while (cursor.moveToNext()) {
                adapter.addNewLayout();
            }
            btnadd = findViewById(R.id.button6);
            btnadd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(), LactatingMother_register.class));
                }
            });



        }


        @Override
        public void onButtonClick() {
            adapter.addNewLayout();
            Toast.makeText(this, "Please select gender", Toast.LENGTH_SHORT).show();

        }
    }

