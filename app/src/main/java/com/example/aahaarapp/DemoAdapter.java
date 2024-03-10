package com.example.aahaarapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DemoAdapter extends RecyclerView.Adapter<DemoAdapter.DemoVH> {
    private List<String> items;

    DemoAdapter(List<String> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public DemoVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new DemoVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DemoVH holder, int position) {
        // Bind data here if needed
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addNewLayout() {
        // Add new item to the list and notify adapter
        items.add("New Item");
        notifyItemInserted(items.size() - 1);
    }

    public static class DemoVH extends RecyclerView.ViewHolder {
        public DemoVH(@NonNull View itemView) {
            super(itemView);
        }
    }
}
