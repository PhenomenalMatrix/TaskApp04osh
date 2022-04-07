package com.mrflaitx.taskapp04osh.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class TaskModel {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String task;

    public TaskModel() {
    }

    public TaskModel(String task) {
        this.task = task;
    }

    public TaskModel(int id, String task) {
        this.id = id;
        this.task = task;
    }

    public int getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
