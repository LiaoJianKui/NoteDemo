package com.example.note.android.androidnotedemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/5/3.
 */

public class NoteAdapter extends BaseAdapter{
    private Context mContext=null;
    private List<NoteBean> mNoteList;
    public NoteAdapter(Context context,List<NoteBean> noteList){
        this.mContext=context;
        this.mNoteList=noteList;
    }

    @Override
    public int getCount() {
        return mNoteList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if(convertView==null){
            viewHolder=new ViewHolder();
            LayoutInflater mLayoutInflater=LayoutInflater.from(mContext);
            convertView = mLayoutInflater.inflate(R.layout.note_item, null);
            viewHolder.tvTitle= (TextView) convertView.findViewById(R.id.tv_title);
            viewHolder.tvContent= (TextView) convertView.findViewById(R.id.tv_content);
            viewHolder.tvDate= (TextView) convertView.findViewById(R.id.tv_date);
            viewHolder.mImageView= (ImageView) convertView.findViewById(R.id.myImage);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        NoteBean note=mNoteList.get(position);
        viewHolder.tvTitle.setText(note.getTitle());
        viewHolder.tvContent.setText(note.getContent());
        viewHolder.tvDate.setText(note.getDate());
        return convertView;
    }

    private static class ViewHolder{
        private ImageView mImageView;
        private TextView tvTitle;
        private TextView tvContent;
        private TextView tvDate;
    }
}
