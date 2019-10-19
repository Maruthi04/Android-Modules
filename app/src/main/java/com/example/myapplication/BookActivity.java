package com.example.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookActivity extends AppCompatActivity {
SQLiteDatabase db;
TextView text;
    ListView lv;
    private static final int Version = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        db=openOrCreateDatabase("book", Context.MODE_PRIVATE,null);
        db.execSQL("create table  if not exists bookdetails(bookname varchar,author varchar)");
        db.execSQL("insert into bookdetails values('Magical doors','Maruthi srinvas')");
        db.execSQL("insert into bookdetails values('Girl Next Door','Maruthi srinvas')");
        db.execSQL("insert into bookdetails values('Magical Fantasy','Maruthi srinvas')");
        db.execSQL("insert into bookdetails values('the last magician ','Maruthi srinvas')");
        db.execSQL("insert into bookdetails values('Fault in our stars ','Maruthi srinvas')");
        db.execSQL("insert into bookdetails values('Magadheera ','Maruthi srinvas')");
        db.execSQL("insert into bookdetails values('Baahubali','Maruthi srinvas')");
        db.execSQL("insert into bookdetails values('Dear Comrade','Maruthi srinvas')");
        lv=findViewById(R.id.listv);
        List<Map<String, String>> list = new ArrayList<>();
        HashMap<String,String> map ;
        String [] from = {"country", "currency"};
        int [] n = {android.R.id.text1,
                android.R.id.text2};


        Cursor c= (Cursor) db.rawQuery("Select * from bookdetails",null);
        StringBuffer buffer =
                new StringBuffer();
        while (c.moveToNext())
        {
            map = new HashMap<String, String>();
            map.put("country",  c.getString(0));
            map.put("currency",  c.getString(1));
            list.add(map);
        }
        SimpleAdapter adapter =
                new SimpleAdapter
                        (this,
                                list,
                                android.R.layout.simple_list_item_2,
                                from, n);
        lv.setAdapter(adapter);



    }



}
