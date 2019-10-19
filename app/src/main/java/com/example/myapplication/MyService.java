package com.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MyService extends Service {
    MediaPlayer mx;

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mx=MediaPlayer.create(this,R.raw.ring);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        mx.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mx.stop();

    }

    @Override
    public boolean stopService(Intent name) {
        mx.stop();
        return super.stopService(name);
    }

}
