package com.example.note.android.androidnotedemo;

/**
 * Created by Administrator on 2017/5/3.
 */

public class NoteBean {
    private int id;
    private String title;
    private String content;
    private String imgResouse;
    private String audioResouse;
    private String videoResouse;
    private String type;
    private String createDate;
    private String modifyDate;
    private boolean isDel;

    public NoteBean() {
    }

    public NoteBean(String title, String content, String imgResouse, String audioResouse, String videoResouse, String type, String createDate, String modifyDate, boolean isDel) {
        this.title = title;
        this.content = content;
        this.imgResouse = imgResouse;
        this.audioResouse = audioResouse;
        this.videoResouse = videoResouse;
        this.type = type;
        this.createDate = createDate;
        this.modifyDate=modifyDate;
        this.isDel=isDel;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
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
    public boolean isDel() {
        return isDel;
    }

    public void setDel(boolean del) {
        isDel = del;
    }
}
