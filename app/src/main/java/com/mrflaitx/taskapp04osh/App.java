package com.mrflaitx.taskapp04osh;

import android.app.Application;

import androidx.room.Room;

import com.mrflaitx.taskapp04osh.data.local.AppDatabase;

public class App extends Application {

    public static AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class,"dataBase")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
    }

}
