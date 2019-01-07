package com.example.todolistapp;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

@Dao
public interface DaoAccess {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOnlySingleTodo (Todo todo);
    @Query("SELECT * FROM todo_table WHERE Id = :todoID")
    Todo fetchOneTodoByTodoID (int todoID);
    @Update
    void updateTodo (Todo todo);
    @Delete
    void deleteTodo (Todo todo);

}
