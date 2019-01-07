package com.example.todolistapp;

import android.app.Application;
import android.os.AsyncTask;

public class TodoRepository {

    private DaoAccess mTodoDao;

    TodoRepository(Application application) {
        TodoDatabase db = TodoDatabase.getDatabase(application);
        mTodoDao = db.daoAccess();
    }

    public void insert (Todo todo) {
        new insertAsyncTask(mTodoDao).execute(todo);
    }

    private static class insertAsyncTask extends AsyncTask<Todo, Void, Void> {

        private DaoAccess mAsyncTaskDao;

        insertAsyncTask(DaoAccess dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Todo... params) {
            mAsyncTaskDao.insertOnlySingleTodo(params[0]);
            return null;
        }
    }
}
