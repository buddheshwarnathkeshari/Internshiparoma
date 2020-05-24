package com.buddheshwar.internshiparoma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ContinueAsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continue_as);
    }

    public void goToIntern(View v){
        startActivity(new Intent(ContinueAsActivity.this,AsIntern.class));
    }

    public void gotoAsEmployer(View view) {
        startActivity(new Intent(ContinueAsActivity.this,AsEmployer.class));

    }
}
