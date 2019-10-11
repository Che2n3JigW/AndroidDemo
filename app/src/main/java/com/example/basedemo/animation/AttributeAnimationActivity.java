package com.example.basedemo.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.basedemo.R;

public class AttributeAnimationActivity extends AppCompatActivity {

    private TextView textView;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attribute_animation);
        textView = findViewById(R.id.textView);

//        ValueAnimatorDemo();

        ObjectAnimatorDemo();


    }

    private void ObjectAnimatorDemo() {
        ObjectAnimator animation = ObjectAnimator.ofFloat(textView, "translationX", 100f);
        animation.setDuration(1000);
        animation.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animation) {
                Log.e("===cjw", "onAnimationEnd");
            }
        });

        animation.start();
    }

    private void ValueAnimatorDemo() {
        ValueAnimator animation = ValueAnimator.ofFloat(0f, 100f);
        animation.setDuration(1000);
        animation.start();

        animation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator updatedAnimation) {
                // You can use the animated value in a property that uses the
                // same type as the animation. In this case, you can use the
                // float value in the translationX property.
                float animatedValue = (float) updatedAnimation.getAnimatedValue();
                textView.setTranslationX(animatedValue);
            }
        });
    }
}
