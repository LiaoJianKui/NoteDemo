package com.example.note.android.androidnotedemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/5/4.
 */

public class AddActivity extends AppCompatActivity {
private Button btnAdd;
    private EditText etTitle;
    private EditText etContent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        initViews();



    }

    private void initViews() {
        etTitle= (EditText) findViewById(R.id.etTitle);
        etContent= (EditText) findViewById(R.id.etContent);
        btnAdd= (Button) findViewById(R.id.btnSave);
        final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title=etTitle.getText().toString();
                String content=etContent.getText().toString();
                NoteDBUtil.addNote(AddActivity.this, title, content, df.format(new Date(System.currentTimeMillis())));
                finish();
            }
        });
    }
}
