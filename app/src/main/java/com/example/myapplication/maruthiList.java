package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class maruthiList extends AppCompatActivity {
ArrayList<maruthi> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maruthi_list);
        list=new ArrayList<maruthi>();
        list.add(new maruthi("maruhti","android","repu"));
        list.add(new maruthi("maruhti","android","repu"));
        list.add(new maruthi("maruhti","android","repu"));
        list.add(new maruthi("maruhti","android","repu"));
        list.add(new maruthi("maruhti","android","repu"));
        list.add(new maruthi("maruhti","android","repu"));
        list.add(new maruthi("maruhti","android","repu"));
        list.add(new maruthi("maruhti","android","repu"));
        list.add(new maruthi("dddi","androdddcidd","redcdcpu"));
        list.add(new maruthi("maruhti","android","repu"));
        maruthiadapter maruthiadapter=new maruthiadapter(this,list);
        ListView lv=findViewById(R.id.listttt);
        lv.setAdapter(maruthiadapter);
       lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               Toast.makeText(maruthiList.this,list.get(i).a,Toast.LENGTH_LONG).show();

           }
       });
    }
}
