package com.example.basedemo.my_lifecycle;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.basedemo.R;

public class LifecycleDemoActivity extends AppCompatActivity {
    public static final String TAG = "LifecycleDemoActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle_demo);

        TextView textView = findViewById(R.id.textView);

        MyObserver myObserver = new MyObserver(this, getLifecycle(), new MyObserver.MyCallback() {
            @Override
            public void update(String data) {
                textView.setText(data);
            }
        });
        getLifecycle().addObserver(myObserver);

    }
}
