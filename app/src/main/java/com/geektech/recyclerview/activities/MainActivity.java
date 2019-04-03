package com.geektech.recyclerview.activities;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.geektech.recyclerview.R;
import com.geektech.recyclerview.adapters.MainAdapter;
import com.geektech.recyclerview.interfaces.IOnTaskListener;
import com.geektech.recyclerview.models.Task;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements IOnTaskListener {

    RecyclerView recyclerView;

    ArrayList<Task> data = new ArrayList<Task>(){{
       add(new Task(3424, "Title task 1", "Description"));
        add(new Task(3555, "Title task 2", "Description"));
        add(new Task(222, "Title task 3", "Description"));
        add(new Task(4, "Title task 4", "Description"));
        add(new Task(666, "Title task 5", "Description"));
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.main_recycler);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        MainAdapter adapter = new MainAdapter(data, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onTaskClick(int id) {
        Log.d("ololo", "on Task click : " + id);
        Task task = findTaskById(id);
        Intent intent = new Intent(this, TaskDetailsActivity.class);
        intent.putExtra("task", task);
        startActivity(intent);
    }

    private Task findTaskById(int id) {
        return data.get(0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
