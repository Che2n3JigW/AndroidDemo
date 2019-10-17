package com.example.basedemo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basedemo.animation.AttributeAnimationActivity;
import com.example.basedemo.common.Constant;
import com.example.basedemo.components4.activity.ActActivity;
import com.example.basedemo.components4.fragment.FragmentDemoActivity;
import com.example.basedemo.intent.IntentDemoActivity;
import com.example.basedemo.mvvm.MvvmActivity;
import com.example.basedemo.recent.DocumentCentricActivity;
import com.example.basedemo.utils.ActivityUtils;
import com.example.hellojni.HelloJni;

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
                Constant.MAIN_ATTRIBUTE_ANIMATION,
                Constant.MAIN_FRAGMENT,
                Constant.MAIN_INTENT,
                Constant.MAIN_RECENT,
                Constant.MAIN_HELLO_JNI,
                Constant.MAIN_MVVM,
        };
    }

    private void initListener() {
        adapter.setOnItemClickListener(position -> {
            switch (strings[position]) {
                case Constant.MAIN_ACTIVITY://
                    ActivityUtils.startActivity(ActActivity.class);
                    break;
                case Constant.MAIN_SERVICE:
                    break;
                case Constant.MAIN_ATTRIBUTE_ANIMATION:
                    ActivityUtils.startActivity(AttributeAnimationActivity.class);
                    break;
                case Constant.MAIN_FRAGMENT:
                    ActivityUtils.startActivity(FragmentDemoActivity.class);
                    break;
                case Constant.MAIN_INTENT:
                    ActivityUtils.startActivity(IntentDemoActivity.class);
                    break;
                case Constant.MAIN_RECENT:
                    ActivityUtils.startActivity(DocumentCentricActivity.class);
                    break;
                case Constant.MAIN_HELLO_JNI:
                    ActivityUtils.startActivity(HelloJni.class);
                    break;
                case Constant.MAIN_MVVM:
                    ActivityUtils.startActivity(MvvmActivity.class);
                    break;
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
