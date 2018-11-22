package com.example.kaustubh.roomsappcaster;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface TaskDao {

    @Query("select * from ROOM_TABLE")
    LiveData<List<Task>> getTasks();

    @Insert
    void InsertTask(Task task);
}
