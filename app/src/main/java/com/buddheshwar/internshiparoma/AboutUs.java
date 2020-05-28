package com.buddheshwar.internshiparoma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class AboutUs extends AppCompatActivity {

    RelativeLayout actionResume;
    ImageView back,home;
    TextView title;
    LinearLayout aboutUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        actionResume=findViewById(R.id.actionResume);
        back=actionResume.findViewById(R.id.back);
        home=actionResume.findViewById(R.id.home);
        title=actionResume.findViewById(R.id.title);

        home.setVisibility(View.GONE);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AboutUs.super.onBackPressed();
            }
        });
        title.setText("About Us");
        title.setTextSize(25);


    }
}
