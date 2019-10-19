package com.example.myapplication.Practice;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.myapplication.R;

public class SupportActivity extends AppCompatActivity implements InterfaceOf {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);
    }

    @Override
    public void reciever(String s) {
        FragmentManager fm=getSupportFragmentManager();
        Frag2 f2= (Frag2) fm.findFragmentById(R.id.frag2);
        f2.changeData(s);
    }
}
