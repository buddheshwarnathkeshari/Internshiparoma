package com.buddheshwar.internshiparoma;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.buddheshwar.internshiparoma.fragments.DashboardFragment;
import com.buddheshwar.internshiparoma.fragments.Internships;
import com.buddheshwar.internshiparoma.resume.EditResume;
import com.buddheshwar.internshiparoma.resume.Resume;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class Mainscreen extends AppCompatActivity {

    FrameLayout mainscreenContainer;
    NavigationView navigationDrawerLayout;
    public DrawerLayout drawerLayout;
    ImageView menu;
    LinearLayout actionLayout;
    TextView appTitle;
    Toolbar toolbar;
    BottomNavigationView bottomnavigationview;
    public static boolean resumeFlag = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);
        bottomnavigationview=findViewById(R.id.bottomnav);
        mainscreenContainer=findViewById(R.id.container_mainscreen);
        navigationDrawerLayout=findViewById(R.id.navigation_drawer_view);
        drawerLayout=findViewById(R.id.drawerLayout);
        toolbar=findViewById(R.id.toolbar);
        settoolbar();
        navigationDrawerLayout.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fr;
                switch (menuItem.getItemId()) {
                    case R.id.home_drawer: {
                        fr=new DashboardFragment();
                        openfragment(fr);
                        getSupportActionBar().setTitle("Dashboard");
                        return false;
                    }
                    case R.id.resume_drawer: {
                      /*  fr=new EditResume();
                        if(!resumeFlag){
                            getSupportFragmentManager().beginTransaction().replace(R.id.container_mainscreen,fr).addToBackStack(null).commit();
                            resumeFlag=true;
                        }
                        else{
                            getSupportFragmentManager().beginTransaction().replace(R.id.container_mainscreen,fr).commit();
                        }*/

                        Intent i=new Intent(Mainscreen.this, Resume.class);
                        startActivity(i);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        getSupportActionBar().setTitle("Dashboard");
                        //  appTitle.setText("RESUME");
                        return false;

                    }
                    default: {
                        return false;
                    }

                }
            }
        });
        bottomnavigationview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home_bottom_nav:{
                        Fragment fragment=getSupportFragmentManager().findFragmentById(R.id.container_mainscreen);
                        if(!new DashboardFragment().equals(fragment)){
                            item.setCheckable(true);
                            item.setChecked(true);
                            getSupportActionBar().setTitle("Dashboard");
                            openfragment(new DashboardFragment());
                            return false;
                        }
                    }
                    case R.id.internship_bottom_nav:{
                        item.setCheckable(true);
                        item.setChecked(true);
                        getSupportActionBar().setTitle("Internships");
                        openfragment(new Internships());
                        return false;

                    }
                    case R.id.chat_bottom_nav:{
                        return false;
                    }
                    default:{
                        return false;
                    }
                }
            }
        });
        openfragment(new DashboardFragment());
        getSupportActionBar().setTitle("Dashboard");
        View view=navigationDrawerLayout.getHeaderView(0);
        ImageView closedrawer=view.findViewById(R.id.closedrawer);
        closedrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.closeDrawer(GravityCompat.START);
            }
        });
    }
    public void settoolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_drawer,R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(false);
        toggle.setHomeAsUpIndicator(R.drawable.ic_bar_chart);
        toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);

            }
        });
        toggle.syncState();
    }
    public void openfragment(Fragment fr){
        getSupportFragmentManager().beginTransaction().replace(R.id.container_mainscreen,fr).commit();
        drawerLayout.closeDrawer(GravityCompat.START);
    }

    @Override
    public boolean onSupportNavigateUp() {
        drawerLayout.openDrawer(navigationDrawerLayout,true);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (this.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            Fragment fragment=getSupportFragmentManager().findFragmentById(R.id.container_mainscreen);
            assert fragment != null;
            if (new DashboardFragment().equals(fragment)) {
                ActivityCompat.finishAffinity(this);
            }
            else{
                super.onBackPressed();
            }
        }
        resumeFlag=false;
    }
}
