package com.buddheshwar.internshiparoma.resume;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.buddheshwar.internshiparoma.Mainscreen;
import com.buddheshwar.internshiparoma.R;

public class Resume extends AppCompatActivity {

    RelativeLayout actionResume;
    ImageView back,home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume);

        actionResume=findViewById(R.id.actionResume);
        back=actionResume.findViewById(R.id.back);
        home=actionResume.findViewById(R.id.home);

        Fragment fr=new EditResume();
        getSupportFragmentManager().beginTransaction().replace(R.id.container_resume,fr).commit();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Resume.super.onBackPressed();
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Resume.this, Mainscreen.class);
                startActivity(i);
            }
        });

    }
}
