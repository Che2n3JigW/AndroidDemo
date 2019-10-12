package com.example.basedemo.animation;

import android.os.Build;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.widget.FrameLayout;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.basedemo.R;

public class ScenceActivity extends AppCompatActivity {

    Scene aScene;
    Scene anotherScene;
    FrameLayout sceneRoot;


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scence);

        // Create the scene root for the scenes in this app
        sceneRoot =  findViewById(R.id.scene_root);

        // Create the scenes
        aScene = Scene.getSceneForLayout(sceneRoot, R.layout.a_scene, this);
        anotherScene =
                Scene.getSceneForLayout(sceneRoot, R.layout.another_scene, this);

        Transition fadeTransition = new Fade();
        TransitionManager.go(anotherScene, fadeTransition);
    }
}
