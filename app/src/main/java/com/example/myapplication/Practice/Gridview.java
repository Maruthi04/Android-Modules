package com.example.myapplication.Practice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.example.myapplication.R;

public class Gridview extends AppCompatActivity {

    String in[]={"maruhti","srinivas","hello"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);
        ArrayAdapter<String> arr=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,in);
        GridView gr=findViewById(R.id.grid);
        gr.setAdapter(arr);


    }
}
