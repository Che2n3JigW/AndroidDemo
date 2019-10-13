package com.example.basedemo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basedemo.animation.AttributeAnimationActivity;
import com.example.basedemo.common.Constant;
import com.example.basedemo.components4.activity.ActActivity;
import com.example.basedemo.utils.ActivityUtils;

public class MainActivity extends AppCompatActivity {

    private MyListAdapter adapter;
    private String[] strings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();

        initView();

        initListener();

    }

    private void initData() {
        strings = new String[]{
                Constant.MAIN_ACTIVITY,
                Constant.MAIN_SERVICE,
                Constant.MAIN_BROADCAST_RECEIVE,
                Constant.MAIN_CONTENT_PROVIDER,
                Constant.MAIN_ATTRIBUTE_ANIMATION
        };
    }

    private void initListener() {
        adapter.setOnItemClickListener(new MyListAdapter.onItemClickListener() {
            @Override
            public void onClick(int position) {
                switch (strings[position]) {
                    case Constant.MAIN_ACTIVITY://
                        ActivityUtils.startActivity(ActActivity.class);
                        break;
                    case Constant.MAIN_SERVICE:
                        break;
                    case Constant.MAIN_ATTRIBUTE_ANIMATION:
                        ActivityUtils.startActivity(AttributeAnimationActivity.class);
                        break;
                }
            }
        });
    }


    private void initView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyListAdapter(strings);
        recyclerView.setAdapter(adapter);
    }
}
