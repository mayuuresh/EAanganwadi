package com.example.aahaarapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aahaarapp.Adapter.ToDoAdapter;
import com.example.aahaarapp.Model.ToDoModel;

import java.util.ArrayList;
import java.util.List;

public class Pregnant_add extends AppCompatActivity {
    Button Add,update,view;
    private RecyclerView taskRecyclerView;
    private ToDoAdapter taskAdapter;
    private List<ToDoModel> taskList;
    ArrayList<String> listItem;
    ArrayAdapter adapter;
    MyDBHelperPregnantWomen helper;
    ListView userlist;
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pregnant_add);
        Add = findViewById(R.id.button6);
        userlist = findViewById(R.id.list);
        listItem = new ArrayList<>();
        helper=new MyDBHelperPregnantWomen(this);
        viewData();

    userlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            String text=userlist.getItemAtPosition(i).toString();
            Toast.makeText(Pregnant_add.this,""+text,Toast.LENGTH_SHORT).show();
        }
    });

//
//        taskRecyclerView= findViewById(R.id.Recycler);
//        taskRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        taskAdapter=new ToDoAdapter(this);
//        taskRecyclerView.setAdapter(taskAdapter);
//        taskList =new ArrayList<>();
//
//        ToDoModel task=new ToDoModel();
//        task.setName("Rahul");
//        task.setMobile("1234567890");
//        task.setBirth("1dfsg");
//
//        taskList.add(task);
//        taskList.add(task);
//        taskList.add(task);
//
//        taskAdapter.setTasks(taskList);
        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Preganent_Register.class));
            }
        });

    }

    private void viewData() {
        Cursor cursor=helper.viewData();
        if(cursor.getCount()==0){
            Toast.makeText(this,"No data to show",Toast.LENGTH_SHORT).show();
        }
        else{
            while(cursor.moveToNext()){
                listItem.add("Name:-"+cursor.getString(1)+"\nMobile:- "+cursor.getString(0)+"           Date of Birth:-"+cursor.getString(2));
            }
            adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listItem);
            userlist.setAdapter(adapter);
        }
    }

}

