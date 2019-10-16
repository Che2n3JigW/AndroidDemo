package com.example.basedemo.my_lifecycle;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.basedemo.R;

public class LifecycleDemoActivity extends AppCompatActivity
implements LifecycleDemoCallback{

    private static final String TAG = "LifecycleDemoActivity";
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle_demo);

        textView = findViewById(R.id.textView);

        MyObserver myObserver =
                new MyObserver(this, this, this);


        textView.setOnClickListener(v -> {
            myObserver.update();
        });
    }

    @Override
    public void showData(String s) {
        textView.setText(s);
    }
}
