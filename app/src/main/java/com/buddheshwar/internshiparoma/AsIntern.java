package com.buddheshwar.internshiparoma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

public class AsIntern extends AppCompatActivity {
AutoCompleteTextView ac;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_as_intern);
        ac=findViewById(R.id.actv);
        String[] list=new String[]{"Ms.","Mr.","Mrs."};
        ArrayAdapter adapter=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,list);
        ac.setAdapter(adapter);
        ac.setInputType(0);

        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ac.showDropDown();
            }
        });
    }


    public void goToAsIntern2(View view) {
        startActivity(new Intent(AsIntern.this,AsIntern2.class));
    }
}
