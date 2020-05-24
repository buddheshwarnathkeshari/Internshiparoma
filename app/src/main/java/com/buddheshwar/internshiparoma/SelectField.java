package com.buddheshwar.internshiparoma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;

public class SelectField extends AppCompatActivity {

    AutoCompleteTextView ac;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_field);
        ac=findViewById(R.id.actv);
        lv=findViewById(R.id.list);
        String[] list=new String[]{"Architecture","Interior Design","Accounts","Chartered Accountancy(CA)","Animation","Fashion Design","Graphic Design","Merchandise Design","Aerospace Engineering","Android App Development","Biotechnology Engineering", "Chemical Engineering","Civil Engineering","Computer Vision","Electrical Engineering","Electronics Engineering","Energy Science & Engineering","Engineering Physics","Game Development"};
        ArrayAdapter adapter=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,list);
        lv.setAdapter(adapter);
     //   ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>()
        ac.setAdapter(adapter);
        ac.setThreshold(1);
    }
}
