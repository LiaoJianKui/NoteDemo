package com.example.note.android.androidnotedemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/5/3.
 */

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {
    private List<NoteBean> mNoteList;
    public NoteAdapter(List<NoteBean> noteList){
        this.mNoteList=noteList;
    }
    @Override
    public NoteAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(NoteAdapter.ViewHolder holder, int position) {
            NoteBean note=mNoteList.get(position);
        holder.content.setText(note.getContent());
        holder.date.setText(note.getDate());
    }

    @Override
    public int getItemCount() {
        return mNoteList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView date;
        TextView content;
        public ViewHolder(View itemView) {
            super(itemView);
            date= (TextView) itemView.findViewById(R.id.date);
            content= (TextView) itemView.findViewById(R.id.content);
        }
    }
}
