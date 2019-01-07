package com.example.todolistapp;

import android.arch.persistence.room.Room;
import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

public class TodoModel {

    private static TodoModel sTodoModel;

    private ArrayList<Todo> mTodoList;

    public static TodoModel get(Context context) {
        if (sTodoModel == null) {
            sTodoModel = new TodoModel(context);
        }
        return sTodoModel;
    }

    private TodoModel(Context context){
        mTodoList = new ArrayList<>();
        TodoDatabase db = Room.databaseBuilder(context, TodoDatabase.class, "todo_database").build();

        for (int i=0; i < 3; i++){
            Todo todo = new Todo();
            todo.setmTitle("Todo title " + i);
            todo.setmIsComplete(false);

            mTodoList.add(todo);
        }

    }

    public Todo getTodo(int todoId) {

        for (Todo todo : mTodoList) {
            if (todo.getmId() == todoId){
                return todo;
            }
        }

        return null;
    }

    public ArrayList<Todo> getTodos() {

        return mTodoList;

    }

    public void addTodo(Todo todo){

        mTodoList.add(todo);

    }

    public void deleteTodo(Todo todo) {

        mTodoList.remove(todo);

    }

}