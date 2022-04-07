package com.mrflaitx.taskapp04osh.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.mrflaitx.taskapp04osh.model.TaskModel;

@Database(entities = {TaskModel.class},version = 1,exportSchema = false)
abstract public class AppDatabase extends RoomDatabase {
   public abstract TaskDao taskDao();
}
