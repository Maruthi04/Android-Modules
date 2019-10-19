package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class onCreateondestroy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_createondestroy);
        Toast.makeText(onCreateondestroy.this,"i am created",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        Toast.makeText(onCreateondestroy.this,"i am destroyed",Toast.LENGTH_LONG).show();
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Toast.makeText(onCreateondestroy.this,"i am paused",Toast.LENGTH_LONG).show();
        super.onPause();
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
    }

    @Override
    protected void onStart() {
        Toast.makeText(onCreateondestroy.this,"i am started",Toast.LENGTH_LONG).show();
        super.onStart();
    }

    @Override
    protected void onStop() {
        Toast.makeText(onCreateondestroy.this,"i am stopped",Toast.LENGTH_LONG).show();
        super.onStop();
    }

    @Override
    protected void onRestart() {
        Toast.makeText(onCreateondestroy.this,"i am restarted",Toast.LENGTH_LONG).show();
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Toast.makeText(onCreateondestroy.this,"i am resumed",Toast.LENGTH_LONG).show();
        super.onResume();
    }
}
