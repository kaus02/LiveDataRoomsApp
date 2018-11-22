package com.example.kaustubh.roomsappcaster;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "room_table")
public class Task {

    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name = "content")
    String value;


    public Task(String value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


}
