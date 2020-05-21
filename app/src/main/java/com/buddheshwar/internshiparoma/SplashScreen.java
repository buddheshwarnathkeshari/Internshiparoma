package com.buddheshwar.internshiparoma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class SplashScreen extends AppCompatActivity {
    LinearLayout logo;
    ImageView ball;
    FrameLayout back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        logo=findViewById(R.id.container);
        ball=findViewById(R.id.ball);
        back=findViewById(R.id.back);

        Animation animation3= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.main_out);
        back.startAnimation(animation3);
        Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade);
        logo.startAnimation(animation);
        Animation animation2= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bounce);
        ball.startAnimation(animation2);

        Handler h=new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreen.this,GettingStartedActivity.class));
            }
        },3500);
    }
}
