package com.example.note.android.androidnotedemo;

/**
 * Created by Administrator on 2017/5/3.
 */

public class NoteBean {
    private String title;
    private String content;
    private String imgResouse;
    private String audioResouse;
    private String videoResouse;
    private String type;
    private String date;
    public NoteBean(String title, String content, String imgResouse, String audioResouse, String videoResouse, String type, String date) {
        this.title = title;
        this.content = content;
        this.imgResouse = imgResouse;
        this.audioResouse = audioResouse;
        this.videoResouse = videoResouse;
        this.type = type;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVideoResouse() {
        return videoResouse;
    }

    public void setVideoResouse(String videoResouse) {
        this.videoResouse = videoResouse;
    }

    public String getAudioResouse() {
        return audioResouse;
    }

    public void setAudioResouse(String audioResouse) {
        this.audioResouse = audioResouse;
    }

    public String getImgResouse() {
        return imgResouse;
    }

    public void setImgResouse(String imgResouse) {
        this.imgResouse = imgResouse;
    }

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



}
