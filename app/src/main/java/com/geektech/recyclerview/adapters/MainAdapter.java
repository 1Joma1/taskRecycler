package com.geektech.recyclerview.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geektech.recyclerview.R;
import com.geektech.recyclerview.interfaces.IOnTaskListener;
import com.geektech.recyclerview.models.Task;
import com.geektech.recyclerview.viewHolders.MainViewHolder;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {

    private ArrayList<Task> data;
    private IOnTaskListener taskListener;

    public MainAdapter(ArrayList<Task> data, IOnTaskListener listener) {
        this.data = data;
        taskListener = listener;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.viewholder_main, viewGroup, false);
        MainViewHolder mainViewHolder = new MainViewHolder(view, taskListener);
        return mainViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder mainViewHolder, int i) {
        mainViewHolder.onBind(data.get(i % data.size()));
    }

    @Override
    public int getItemCount() {
        return 1000;
    }
}
