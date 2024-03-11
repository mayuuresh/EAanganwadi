package com.example.aahaarapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;
import java.util.List;

public class DemoAdapter extends RecyclerView.Adapter<DemoAdapter.DemoVH> {
    private final List<String> items;
    int position = 0; // Example position, replace with your desired position
    String newName = "New Name";
    String newAge = "New Age";
    String newMobile = "New Mobile";

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

    public void updateItemText(int position, String newName, String newAge, String newMobile) {

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