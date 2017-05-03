package com.example.note.android.androidnotedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private List<NoteBean> mNoteBeen=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initNote();//初始化记事本数据
        RecyclerView recyclerView= (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        NoteAdapter noteAdapter=new NoteAdapter(mNoteBeen);
        recyclerView.setAdapter(noteAdapter);
    }

    private void initNote() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        for (int i=0;i<10;i++) {
            NoteBean note1 = new NoteBean(df.format(new Date(System.currentTimeMillis())), "srBaseledsagdddddddddgsadgasdgsdgsadgfwj");
            mNoteBeen.add(note1);
            NoteBean note2 = new NoteBean(df.format(new Date(System.currentTimeMillis())), "sdfjkDFDGHRSHDRHTRdggggggggggggggggaselefwj");
            mNoteBeen.add(note2);
        }
    }
}
