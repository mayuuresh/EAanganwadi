    package com.example.aahaarapp;

    import android.content.BroadcastReceiver;
    import android.content.Context;
    import android.content.Intent;
    import android.os.Bundle;
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
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.lactating_add);
            RecyclerView recyclerView = findViewById(R.id.Recycler);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
//            DemoAdapter adapter = new DemoAdapter(items);
            recyclerView.setAdapter(adapter);
            Button btn=findViewById(R.id.button6);
            btn.setOnClickListener(view -> {
                startActivity(new Intent(getApplicationContext(),LactatingMother_register.class));
//                adapter.addNewLayout();
            });
        }


        @Override
        public void onButtonClick() {
            adapter.addNewLayout();
            Toast.makeText(this, "Please select gender", Toast.LENGTH_SHORT).show();

        }
    }

