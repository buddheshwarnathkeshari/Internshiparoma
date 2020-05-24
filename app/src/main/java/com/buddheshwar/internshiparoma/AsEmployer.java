package com.buddheshwar.internshiparoma;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AsEmployer extends AppCompatActivity {
    ViewFlipper vf;
    View v1,v2,v3,v4;
    int viewNumber;
    EditText etAbout,etStartDate,etLastDateToApply;
    AutoCompleteTextView ac;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_as_employer);

        viewNumber=1;
        v1=findViewById(R.id.v1);
        v2=findViewById(R.id.v2);
        v3=findViewById(R.id.v3);
        v4=findViewById(R.id.v4);
        vf=findViewById(R.id.vf_details);



        etStartDate=findViewById(R.id.et_start_date);
        etLastDateToApply=findViewById(R.id.et_last_date_to_apply);
        etAbout=findViewById(R.id.et_about);
        final TextView tvcount=findViewById(R.id.counter);



        ac=findViewById(R.id.actv);
        String[] list=new String[]{"Day.","Week","Month"};
        ArrayAdapter adapter=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,list);
        ac.setAdapter(adapter);
        ac.setInputType(0);

        ac.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus)
                    ac.showDropDown();
            }
        });

        etStartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar myCalendar=Calendar.getInstance();
                DatePickerDialog.OnDateSetListener date=new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        myCalendar.set(Calendar.YEAR,year);
                        myCalendar.set(Calendar.MONTH,month);
                        myCalendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                        SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yy", Locale.US);

                        etStartDate.setText(sdf.format(myCalendar.getTime()));


                    }
                };

            }
        });




        etAbout.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                    tvcount.setText(""+etAbout.getText().length()+"/250");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }


    public void flip(View view) {

        vf.showNext();

        viewNumber++;
        switch(viewNumber){
            case 1:
                v1.setBackgroundResource(R.drawable.round);
                v2.setBackgroundResource(R.drawable.round2);
                v3.setBackgroundResource(R.drawable.round2);
                break;
            case 2:

                v1.setBackgroundResource(R.drawable.round2);
                v2.setBackgroundResource(R.drawable.round);
                v3.setBackgroundResource(R.drawable.round2);
                break;
            case 3:

                v1.setBackgroundResource(R.drawable.round2);
                v2.setBackgroundResource(R.drawable.round2);
                v3.setBackgroundResource(R.drawable.round);
                break;
        }


    }
}
