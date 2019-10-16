package com.example.basedemo.mvvm;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.example.basedemo.R;
import com.example.basedemo.databinding.ActivityMvvmBinding;

public class MvvmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_mvvm);
        ActivityMvvmBinding binding
                = DataBindingUtil.setContentView(this, R.layout.activity_mvvm);
        MyViewModel model
                = ViewModelProviders.of(this).get(MyViewModel.class);
        binding.setData(model);
        binding.setLifecycleOwner(this);
        getLifecycle().addObserver(model);
    }
}
