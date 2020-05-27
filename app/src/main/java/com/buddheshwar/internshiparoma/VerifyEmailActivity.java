package com.buddheshwar.internshiparoma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.nsd.NsdManager;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

public class VerifyEmailActivity extends AppCompatActivity {

    EditText et1,et2,et3,et4;
    private EditText otpET1, otpET2, otpET3, otpET4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_email);

        et1=findViewById(R.id.et_otp1);


        otpET1 = findViewById(R.id.et_otp1);
        otpET2 = findViewById(R.id.et_otp2);
        otpET3 = findViewById(R.id.et_otp3);
        otpET4 = findViewById(R.id.et_otp4);

        otpET1.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(i!=keyEvent.KEYCODE_DEL){
                    otpET2.requestFocus();
                }
                return false;
            }
        });
        otpET2.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {

                if(i==KeyEvent.KEYCODE_DEL && keyEvent.getAction()==KeyEvent.ACTION_DOWN){
                    otpET1.requestFocus(View.FOCUS_DOWN);
                }
                else if(otpET2.getText().length()==1){
                    otpET3.requestFocus();
                }
                else{
                    otpET2.requestFocus();
                }
                return false;
            }
        });
        otpET3.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {

                if(i==KeyEvent.KEYCODE_DEL && keyEvent.getAction()==KeyEvent.ACTION_DOWN){
                    otpET2.requestFocus(View.FOCUS_DOWN);

                }
                else if(otpET3.getText().length()==1){
                    otpET4.requestFocus();
                }
                else{
                    otpET3.requestFocus();
                }
                return false;
            }
        });
        otpET4.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {

                if(i==KeyEvent.KEYCODE_DEL && keyEvent.getAction()==KeyEvent.ACTION_DOWN){
                    otpET3.requestFocus(View.FOCUS_DOWN);

                }
                else{
                    otpET4.requestFocus();
                }
                return false;
            }
        });
        otpET1.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(count==1){
                    otpET2.requestFocus();
                }
                else{
                    otpET1.requestFocus();
                }
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void afterTextChanged(Editable s) { }
        });
        otpET2.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(count==1){

                    otpET3.requestFocus();
                }
                else{
                    otpET2.requestFocus();
                }
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void afterTextChanged(Editable s) { }
        });
        otpET3.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(count==1){
                    otpET4.requestFocus();
                }
                else{
                    otpET3.requestFocus();
                }
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void afterTextChanged(Editable s) { }
        });
        otpET4.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                    otpET4.requestFocus();

            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void afterTextChanged(Editable s) { }
        });

    }



    public void goToContinueAs(View view) {
        startActivity(new Intent(VerifyEmailActivity.this,ContinueAsActivity.class));
    }
}
