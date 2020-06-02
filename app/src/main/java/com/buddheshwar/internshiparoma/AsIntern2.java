package com.buddheshwar.internshiparoma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

public class AsIntern2 extends AppCompatActivity {

    EditText skill1,skill2,skill3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_as_intern2);

        skill1=findViewById(R.id.et_preference_one);
        skill2=findViewById(R.id.et_preference_two);
        skill3=findViewById(R.id.et_preference_three);


        skill1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int left=0,top=1,right=2,bottom=3;
                /*if(event.getAction()==MotionEvent.ACTION_UP){
                    if(event.getRawX()>=(skill1.getRight()-skill1.getCompoundDrawables()[right].getBounds().width())){

                        skill1.setText("");
                    }
                    else{
                        Intent i=new Intent(AsIntern2.this,SelectField2.class);
                        String[] dataArray=new String[]{skill1.getText().toString(),skill2.getText().toString(),skill3.getText().toString()};
                        int preferenceNumber=0;
                        switch (skill1.getId()){
                            case R.id.et_preference_one:
                                preferenceNumber=1;
                                break;
                            case R.id.et_preference_two:
                                preferenceNumber=2;
                                break;
                            case R.id.et_preference_three:
                                preferenceNumber=3;
                                break;
                        }


                        i.putExtra("DataStringArray",dataArray);
                        i.putExtra("PreferenceNumber",preferenceNumber);
                        startActivity(i);
                        finish();
                    }
                    return true;
                }*/


                return false;
            }
        });

        skill2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int left=0,top=1,right=2,bottom=3;
                /*if(event.getAction()==MotionEvent.ACTION_UP){
                    if(event.getRawX()>=(skill2.getRight()-skill2.getCompoundDrawables()[right].getBounds().width())){

                        skill2.setText("");
                    }
                    else{
                        Intent i=new Intent(AsIntern2.this,SelectField2.class);
                        String[] dataArray=new String[]{skill1.getText().toString(),skill2.getText().toString(),skill3.getText().toString()};
                        int preferenceNumber=0;
                        switch (skill2.getId()){
                            case R.id.et_preference_one:
                                preferenceNumber=1;
                                break;
                            case R.id.et_preference_two:
                                preferenceNumber=2;
                                break;
                            case R.id.et_preference_three:
                                preferenceNumber=3;
                                break;
                        }


                        i.putExtra("DataStringArray",dataArray);
                        i.putExtra("PreferenceNumber",preferenceNumber);
                        startActivity(i);
                        finish();
                    }
                    return true;
                }*/


                return false;
            }
        });

        skill3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int left=0,top=1,right=2,bottom=3;
               /* if(event.getAction()==MotionEvent.ACTION_UP){
                    if(event.getRawX()>=(skill3.getRight()-skill3.getCompoundDrawables()[right].getBounds().width())){

                        skill3.setText("");
                    }
                    else{
                        Intent i=new Intent(AsIntern2.this,SelectField2.class);
                        String[] dataArray=new String[]{skill1.getText().toString(),skill2.getText().toString(),skill3.getText().toString()};
                        int preferenceNumber=0;
                        switch (skill3.getId()){
                            case R.id.et_preference_one:
                                preferenceNumber=1;
                                break;
                            case R.id.et_preference_two:
                                preferenceNumber=2;
                                break;
                            case R.id.et_preference_three:
                                preferenceNumber=3;
                                break;
                        }


                        i.putExtra("DataStringArray",dataArray);
                        i.putExtra("PreferenceNumber",preferenceNumber);
                        startActivity(i);
                        finish();
                    }
                    return true;
                }*/


                return false;
            }
        });
    }
    public void goToMain(View view) {

        Intent i=new Intent(AsIntern2.this,Mainscreen.class);
        startActivity(i);
    }

   /* public void goToSelectField(View view) {

        Intent i=new Intent(AsIntern2.this,SelectField.class);
        startActivityForResult(i,100);
    }*/
}
