package com.buddheshwar.internshiparoma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Toast;

public class SelectField2 extends AppCompatActivity implements AdapterView.OnItemClickListener {

    // @Override
    //public void onBackPressed
    AutoCompleteTextView ac;
    ListView lv;
    String[] list;
    String[] dataStringArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_field2);
        ac=findViewById(R.id.actv);
        lv=findViewById(R.id.list);
        list=new String[]{"Architecture","Interior Design","Accounts","Chartered Accountancy(CA)","Animation","Fashion Design","Graphic Design","Merchandise Design","Aerospace Engineering","Android App Development","Biotechnology Engineering", "Chemical Engineering","Civil Engineering","Computer Vision","Electrical Engineering","Electronics Engineering","Energy Science & Engineering","Engineering Physics","Game Development"};
        ArrayAdapter adapter=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,list);
        lv.setAdapter(adapter);
        //   ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>()
        ac.setAdapter(adapter);
        ac.setThreshold(1);




        final Bundle extras=getIntent().getExtras();
        dataStringArray=extras.getStringArray("DataStringArray");

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Toast.makeText(getApplicationContext(),list[position].toString(),Toast.LENGTH_SHORT).show();
                Intent i=new Intent(SelectField2.this,AsIntern.class);
                //  ListView lv=findViewById(view.getId());
                int preference=extras.getInt("PreferenceNumber");
                String[] newData;
                switch (preference){
                    case 1:
                        newData=new String[]{parent.getItemAtPosition(position).toString(),dataStringArray[1],dataStringArray[2]};
                        break;

                    case 2:
                        newData=new String[]{dataStringArray[0],parent.getItemAtPosition(position).toString(),dataStringArray[2]};
                        break;

                    case 3:
                        newData=new String[]{dataStringArray[0],dataStringArray[1],parent.getItemAtPosition(position).toString()};
                        break;
                    default:
                        newData =dataStringArray;

                }

                i.putExtra("DataStringArray",newData);
                startActivity(i);
                finish();

            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
    @Override
    public void onBackPressed(){
        Intent i=new Intent(SelectField2.this,AsIntern.class);
        i.putExtra("DataStringArray",dataStringArray);
        startActivity(i);
        finish();
    }


}
