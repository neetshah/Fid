package com.example.neet.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    RotateAnimation rotateAnimation, rotateAnimationStart, rotateAnimationEnd;

    boolean imageHolding = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rotateAnimation = new RotateAnimation(0, 1000, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(500);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if(imageHolding){
                    imageView.startAnimation(rotateAnimation);
                } else {
                    imageView.startAnimation(rotateAnimationEnd);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        rotateAnimationEnd = new RotateAnimation(0, 360, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimationEnd.setDuration(500);
        rotateAnimationEnd.setInterpolator(new DecelerateInterpolator());
        rotateAnimationEnd.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        rotateAnimationStart = new RotateAnimation(0, 360, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimationStart.setDuration(500);
        rotateAnimationStart.setInterpolator(new AccelerateInterpolator());
        rotateAnimationStart.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if(imageHolding){
                    imageView.startAnimation(rotateAnimation);
                } else {
                    imageView.startAnimation(rotateAnimationEnd);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


        imageView = (ImageView) findViewById(R.id.imageView);

        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        imageHolding=true;
                        imageView.startAnimation(rotateAnimationStart);
                        break;
                    case MotionEvent.ACTION_UP:
                        imageHolding=false;
                        break;
                }
                return true;
            }
        });
    }
}
