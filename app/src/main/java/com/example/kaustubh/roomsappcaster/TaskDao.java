package com.example.kaustubh.roomsappcaster;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TaskDao {

    @Query("select * from ROOM_TABLE")
    LiveData<List<Task>> getTasks();

    @Insert
    void InsertTask(Task task);
}
