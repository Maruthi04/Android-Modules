package com.example.myapplication;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FragmentHolder extends AppCompatActivity implements sampleinterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_holder);
    }

    @Override
    public void sampletrasfo(String s, String t) {
        FragmentManager fm=getSupportFragmentManager();
        sampleFrag2 f2= (sampleFrag2) fm.findFragmentById(R.id.addnfrg2);
        int c=Integer.parseInt(s)+Integer.parseInt(t);
        f2.adddata(c);
    }
}
