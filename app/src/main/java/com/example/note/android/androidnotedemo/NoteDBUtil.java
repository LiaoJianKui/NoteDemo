package com.example.note.android.androidnotedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/5/5.
 */

public class NoteDBUtil {
        public static boolean addNote(Context context, String title, String content, String  createTime){
            ContentValues values=new ContentValues();
            values.put(NoteType.COL_ID,1);
            values.put(NoteType.COL_TITLE,title);
            values.put(NoteType.COL_CONTENT,content);
            values.put(NoteType.COL_CREATE_TIME,createTime);
            context.getContentResolver().insert(NoteContentProvider.NOTE_URI,values);
            return true;
        }
    public static ArrayList<NoteBean> getNoteList(Context context) {
        String[] projection = {NoteType.COL_ID, NoteType.COL_TITLE, NoteType.COL_CONTENT, NoteType.COL_CREATE_TIME};
        Cursor c = context.getContentResolver().query(NoteContentProvider.NOTE_URI, projection, null,null, null);

        ArrayList<NoteBean> noteList = new ArrayList<>();
        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            NoteBean note = new NoteBean();
            note.setId(c.getInt(0));
            note.setTitle(c.getString(1));
            note.setContent(c.getString(2));
            note.setCreateDate(c.getString(3));

            noteList.add(note);
        }
        c.close();
        return  noteList;
    }


}
