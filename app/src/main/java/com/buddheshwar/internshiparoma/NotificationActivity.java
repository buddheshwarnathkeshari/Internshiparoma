package com.buddheshwar.internshiparoma;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.buddheshwar.internshiparoma.adapters.NotificationsAdapter;
import com.buddheshwar.internshiparoma.model.NotificationData;

import java.util.ArrayList;
import java.util.Objects;

public class NotificationActivity extends AppCompatActivity {
    RecyclerView mrecyclerview;
    LinearLayoutManager linearLayoutManager;
    NotificationsAdapter madapter;
    ArrayList<NotificationData> marraylist;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        mrecyclerview=findViewById(R.id.notificationrecyclerview);
        linearLayoutManager=new LinearLayoutManager(this);
        marraylist=new ArrayList<NotificationData>();

            getSupportActionBar().setTitle("Notifications");
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:{
                super.onBackPressed();
            }
        }
        return super.onOptionsItemSelected(item);
    }


}
