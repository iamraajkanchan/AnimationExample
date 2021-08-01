package com.example.animationexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    TextView tvHelloWorld, tvAnimationTutorial;
    Button btAnimate, btAnimateSet;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        tvHelloWorld = findViewById(R.id.tv_helloWorld);
        tvAnimationTutorial = findViewById(R.id.tv_animationTutorial);
        btAnimate = findViewById(R.id.bt_animate);
        btAnimateSet = findViewById(R.id.bt_animateSet);

        Animation fadeIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        Animation fadeOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);
        Animation blink = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
        Animation movePositiveX = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_positive_x);
        Animation moveNegativeX = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_negative_x);
        Animation movePositiveY = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_positive_y);
        Animation moveNegativeY = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_negative_y);
        Animation helloWorldAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_negative_y);
        Animation animationTutorialAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_animation_tutorial);

        btAnimate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                tvHelloWorld.startAnimation(moveNegativeY);
            }
        });

        btAnimateSet.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                /*
                AnimationSet animationSet = new AnimationSet(true);
                animationSet.addAnimation(helloWorldAnimation);
                animationSet.addAnimation(animationTutorialAnimation);
                tvHelloWorld.startAnimation(animationSet);
                */
                tvHelloWorld.startAnimation(helloWorldAnimation);
                helloWorldAnimation.setAnimationListener(new Animation.AnimationListener()
                {
                    @Override
                    public void onAnimationStart(Animation animation)
                    {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation)
                    {
                        tvAnimationTutorial.setVisibility(View.VISIBLE);
                        tvAnimationTutorial.setAnimation(animationTutorialAnimation);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation)
                    {

                    }
                });
            }
        });
    }
}