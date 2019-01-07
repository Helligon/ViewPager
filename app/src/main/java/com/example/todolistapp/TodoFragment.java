package com.example.todolistapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;

public class TodoFragment extends Fragment {

    private static final String ARG_TODO_ID = "todo_id";

    private Todo mTodo;
    private EditText mEditTextTitle;
    private EditText mEditDescriptionTitle;
    private Button mButtonDate;
    private CheckBox mCheckBoxIsComplete;

    /*
    Rather than the calling the constructor directly, Activity(s) should call newInstance
    and pass required parameters that the fragment needs to create its arguments.
     */
    public static TodoFragment newInstance(int todoId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_TODO_ID, todoId);

        TodoFragment fragment = new TodoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        int todoId = (int) getArguments().getSerializable(ARG_TODO_ID);

        mTodo = TodoModel.get(getActivity()).getTodo(todoId);

    }

    @Override
    public void onCreateOptionsMenu(Menu deleteMenu, MenuInflater inflater) {
        super.onCreateOptionsMenu(deleteMenu, inflater);
        inflater.inflate(R.menu.fragment_todo, deleteMenu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.delete_todo:

                TodoModel.get(getActivity()).deleteTodo(mTodo);

                getActivity().finish();

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_todo, container, false);

        mEditTextTitle = (EditText) view.findViewById(R.id.todo_title);
        mEditTextTitle.setText(mTodo.getTitle());
        mEditTextTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // This line is intentionally left blank
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mTodo.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // This line is intentionally left blank
            }
        });

        mEditDescriptionTitle = (EditText) view.findViewById(R.id.todo_description);
        mEditDescriptionTitle.setText(mTodo.getDescription());
        mEditDescriptionTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // This line is intentionally left blank
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mTodo.setDescription(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {
                // This line is intentionally left blank
            }
        });

        mButtonDate = (Button) view.findViewById(R.id.todo_date);
        if (mTodo.getIsComplete()) {
            mButtonDate.setText(mTodo.getDate());
            mButtonDate.setEnabled(true);
        }

        mCheckBoxIsComplete = (CheckBox) view.findViewById(R.id.todo_complete);
        mCheckBoxIsComplete.setChecked(mTodo.getIsComplete());
        mCheckBoxIsComplete.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d("DEBUG **** TodoFragment","called onCheckedChanged");
                mTodo.setIsComplete(isChecked);
                mButtonDate.setText(mTodo.getDate());
                mButtonDate.setEnabled(true);
            }
        });

        return view;

    }
}