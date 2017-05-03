package com.example.note.android.androidnotedemo;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private List<NoteBean> mNoteBeenList=new ArrayList<>();
    private SwipeMenuListView mSwipeMenuListView;
    private SwipeMenuCreator mSwipeMenuCreator;
    private NoteAdapter mNoteAdapter;
    private int index;
    private FloatingActionButton mFloatingActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar= (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        initViews();
        initNote();//初始化记事本数据
        initNoteAdapter();

    }

    private void initNoteAdapter() {
       mNoteAdapter=new NoteAdapter(this,mNoteBeenList);
        mSwipeMenuListView.setAdapter(mNoteAdapter);

    }

    private void initViews() {
            mSwipeMenuListView= (SwipeMenuListView) findViewById(R.id.listView);
           mSwipeMenuCreator=new SwipeMenuCreator() {
               @Override
               public void create(SwipeMenu menu) {
// create "open" item
                   SwipeMenuItem openItem = new SwipeMenuItem(
                           getApplicationContext());
                   // set item background
                   openItem.setBackground(new ColorDrawable(Color.rgb(0xC9, 0xC9,
                           0xCE)));
                   // set item width
                   openItem.setWidth(120);
                   // set item title
                   openItem.setTitle("Open");
                   // set item title fontsize
                   openItem.setTitleSize(18);
                   // set item title font color
                   openItem.setTitleColor(Color.WHITE);

                   // add to menu
                   menu.addMenuItem(openItem);

                   // create "delete" item
                   SwipeMenuItem deleteItem = new SwipeMenuItem(
                           getApplicationContext());
                   // set item background
                   deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9,
                           0x3F, 0x25)));
                   // set item width
                   deleteItem.setWidth(120);

                   // set a icon
                   deleteItem.setIcon(R.drawable.ic_menu_delete);
                   // add to menu
                   menu.addMenuItem(deleteItem);
               }
           };
        mSwipeMenuListView.setMenuCreator(mSwipeMenuCreator);
        mSwipeMenuListView.setSwipeDirection(SwipeMenuListView.DIRECTION_LEFT);
        mSwipeMenuListView.setOnSwipeListener(new SwipeMenuListView.OnSwipeListener() {
            @Override
            public void onSwipeStart(int index1) {
                        index=index1;
                Toast.makeText(MainActivity.this, "" + index1, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSwipeEnd(int position) {

            }
        });
        mSwipeMenuListView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                switch (index) {
                    case 0:
                        // open
                        break;
                    case 1:
                        // delete
                        mNoteBeenList.remove(index-1);
                        Log.i("AAA", "onMenuItemClick: " + mNoteBeenList.size());
                        mNoteAdapter.notifyDataSetChanged();
                        Log.i("AAA", "onMenuItemClick: " + mNoteBeenList.size());
                        break;
                }
                // false : close the menu; true : not close the menu
                return false;
            }
        });
        mFloatingActionButton = (FloatingActionButton) findViewById(R.id.btn_addNode);
        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "add", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initNote() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        for (int i=0;i<10;i++) {
            NoteBean note1 = new NoteBean("abc","ddddddddddfaegsegergesrgaer",null,null,null,null,df.format(new Date(System.currentTimeMillis())));
            mNoteBeenList.add(note1);
            NoteBean note2 = new NoteBean("123","hellworldhellworldhellworldhellworld",null,null,null,null,df.format(new Date(System.currentTimeMillis())));
            mNoteBeenList.add(note2);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

       return true;
    }
}
