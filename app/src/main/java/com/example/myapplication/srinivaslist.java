package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class srinivaslist extends AppCompatActivity {
ArrayList<srinivas> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_srinivaslist);
    list=new ArrayList<srinivas>();
    list.add(new srinivas("sdvsd","dsvsdv","sdvds"));
        list.add(new srinivas("sdvsd","dsvsdv","sdvds"));
        list.add(new srinivas("sdvsd","dsvsdv","sdvds"));
        list.add(new srinivas("sdvsd","dsvsdv","sdvds"));
        list.add(new srinivas("sdvsd","dsvsdv","sdvds"));
        list.add(new srinivas("sdvsd","dsvsdv","sdvds"));
        list.add(new srinivas("sdvsd","dsvsdv","sdvds"));
        list.add(new srinivas("sdvsd","dsvsdv","sdvds"));
        list.add(new srinivas("sdvsd","dsvsdv","sdvds"));
        list.add(new srinivas("sdvsd","dsvsdv","sdvds"));
        srinivasadapter ada=new srinivasadapter(this,list);
        ListView lv=findViewById(R.id.srini);
        lv.setAdapter(ada);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(srinivaslist.this,list.get(i).a,Toast.LENGTH_LONG).show();
            }
        });
    }
}
