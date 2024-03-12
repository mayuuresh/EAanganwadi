package com.example.aahaarapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aahaarapp.Model.ToDoModel;
import com.example.aahaarapp.Pregnant_add;
import com.example.aahaarapp.R;

import java.util.List;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ViewHolder>{
    private List<ToDoModel> todoList;
    private Pregnant_add activity;
    public ToDoAdapter(Pregnant_add activity){
        this.activity=activity;
    }

    public ViewHolder onCreViewHolder(ViewGroup parent, int viewType){
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ViewHolder(itemView);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    public void setTasks(List<ToDoModel> todoList){
        this.todoList=todoList;
        notifyDataSetChanged();
    }

    public void onBindViewHolder(ViewHolder holder, int position){
        ToDoModel item=todoList.get(position);
        holder.name.setText(item.getName());
        holder.phone.setText(item.getMobile());
        holder.age.setText(item.getBirth());

    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,phone,age;
        public ViewHolder(View view){
            super(view);
            name=view.findViewById(R.id.name);
            phone=view.findViewById(R.id.m1);
            age=view.findViewById(R.id.a1);
        }
    }
}
