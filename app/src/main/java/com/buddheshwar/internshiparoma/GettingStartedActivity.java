package com.buddheshwar.internshiparoma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class GettingStartedActivity extends AppCompatActivity {

    ViewFlipper vf;
    View v1,v2,v3,v4;
    TextView tvNext,tvPrev;
    int viewNumber;
    Button btnGetStarted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getting_started);

        viewNumber=1;
        v1=findViewById(R.id.v1);
        v2=findViewById(R.id.v2);
        v3=findViewById(R.id.v3);
        v4=findViewById(R.id.v4);
        vf=findViewById(R.id.vp);
        tvNext=findViewById(R.id.tv_next);
        tvPrev=findViewById(R.id.tv_prev);
        btnGetStarted=findViewById(R.id.btn_getStarted);
    }
    public void next(View v){
        vf.showNext();
        viewNumber++;
        switch((viewNumber)){
            case 1:
                v1.setBackgroundResource(R.drawable.round);
                v2.setBackgroundResource(R.drawable.round2);
                v3.setBackgroundResource(R.drawable.round2);
                v4.setBackgroundResource(R.drawable.round2);
                break;
            case 2:
                tvPrev.setVisibility(View.VISIBLE);
                v2.setBackgroundResource(R.drawable.round);
                v1.setBackgroundResource(R.drawable.round2);
                v3.setBackgroundResource(R.drawable.round2);
                v4.setBackgroundResource(R.drawable.round2);
                break;
            case 3:
                v3.setBackgroundResource(R.drawable.round);
                v2.setBackgroundResource(R.drawable.round2);
                v1.setBackgroundResource(R.drawable.round2);
                v4.setBackgroundResource(R.drawable.round2);
                break;
            case 4:
                tvNext.setVisibility(View.GONE);
                btnGetStarted.setVisibility(View.VISIBLE);
                v4.setBackgroundResource(R.drawable.round);
                v2.setBackgroundResource(R.drawable.round2);
                v3.setBackgroundResource(R.drawable.round2);
                v1.setBackgroundResource(R.drawable.round2);
                break;
        }
    }


    public void prev(View v){
        vf.showNext();
        viewNumber--;
        switch((viewNumber)){
            case 1:
                tvPrev.setVisibility(View.GONE);
                v1.setBackgroundResource(R.drawable.round);
                v2.setBackgroundResource(R.drawable.round2);
                v3.setBackgroundResource(R.drawable.round2);
                v4.setBackgroundResource(R.drawable.round2);
                break;
            case 2:

                v2.setBackgroundResource(R.drawable.round);
                v1.setBackgroundResource(R.drawable.round2);
                v3.setBackgroundResource(R.drawable.round2);
                v4.setBackgroundResource(R.drawable.round2);
                break;
            case 3:
                v3.setBackgroundResource(R.drawable.round);
                v2.setBackgroundResource(R.drawable.round2);
                v1.setBackgroundResource(R.drawable.round2);
                v4.setBackgroundResource(R.drawable.round2);
                btnGetStarted.setVisibility(View.GONE);
                tvNext.setVisibility(View.VISIBLE);

                break;
            case 4:
                tvNext.setVisibility(View.GONE);
                btnGetStarted.setVisibility(View.VISIBLE);
                v4.setBackgroundResource(R.drawable.round);
                v2.setBackgroundResource(R.drawable.round2);
                v3.setBackgroundResource(R.drawable.round2);
                v1.setBackgroundResource(R.drawable.round2);
                break;
        }
    }


    public void getStarted(View view) {
        Intent i=new Intent(GettingStartedActivity.this,Mainscreen.class);
        startActivity(i);
    }
}
