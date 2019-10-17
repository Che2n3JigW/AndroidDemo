package com.example.basedemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyService extends Service {

    private static final String TAG= "MyService";
    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "onCreate: " + Thread.currentThread().getId() );
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "onStartCommand - startId = "
                + startId + ", Thread ID = "
                + Thread.currentThread().getId() );

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.e(TAG, "onDestroy: " + Thread.currentThread().getId() );
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
