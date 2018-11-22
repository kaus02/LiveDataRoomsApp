package com.example.kaustubh.roomsappcaster;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.kaustubh.roomsappcaster.databinding.ActivityMainBinding;

import java.lang.ref.WeakReference;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private LinearLayoutManager layoutManager;
    private RoomsDatabase roomsDatabase;
    private List<Task> taskList;
    private TaskAdapter adapter;
    private Task newTask;
    private TaskViewModel taskViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        taskViewModel = ViewModelProviders.of(this).get(TaskViewModel.class);

        initialiseDiplay();

        taskViewModel.getList().observe(this, new Observer<List<Task>>() {
            @Override
            public void onChanged(@Nullable List<Task> tasks) {
                adapter.setData(tasks);
            }
        });

        binding.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskViewModel.insertTask(new Task(binding.task.getText().toString()));
            }
        });



    }


    private void initialiseDiplay() {
        adapter = new TaskAdapter(this);
        layoutManager = new LinearLayoutManager(this);
        binding.taskList.setLayoutManager(layoutManager);
        binding.taskList.setAdapter(adapter);
    }


}
