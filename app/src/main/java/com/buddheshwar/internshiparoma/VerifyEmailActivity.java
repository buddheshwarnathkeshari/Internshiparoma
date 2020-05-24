package com.buddheshwar.internshiparoma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.nsd.NsdManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class VerifyEmailActivity extends AppCompatActivity {

    EditText et1,et2,et3,et4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_email);

    }

    public void goToContinueAs(View view) {
        startActivity(new Intent(VerifyEmailActivity.this,ContinueAsActivity.class));
    }
}
