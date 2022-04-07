package com.mrflaitx.taskapp04osh.data.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.mrflaitx.taskapp04osh.model.TaskModel;

import java.util.List;

@Dao
public interface TaskDao {

    @Query("SELECT * FROM TaskModel")
    List<TaskModel> getAllTasks();

    @Insert
    void addTask(TaskModel taskModel);

}
