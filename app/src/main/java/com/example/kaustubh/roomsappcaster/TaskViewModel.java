package com.example.kaustubh.roomsappcaster;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class TaskViewModel extends AndroidViewModel {

    private TaskRepository mTaskRepository;
    private LiveData<List<Task>> list;



    public TaskViewModel(Application application) {
        super(application);
        mTaskRepository =  new TaskRepository(application);
        list = mTaskRepository.getList();
    }

    public LiveData<List<Task>> getList() {
        return list;
    }

    public void insertTask(Task task){
        mTaskRepository.insertTask(task);
    }
}
