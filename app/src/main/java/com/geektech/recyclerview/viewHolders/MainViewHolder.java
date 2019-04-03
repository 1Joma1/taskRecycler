package com.geektech.recyclerview.viewHolders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.geektech.recyclerview.R;
import com.geektech.recyclerview.interfaces.IOnTaskListener;
import com.geektech.recyclerview.models.Task;

public class MainViewHolder extends RecyclerView.ViewHolder {

    private TextView textView;
    private TextView tvDescription;
    private IOnTaskListener taskListener;
    private int taskID;

    public MainViewHolder(@NonNull View itemView, IOnTaskListener listener) {
        super(itemView);
        textView = itemView.findViewById(R.id.vh_main_textview);
        tvDescription = itemView.findViewById(R.id.vh_task_description);
        taskListener = listener;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskListener.onTaskClick(taskID);
            }
        });
    }

    public void onBind(Task task) {
        taskID = task.id;
        textView.setText(task.title);
        tvDescription.setText(task.description);
    }
}
