package com.buddheshwar.internshiparoma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;

public class SelectCity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    AutoCompleteTextView ac;
    ListView lv;

    String[] dataStringArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_city);
        ac=findViewById(R.id.actv);
        lv=findViewById(R.id.list);
        final String[] list=new String[]{"Agra","Ahmedabad","Allahabad","Amritsar","Aurangabad","Bangalore","Bhopal","Bhubaneswar","Chandigarh","Chennai","Coimbatore","Delhi","Dhanbad","Faridabad","Ghaziabad","Gurgaon","Guwahati","Gwalior","Howrah","Hyderabad"};
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
                Intent i=new Intent(SelectCity.this,EditPreferencesActivity.class);
                //  ListView lv=findViewById(view.getId());
                int preference=extras.getInt("PreferenceNumber");
                String[] newData;
                switch (preference){
                    case 1:
                        newData=new String[]{dataStringArray[0],dataStringArray[1],dataStringArray[2],parent.getItemAtPosition(position).toString(),dataStringArray[4],dataStringArray[5]};
                        break;

                    case 2:
                        newData=new String[]{dataStringArray[0],dataStringArray[1],dataStringArray[2],dataStringArray[3],parent.getItemAtPosition(position).toString(),dataStringArray[5]};
                        break;

                    case 3:
                        newData=new String[]{dataStringArray[0],dataStringArray[1],dataStringArray[2],dataStringArray[3],dataStringArray[4],parent.getItemAtPosition(position).toString()};
                        break;
                    default:
                        newData =dataStringArray;

                }

                i.putExtra("DataStringArray",newData);
                i.putExtra("IsChecked",extras.getBoolean("IsChecked"));
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
        Intent i=new Intent(SelectCity.this,EditPreferencesActivity.class);
        i.putExtra("DataStringArray",dataStringArray);
        i.putExtra("IsChecked",getIntent().getExtras().getBoolean("IsChecked"));
        startActivity(i);
        finish();

    }
}
