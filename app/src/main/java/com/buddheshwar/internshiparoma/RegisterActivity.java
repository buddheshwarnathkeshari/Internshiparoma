package com.buddheshwar.internshiparoma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;


public class RegisterActivity extends AppCompatActivity {
AutoCompleteTextView actv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
       /* actv=findViewById(R.id.et_course);
        String[] courses=new String[]{"B.tech","BCA","M.tech","MCA"};
        actv.setAdapter(new ArrayAdapter<String>(getApplicationContext(),android.R.layout.select_dialog_item,courses));
        actv.setThreshold(0);
        actv.setTextColor(Color.parseColor("#DA4B2B"));*/
    }

    public void goToLogin(View view) {
        startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
    }

    public void goToVerify(View view) {
        startActivity(new Intent(RegisterActivity.this,VerifyEmailActivity.class));
    }

    public void goToMain(View view) {
        startActivity(new Intent(RegisterActivity.this,Mainscreen.class));
    }
}
