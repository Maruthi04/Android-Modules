package com.example.myapplication.Practice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.BroadCastReciever;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle bundle = intent.getExtras();
        String msg = bundle.getString("msg");
        Toast.makeText(context, "Intent Detected " +
                        "with message : "+msg,
                Toast.LENGTH_LONG).show();
    }


}
