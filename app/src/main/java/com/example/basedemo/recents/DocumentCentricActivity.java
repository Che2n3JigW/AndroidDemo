package com.example.basedemo.recents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;

import com.example.basedemo.R;

public class DocumentCentricActivity extends Activity {

    private final static String TAG = "DocumentCentricActivity";

    public final static String KEY_EXTRA_NEW_DOCUMENT_COUNTER = "KEY_EXTRA_NEW_DOCUMENT_COUNTER";

    private static int mDocumentCounter = 0;

    private CheckBox mCheckbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document_centric);
        mCheckbox = findViewById(R.id.multiple_task_checkbox);
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        // Restore state from PersistableBundle
        if (persistentState != null) {
            mDocumentCounter = persistentState.getInt(KEY_EXTRA_NEW_DOCUMENT_COUNTER);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        /*
        To maintain activity state across reboots the system saves and restore critical information for
        all tasks and their activities. Information known by the system includes the activity stack order,
        each task’s thumbnails and each activity’s and task's Intents. For Information that cannot be retained
        because they contain Bundles which can’t be persisted a new constrained version of Bundle,
        PersistableBundle is added. PersistableBundle can store only basic data types. To use it
        in your Activities you must declare the new activity:persistableMode attribute in the manifest.
         */
        outPersistentState.putInt(KEY_EXTRA_NEW_DOCUMENT_COUNTER, mDocumentCounter);
        super.onSaveInstanceState(outState, outPersistentState);
    }

    public void createNewDocument(View view) {
        boolean useMultipleTasks = mCheckbox.isChecked();
        final Intent newDocumentIntent = newDocumentIntent();
        if (useMultipleTasks) {
            /*
            When {@linkIntent#FLAG_ACTIVITY_NEW_DOCUMENT} is used with {@link Intent#FLAG_ACTIVITY_MULTIPLE_TASK}
            the system will always create a new task with the target activity as the root. This allows the same
            document to be opened in more than one task.
             */
            newDocumentIntent.addFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
        }
        startActivity(newDocumentIntent);
    }


    /**
     * Returns an new {@link Intent} to start {@link NewDocumentActivity} as a new document in
     * overview menu.
     *
     * To start a new document task {@link Intent#FLAG_ACTIVITY_NEW_DOCUMENT} must be used. The
     * system will search through existing tasks for one whose Intent matches the Intent component
     * name and the Intent data. If it finds one then that task will be brought to the front and the
     * new Intent will be passed to onNewIntent().
     *
     * Activities launched with the NEW_DOCUMENT flag must be created with launchMode="standard".
     */
    private Intent newDocumentIntent() {
        final Intent newDocumentIntent = new Intent(this, NewDocumentActivity.class);
        newDocumentIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT);
        newDocumentIntent.putExtra(KEY_EXTRA_NEW_DOCUMENT_COUNTER, incrementAndGet());
        return newDocumentIntent;
    }

    private static int incrementAndGet() {
        Log.d(TAG, "incrementAndGet(): " + mDocumentCounter);
        return mDocumentCounter++;
    }

}
