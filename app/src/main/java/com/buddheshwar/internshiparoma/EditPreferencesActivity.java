package com.buddheshwar.internshiparoma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class EditPreferencesActivity extends AppCompatActivity {

    EditText skill1,skill2,skill3,city1,city2,city3;
    private LinearLayout llCity;
    private CheckBox cb1;
    boolean isChecked;
    String[] dataStringArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_preferences);

        skill1=findViewById(R.id.et_skill_preference_one);
        skill2=findViewById(R.id.et_skill_preference_two);
        skill3=findViewById(R.id.et_skill_reference_three);

        city1=findViewById(R.id.et_city_preference_1);
        city2=findViewById(R.id.et_city_preference_2);
        city3=findViewById(R.id.et_city_preference_3);


        Bundle extras=getIntent().getExtras();
        dataStringArray=extras.getStringArray("DataStringArray");
        isChecked=extras.getBoolean("IsChecked");


        skill1.setText(dataStringArray[0]);
        skill2.setText(dataStringArray[1]);
        skill3.setText(dataStringArray[2]);

        city1.setText(dataStringArray[3]);
        city2.setText(dataStringArray[4]);
        city3.setText(dataStringArray[5]);

        cb1=findViewById(R.id.cb);
        llCity=findViewById(R.id.ll_cities);

        if(isChecked){
            cb1.setChecked(true);
            llCity.setVisibility(View.VISIBLE);

        }
        else{
            cb1.setChecked(false);
            llCity.setVisibility(View.GONE);
        }

        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    llCity.setVisibility(View.VISIBLE);

                }
                else{
                    llCity.setVisibility(View.GONE);
                }
            }
        });




        skill1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int left=0,top=1,right=2,bottom=3;
                if(event.getAction()==MotionEvent.ACTION_UP){
                    if(event.getRawX()>=(skill1.getRight()-skill1.getCompoundDrawables()[right].getBounds().width())){

                        skill1.setText("");
                    }
                    else{
                        Intent i=new Intent(EditPreferencesActivity.this,SelectField.class);
                        String[] dataArray=new String[]{skill1.getText().toString(),skill2.getText().toString(),skill3.getText().toString(),city1.getText().toString(),city2.getText().toString(),city3.getText().toString()};
                        int preferenceNumber=0;
                        switch (skill1.getId()){
                            case R.id.et_skill_preference_one:
                                preferenceNumber=1;
                                break;
                            case R.id.et_skill_preference_two:
                                preferenceNumber=2;
                                break;
                            case R.id.et_skill_reference_three:
                                preferenceNumber=3;
                                break;
                        }


                        i.putExtra("DataStringArray",dataArray);
                        i.putExtra("PreferenceNumber",preferenceNumber);
                        i.putExtra("IsChecked", cb1.isChecked());
                        startActivity(i);
                        finish();
                    }
                    return true;
                }


                return false;
            }
        });

        skill2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int left=0,top=1,right=2,bottom=3;
                if(event.getAction()==MotionEvent.ACTION_UP){
                    if(event.getRawX()>=(skill2.getRight()-skill2.getCompoundDrawables()[right].getBounds().width())){

                        skill2.setText("");
                    }
                    else{
                        Intent i=new Intent(EditPreferencesActivity.this,SelectField.class);
                        String[] dataArray=new String[]{skill1.getText().toString(),skill2.getText().toString(),skill3.getText().toString(),city1.getText().toString(),city2.getText().toString(),city3.getText().toString()};
                        int preferenceNumber=0;
                        switch (skill2.getId()){
                            case R.id.et_skill_preference_one:
                                preferenceNumber=1;
                                break;
                            case R.id.et_skill_preference_two:
                                preferenceNumber=2;
                                break;
                            case R.id.et_skill_reference_three:
                                preferenceNumber=3;
                                break;
                        }


                        i.putExtra("DataStringArray",dataArray);
                        i.putExtra("PreferenceNumber",preferenceNumber);
                        i.putExtra("IsChecked", cb1.isChecked());
                        startActivity(i);
                        finish();
                    }
                    return true;
                }


                return false;
            }
        });

        skill3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int left=0,top=1,right=2,bottom=3;
                if(event.getAction()==MotionEvent.ACTION_UP){
                    if(event.getRawX()>=(skill3.getRight()-skill3.getCompoundDrawables()[right].getBounds().width())){

                        skill3.setText("");
                    }
                    else{
                        Intent i=new Intent(EditPreferencesActivity.this,SelectField.class);
                        String[] dataArray=new String[]{skill1.getText().toString(),skill2.getText().toString(),skill3.getText().toString(),city1.getText().toString(),city2.getText().toString(),city3.getText().toString()};
                        int preferenceNumber=0;
                        switch (skill3.getId()){
                            case R.id.et_skill_preference_one:
                                preferenceNumber=1;
                                break;
                            case R.id.et_skill_preference_two:
                                preferenceNumber=2;
                                break;
                            case R.id.et_skill_reference_three:
                                preferenceNumber=3;
                                break;
                        }


                        i.putExtra("DataStringArray",dataArray);
                        i.putExtra("PreferenceNumber",preferenceNumber);
                        i.putExtra("IsChecked", cb1.isChecked());
                        startActivity(i);
                        finish();
                    }
                    return true;
                }


                return false;
            }
        });


        city1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int left=0,top=1,right=2,bottom=3;
                if(event.getAction()==MotionEvent.ACTION_UP){
                    if(event.getRawX()>=(city1.getRight()-city1.getCompoundDrawables()[right].getBounds().width())){

                        city1.setText("");
                    }
                    else{
                        Intent i=new Intent(EditPreferencesActivity.this,SelectCity.class);
                        String[] dataArray=new String[]{skill1.getText().toString(),skill2.getText().toString(),skill3.getText().toString(),city1.getText().toString(),city2.getText().toString(),city3.getText().toString()};
                        int preferenceNumber=0;
                        switch (city1.getId()){
                            case R.id.et_city_preference_1:
                                preferenceNumber=1;
                                break;
                            case R.id.et_city_preference_2:
                                preferenceNumber=2;
                                break;
                            case R.id.et_city_preference_3:
                                preferenceNumber=3;
                                break;
                        }
                        i.putExtra("DataStringArray",dataArray);
                        i.putExtra("PreferenceNumber",preferenceNumber);

                        i.putExtra("IsChecked", cb1.isChecked());
                        startActivity(i);
                        finish();
                    }

                    return true;
                }


                return false;
            }
        });


        city2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int left=0,top=1,right=2,bottom=3;
                if(event.getAction()==MotionEvent.ACTION_UP){
                    if(event.getRawX()>=(city2.getRight()-city2.getCompoundDrawables()[right].getBounds().width())){

                        city2.setText("");
                    }
                    else{
                        Intent i=new Intent(EditPreferencesActivity.this,SelectCity.class);
                        String[] dataArray=new String[]{skill1.getText().toString(),skill2.getText().toString(),skill3.getText().toString(),city1.getText().toString(),city2.getText().toString(),city3.getText().toString()};
                        int preferenceNumber=0;
                        switch (city2.getId()){
                            case R.id.et_city_preference_1:
                                preferenceNumber=1;
                                break;
                            case R.id.et_city_preference_2:
                                preferenceNumber=2;
                                break;
                            case R.id.et_city_preference_3:
                                preferenceNumber=3;
                                break;
                        }
                        i.putExtra("DataStringArray",dataArray);
                        i.putExtra("PreferenceNumber",preferenceNumber);

                        i.putExtra("IsChecked", cb1.isChecked());
                        startActivity(i);
                        finish();
                    }
                    return true;
                }


                return false;
            }
        });

        city3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int left=0,top=1,right=2,bottom=3;
                if(event.getAction()==MotionEvent.ACTION_UP){
                    if(event.getRawX()>=(city3.getRight()-city3.getCompoundDrawables()[right].getBounds().width())){

                        city3.setText("");
                    }
                    else{
                        Intent i=new Intent(EditPreferencesActivity.this,SelectCity.class);
                        String[] dataArray=new String[]{skill1.getText().toString(),skill2.getText().toString(),skill3.getText().toString(),city1.getText().toString(),city2.getText().toString(),city3.getText().toString()};
                        int preferenceNumber=0;
                        switch (city3.getId()){
                            case R.id.et_city_preference_1:
                                preferenceNumber=1;
                                break;
                            case R.id.et_city_preference_2:
                                preferenceNumber=2;
                                break;
                            case R.id.et_city_preference_3:
                                preferenceNumber=3;
                                break;
                        }
                        i.putExtra("DataStringArray",dataArray);
                        i.putExtra("PreferenceNumber",preferenceNumber);

                        i.putExtra("IsChecked", cb1.isChecked());
                        startActivity(i);
                        finish();
                    }
                    return true;
                }


                return false;
            }
        });







    }

    public void goToMain(View view) {

        Intent i=new Intent(EditPreferencesActivity.this,Mainscreen.class);
        startActivity(i);
    }


    public void goToSelectField(View view) {




    }

    public void goToSelectCity(View view) {


    }

    @Override
    public void onBackPressed(){
        startActivity(new Intent(EditPreferencesActivity.this,Mainscreen.class));
        finish();
    }

}
