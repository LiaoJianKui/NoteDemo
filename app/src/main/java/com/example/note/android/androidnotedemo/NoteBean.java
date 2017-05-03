package com.example.note.android.androidnotedemo;

/**
 * Created by Administrator on 2017/5/3.
 */

public class NoteBean {
    private String date;
    private String content;

    public NoteBean(String date, String content) {
        this.date = date;
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "content:"+getContent()+"  "+"date:"+date;
    }
}
