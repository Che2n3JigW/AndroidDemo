package com.example.basedemo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basedemo.components4.activity.ActActivity;
import com.example.basedemo.utils.ActivityUtils;

public class MainActivity extends AppCompatActivity {

    private MyListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initListener();

    }

    private void initListener() {
        adapter.setOnItemClickListener(new MyListAdapter.onItemClickListener() {
            @Override
            public void onClick(int position) {
                switch (position) {
                    case 0://
                        ActivityUtils.startActivity(ActActivity.class);
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                }
            }
        });
    }


    private void initView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String[] strings = new String[]{
                "Activity",
                "Service",
                "Broadcast Receive",
                "Content Provider"
        };

        adapter = new MyListAdapter(strings);

        recyclerView.setAdapter(adapter);
    }
}
