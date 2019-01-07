package com.example.todolistapp;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity(tableName = "todo_table")
public class Todo {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int mId;
    @ColumnInfo(name = "title")
    private String mTitle;
    @ColumnInfo(name = "description")
    private String mDescription;
    @ColumnInfo(name = "date")
    private String mDate;
    @ColumnInfo(name = "is_complete")
    private boolean mIsComplete;

    public int getmId() {
        return mId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmDescription() { return mDescription; }

    public void setmDescription(String mDescription) { this.mDescription = mDescription; }

    public String getmDate() {
        return mDate;
    }

    public boolean ismIsComplete() {
        return mIsComplete;
    }

    public void setmIsComplete(boolean mIsComplete) {
        this.mIsComplete = mIsComplete;
    }

    public Todo() {
        mDate = new Date().toString();
    }

}
