package com.example.basedemo.recent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.basedemo.R;
import com.example.basedemo.common.Constant;

public class NewDocumentActivity extends AppCompatActivity {

    private TextView mDocumentCounterTextView;
    private int mDocumentCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_document);
        mDocumentCount = getIntent()
                .getIntExtra(Constant.KEY_EXTRA_NEW_DOCUMENT_COUNTER, 0);
        mDocumentCounterTextView = findViewById(
                R.id.hello_new_document_text_view);
        setDocumentCounterText(R.string.hello_new_document_counter);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setDocumentCounterText(R.string.string_test);
    }


    public void setDocumentCounterText(int resId) {
        mDocumentCounterTextView
                .setText(String.format(getString(resId), String.valueOf(mDocumentCount)));
    }

    public void onRemoveFromOverview(View view) {
        finishAndRemoveTask();
    }


}
