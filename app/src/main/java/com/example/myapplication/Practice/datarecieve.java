package com.example.myapplication.Practice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication.R;

public class datarecieve extends AppCompatActivity {
TextView s1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datarecieve);
        s1=findViewById(R.id.textt);
        String s=getIntent().getStringExtra("name");
        s1.setText(s);
    }
}
