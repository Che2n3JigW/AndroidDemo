package com.example.basedemo.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.basedemo.R;
import com.example.basedemo.utils.ActivityUtils;

public class AttributeAnimationActivity extends AppCompatActivity {

    private TextView textView;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attribute_animation);
        textView = findViewById(R.id.textView);

        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(textView, "rotation", 360f);
        objectAnimator.setDuration(2000);
        objectAnimator.setInterpolator(new OvershootInterpolator());
        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
//                Log.e("===cjw", textView.getX() + ", " + textView.getY());
                Log.e("===cjw", textView.getRotationX()+ ", " + textView.getRotationY());
            }
        });
        objectAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                ActivityUtils.startActivity(RotationActivity.class);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        objectAnimator.start();

    }
}
