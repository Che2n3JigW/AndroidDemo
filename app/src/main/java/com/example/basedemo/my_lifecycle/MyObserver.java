package com.example.basedemo.my_lifecycle;

import android.content.Context;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

public class MyObserver implements LifecycleObserver {

    private Context context;
    private LifecycleDemoCallback callback;

    public MyObserver(LifecycleOwner lifecycleOwner,
                      LifecycleDemoCallback callback, Context context) {
        this.context = context;
        this.callback = callback;
        lifecycleOwner.getLifecycle().addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void initData() {
        callback.showData("模拟网络请求");
    }

    void update(){
        callback.showData("模拟修改数据");
    }

}
