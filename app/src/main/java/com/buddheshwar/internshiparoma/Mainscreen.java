package com.buddheshwar.internshiparoma;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.buddheshwar.internshiparoma.fragments.DashboardFragment;
import com.buddheshwar.internshiparoma.resume.EditResume;
import com.google.android.material.navigation.NavigationView;

public class Mainscreen extends AppCompatActivity {

    FrameLayout mainscreenContainer;
    NavigationView navigationDrawerLayout;
    public DrawerLayout drawerLayout;
    ImageView menu;
    LinearLayout actionLayout;
    TextView appTitle;
    public static boolean resumeFlag = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);

        mainscreenContainer=findViewById(R.id.container_mainscreen);
        navigationDrawerLayout=findViewById(R.id.navigation_drawer_view);
        drawerLayout=findViewById(R.id.drawerLayout);
        actionLayout=findViewById(R.id.actionLayout);
        menu=actionLayout.findViewById(R.id.menu_img);
        appTitle=actionLayout.findViewById(R.id.app_title);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        navigationDrawerLayout.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fr;
                switch (menuItem.getItemId()) {
                    case R.id.home_drawer: {
                        fr=new DashboardFragment();
                        openhome(fr);
                        return false;
                    }
                    case R.id.resume_drawer: {
                        fr=new EditResume();
                        if(!resumeFlag){
                            getSupportFragmentManager().beginTransaction().replace(R.id.container_mainscreen,fr).addToBackStack(null).commit();
                            resumeFlag=true;
                        }
                        else{
                            getSupportFragmentManager().beginTransaction().replace(R.id.container_mainscreen,fr).commit();
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        appTitle.setText("RESUME");

                        return false;

                    }
                    default: {
                        return false;
                    }

                }
            }
        });
        openhome(new DashboardFragment());
        View view=navigationDrawerLayout.getHeaderView(0);
        ImageView closedrawer=view.findViewById(R.id.closedrawer);
        closedrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.closeDrawer(GravityCompat.START);
            }
        });
    }
    public void openhome(Fragment fr){
        if(!resumeFlag){
            getSupportFragmentManager().beginTransaction().replace(R.id.container_mainscreen,fr).addToBackStack(null).commit();
            resumeFlag=true;
        }
        else{
            getSupportFragmentManager().beginTransaction().replace(R.id.container_mainscreen,fr).commit();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        appTitle.setText("Dashboard");

    }

    @Override
    public void onBackPressed() {
        if (this.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
        resumeFlag=false;
    }
}
