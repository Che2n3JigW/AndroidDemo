package com.example.basedemo.mvvm;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel implements LifecycleObserver {

    private MutableLiveData<Integer> number;

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void initData(){
        if (number == null) {
            number = new MutableLiveData<>();
            number.setValue(10);
        }
    }

    public MutableLiveData<Integer> getNumber() {
        if (number == null) {
            number = new MutableLiveData<>();
            number.setValue(0);
        }
        return number;
    }

    public void add(){
        Integer value = number.getValue();
        if (value!=null){
            number.setValue(value+1);
        }
    }
}
