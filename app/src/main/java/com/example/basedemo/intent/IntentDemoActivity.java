package com.example.basedemo.intent;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.basedemo.R;
import com.example.basedemo.utils.ActivityUtils;

import java.util.List;

public class IntentDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_demo);

//        map();
//        call();
//        send();
        web();


    }

    private void web() {
        Uri webPage = Uri.parse("http://www.baidu.com");
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webPage);
        String title = getResources().getString(R.string.app_name);
        Intent chooser = Intent.createChooser(webIntent, title);
        if (webIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(chooser);
        }
    }

    private void send() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"jon@example.com"}); // recipients
        intent.putExtra(Intent.EXTRA_SUBJECT, "Email subject");
        intent.putExtra(Intent.EXTRA_TEXT, "Email message text");
        intent.putExtra(Intent.EXTRA_STREAM, Uri.parse("content://path/to/email/attachment"));
        ActivityUtils.startActivity(intent);

        String title = getResources().getString(R.string.app_name);
        Intent chooser = Intent.createChooser(intent, title);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(chooser);
        }
    }

    private void call() {
        Uri number = Uri.parse("tel:5551234");
        Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
        ActivityUtils.startActivity(callIntent);
    }

    private void map() {
        Uri location = Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway," +
                "+Mountain+View,+California");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);

        // Verify it resolves
        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(mapIntent, 0);
        boolean isIntentSafe = activities.size() > 0;

        // Start an activity if it's safe
        if (isIntentSafe) {
            ActivityUtils.startActivity(mapIntent);
        }

    }
}
