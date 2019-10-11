package com.example.basedemo.components4.activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import com.example.basedemo.MainActivity;
import com.example.basedemo.R;
import com.example.basedemo.utils.ActivityUtils;

public class ActActivity extends AppCompatActivity {

    private StringBuffer string = new StringBuffer();
    private AppCompatTextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act);
        myAppend("onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        myAppend("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        myAppend("onResume Activity位于屏幕的前景并具有用户焦点。");

    }

    @Override
    protected void onPause() {
        super.onPause();
        myAppend("onPause 另一个Activity在这个Activity的顶部可见，" +
                "该Activity部分透明或不覆盖整个屏幕。暂停的Activity完全处于活动状态");
    }

    @Override
    protected void onStop() {
        super.onStop();
        myAppend("onStop 该Activity完全被另一个Activity遮挡（活动现在位于“背景”中）。停止的Activity也仍然存在");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myAppend("onDestroy");
    }

    void myAppend(String s) {
        if (textView == null) {
            textView = findViewById(R.id.textView);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ActivityUtils.startActivity(MainActivity.class);
                }
            });
        }
        string.append(s).append("\n");
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                textView.setText(string.toString());
            }
        });
    }
}
