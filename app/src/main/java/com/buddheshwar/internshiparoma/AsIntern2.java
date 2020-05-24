package com.buddheshwar.internshiparoma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AsIntern2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_as_intern2);
    }
    public void goToMain(View view) {

        Intent i=new Intent(AsIntern2.this,Mainscreen.class);
        startActivity(i);
    }

    public void goToSelectField(View view) {

        Intent i=new Intent(AsIntern2.this,SelectField.class);
        startActivity(i);
    }
}
