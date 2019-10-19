package com.example.myapplication.Practice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class listpractice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listpractice);
        ArrayList<Countries> countries=new ArrayList<Countries>();
        countries.add(new Countries("India","INr","Time"));
        countries.add(new Countries("India","INr","Time"));
        countries.add(new Countries("India","INr","Time"));
        countries.add(new Countries("India","INr","Time"));
        countries.add(new Countries("India","INr","Time"));
        countries.add(new Countries("India","INr","Time"));
        countries.add(new Countries("India","INr","Time"));
        countries.add(new Countries("India","INr","Time"));
        countries.add(new Countries("India","INr","Time"));
        countries.add(new Countries("India","INr","Time"));
        CountryAdapter ca=new CountryAdapter(this,countries);
        ListView list=findViewById(R.id.cntlist);
        list.setAdapter(ca);


    }
}
