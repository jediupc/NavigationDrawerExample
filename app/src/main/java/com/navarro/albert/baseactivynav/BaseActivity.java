package com.navarro.albert.baseactivynav;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;
import com.navarro.albert.baseactivynav.activities.Activity1;
import com.navarro.albert.baseactivynav.activities.Activity2;
import com.navarro.albert.baseactivynav.activities.Activity3;

public class BaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public static final int ACTIVITY_1 = 1;
    public static final int ACTIVITY_2 = 2;
    public static final int ACTIVITY_3 = 3;
    private NavigationView navigationView;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_base);
        setView();
    }

    protected void setView() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
   public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id){
            case R.id.activity1:
                startActivity(new Intent(getApplicationContext(),Activity1.class));
                break;
            case R.id.activity2:
                startActivity(new Intent(getApplicationContext(),Activity2.class));
                break;
            case R.id.activity3:
                startActivity(new Intent(getApplicationContext(),Activity3.class));
                break;
        }


        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void setContentView(int layoutResID) {

        DrawerLayout fullLayout = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_base, null);
        FrameLayout frameLayout = (FrameLayout) fullLayout.findViewById(R.id.frame_layout_base);

        getLayoutInflater().inflate(layoutResID, frameLayout, true);


        super.setContentView(fullLayout);
        setView();
    }

    public void checkMenuItem(int activity) {
        if (activity == ACTIVITY_1) navigationView.setCheckedItem(R.id.activity1);
        if (activity == ACTIVITY_2) navigationView.setCheckedItem(R.id.activity2);
        if (activity == ACTIVITY_3) navigationView.setCheckedItem(R.id.activity3);
    }

}
