package com.example.todolistapp;

import android.content.Context;

import java.util.ArrayList;

public class TodoModel {

    private static TodoModel sTodoModel;

    private TodoRepository mRepository;

    private ArrayList<Todo> mTodoList;

    public static TodoModel get(Context context) {
        if (sTodoModel == null) {
            sTodoModel = new TodoModel(context);
        }
        return sTodoModel;
    }

    private TodoModel(Context context){
        mTodoList = new ArrayList<>();

        for (int i=0; i < 3; i++){
            Todo todo = new Todo();
            todo.setTitle("Todo title " + i);
            todo.setIsComplete(false);

            mTodoList.add(todo);
        }

    }

    public Todo getTodo(int todoId) {

        for (Todo todo : mTodoList) {
            if (todo.getId() == todoId){    
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