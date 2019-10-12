package com.example.basedemo.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Path;
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

//        ObjectAnimatorDemo();

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            ObjectAnimatorDemo1();
//        }
        AnimatorSetDemo();


    }

    private void AnimatorSetDemo() {
        AnimatorSet bouncer = new AnimatorSet();
        ObjectAnimator objectAnimatorA = ObjectAnimator.ofFloat(textView,"translationX" , 0f, 300f);
        ObjectAnimator objectAnimatorB = ObjectAnimator.ofFloat(textView, "translationY", 0f, 300f);
        ObjectAnimator objectAnimatorC = ObjectAnimator.ofFloat(textView, "translationX", 300f, 0f);
        ObjectAnimator objectAnimatorD = ObjectAnimator.ofFloat(textView, "rotation", 0f, 360f);
        bouncer.play(objectAnimatorA);
        bouncer.play(objectAnimatorB).after(objectAnimatorA).with(objectAnimatorD);
        bouncer.play(objectAnimatorC).after(objectAnimatorB);
        bouncer.setDuration(2000);
        bouncer.start();
//        ValueAnimator fadeAnim = ObjectAnimator.ofFloat(textView, "alpha", 1f, 0f);
//        fadeAnim.setDuration(2000);

//        AnimatorSet animatorSet = new AnimatorSet();
//        animatorSet.play(bouncer).before(fadeAnim);
//        animatorSet.start();

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void ObjectAnimatorDemo1() {//设置两个动画
        Path path = new Path();
        path.moveTo(0,1);
        path.lineTo(300,3);
        ObjectAnimator.ofFloat(textView,"translationX", "translationY",path)
                .setDuration(3000)
                .start();
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
