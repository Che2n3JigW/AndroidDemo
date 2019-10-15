package com.example.basedemo.my_lifecycle;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * 观察者
 */
public class MyObserver implements LifecycleObserver {

    private static final String TAG = "MyObserver";
    private Context context;
    private Lifecycle lifecycle;
    private MyCallback callback;

    public MyObserver(Context context, Lifecycle lifecycle, MyCallback callback){
        this.context = context;
        this.lifecycle = lifecycle;
        this.callback = callback;
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void initData() {
        String data = "模拟数据";
        callback.update(data);
        Log.e(TAG, "initData: ");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void connectListener() {
        Log.e(TAG, "connectListener: ");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void disconnectListener() {
        Log.e(TAG, "disconnectListener: ");
    }


    public interface MyCallback{
        //更新数据
        void update(String data);
    }
}
