    package com.example.aahaarapp;

    import android.content.Intent;
    import android.database.Cursor;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;
    import android.widget.Toast;

    import androidx.appcompat.app.AppCompatActivity;
    import androidx.recyclerview.widget.LinearLayoutManager;
    import androidx.recyclerview.widget.RecyclerView;

    import java.util.LinkedList;
    import java.util.List;

    public class LactatingMother_add extends AppCompatActivity {
        private DemoAdapter adapter;
        private List<String> items;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.lactating_add);

            items = new LinkedList<>();
            RecyclerView recyclerView = findViewById(R.id.Recycler);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            adapter = new DemoAdapter(items);
            recyclerView.setAdapter(adapter);

            findViewById(R.id.button6).setOnClickListener(view -> {
                // Add new layout
                adapter.addNewLayout();
            });
        }
    }

