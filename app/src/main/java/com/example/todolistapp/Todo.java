package com.example.todolistapp;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.Date;

@Entity(tableName = "todo_table")
public class Todo {

    private static int totalID = 0;

    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int Id;
    @ColumnInfo(name = "title")
    private String Title;
    @ColumnInfo(name = "description")
    private String Description;
    @ColumnInfo(name = "date")
    private String Date;
    @ColumnInfo(name = "is_complete")
    private boolean IsComplete;

    public int getId() {

        return Id;
    }
    public void setId(@NonNull int id) {
        Id = id;
    }

    public String getTitle() {
        return Title;
    }
    public void setTitle(@NonNull String title) {
        this.Title = title;
    }

    public String getDescription() {
        return Description;
    }
    public void setDescription(String description) {
        this.Description = description;
    }

    public String getDate() {
        return Date;
    }
    public void setDate(String date) {
        this.Date = date;
    }

    public boolean getIsComplete() {
        return IsComplete;
    }
    public void setIsComplete(boolean complete) {
        this.IsComplete = complete;
    }

    public Todo() {
        setId(totalID++);
        Date = new Date().toString();
    }


}
