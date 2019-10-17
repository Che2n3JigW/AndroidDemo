package com.example.basedemo.mvvm;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.basedemo.R;
import com.example.basedemo.databinding.ActivityMvvmBinding;

import java.util.List;

public class MvvmActivity extends AppCompatActivity implements LifecycleObserver {

    private ActivityMvvmBinding binding;
    private MyViewModel model;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //绑定视图
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm);

        //实例化ViewModel
        model = ViewModelProviders.of(this).get(MyViewModel.class);

        //初始化View
        initView();

        subscribeUi(model.getData());
        //binding.setLifecycleOwner(this);


    }

    private void initView() {
        myAdapter = new MyAdapter();
        binding.recyclerView.setAdapter(myAdapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    /**
     * 订阅用户界面
     * @param data 网络返回数据
     */
    private void subscribeUi(MutableLiveData<List<Contributor>> data) {
        data.observe(this, contributors -> {
            myAdapter.setData(contributors);
            binding.executePendingBindings();
        });
    }
}
