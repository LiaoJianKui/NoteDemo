package com.example.note.android.androidnotedemo;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by Administrator on 2017/5/4.
 */

public class NoteContentProvider extends ContentProvider {
    private NoteOpenHelper mHelper;
    private static String AUTHORITY = "com.example.note.android.androidnotedemo";
    public static final Uri NOTE_URI = Uri.parse("content://com.example.note.android.androidnotedemo/note");
    private static final UriMatcher sMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        sMatcher.addURI(AUTHORITY, NoteType.TABLE_NAME, 1);
    }
    @Override
    public boolean onCreate() {
        mHelper = NoteOpenHelper.getInstance(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        switch (sMatcher.match(uri)) {
            case 1:
                SQLiteDatabase db = mHelper.getReadableDatabase();
                Cursor c = db.query(NoteType.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
                return c;
            case 2:


                break;


        }


        return null;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        switch (sMatcher.match(uri)) {
            case 1:
                SQLiteDatabase db = mHelper.getWritableDatabase();
                db.insert(NoteType.TABLE_NAME, null, values);
                db.close();
                return Uri.withAppendedPath(NOTE_URI, values.getAsString(NoteType.COL_ID));
            default:
                return null;
        }
    }
    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
