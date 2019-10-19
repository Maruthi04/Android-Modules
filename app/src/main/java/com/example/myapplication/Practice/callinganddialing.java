package com.example.myapplication.Practice;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.myapplication.MyService;
import com.example.myapplication.R;

public class callinganddialing extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_callinganddialing);
    }
    public  void startservice(View v)
    {
        Intent in=new Intent(callinganddialing.this, MyService.class);
        startService(in);
    }
    public  void stopservice(View v)
    {
        Intent in=new Intent(callinganddialing.this, MyService.class);
    stopService(in);
    }

}

