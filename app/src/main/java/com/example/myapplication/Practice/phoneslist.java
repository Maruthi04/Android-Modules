package com.example.myapplication.Practice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class phoneslist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phoneslist);
        ArrayList<phones> phone=new ArrayList<phones>();
        phone.add(new phones("oneplu6","excellent","wonderful","amazing"));
        phone.add(new phones("oneplu6","excellent","wonderful","amazing"));
        phone.add(new phones("oneplu6","excellent","wonderful","amazing"));
        phone.add(new phones("oneplu6","excellent","wonderful","amazing"));
        phone.add(new phones("oneplu6","excellent","wonderful","amazing"));
        phone.add(new phones("oneplu6","excellent","wonderful","amazing"));
        phone.add(new phones("oneplu6","excellent","wonderful","amazing"));
        phone.add(new phones("oneplu6","excellent","wonderful","amazing"));
        phone.add(new phones("oneplu6","excellent","wonderful","amazing"));
        phone.add(new phones("oneplu6","excellent","wonderful","amazing"));
        phone.add(new phones("oneplu6","excellent","wonderful","amazing"));
phonesAdapter ph=new phonesAdapter(this,phone);
        ListView lv=findViewById(R.id.lisst1);
        lv.setAdapter(ph);
    }
}
