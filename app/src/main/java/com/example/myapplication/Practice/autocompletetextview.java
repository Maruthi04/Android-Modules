package com.example.myapplication.Practice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;

import com.example.myapplication.R;

public class autocompletetextview extends AppCompatActivity {
AutoCompleteTextView atv;
ListView list;
String names[]={"harsha","maruti","srinivas"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autocompletetextview);
atv=findViewById(R.id.autoCompleteTextView);
        ArrayAdapter<String> array=new ArrayAdapter<String>(this,android.R.layout.simple_selectable_list_item,names);
//       list=findViewById(R.id.listt);
//
//        list.setAdapter(array);
        atv.setAdapter(array);
        atv.setThreshold(1);
    }
}
