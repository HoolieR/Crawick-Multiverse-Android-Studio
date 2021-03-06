package com.example.work.crawickmultiverse;

//import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
//import android.app.FragmentManager;
//import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.ContentFrameLayout;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView mMainNav;
    private FrameLayout mContentFrame;
    private HomeFragment homeFragment;
    private InfoFragment infoFragment;
    private GpsFragment gpsFragment;
    private SettingsFragment settingsFragment;
    private FirstBurgerFragment firstBurgerFragment;
    private SecondBurgerFragment secondBurgerFragment;
    private ThirdBurgerFragment thirdBurgerFragment;
    private SurveyBurgerFragment surveyBurgerFragment;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);






        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mContentFrame = (FrameLayout) findViewById(R.id.content_frame);
        mMainNav = (BottomNavigationView) findViewById(R.id.nav_main);

        homeFragment = new HomeFragment();
        infoFragment = new InfoFragment();
        gpsFragment = new GpsFragment();
        settingsFragment = new SettingsFragment();
        setFragment(homeFragment);

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) { //This is the code for the Bottom Navigation Bar.

                switch (item.getItemId()) {
                    case R.id.nav_home :
                        mMainNav.setItemBackgroundResource(R.color.colorWhite);
                        setFragment(homeFragment);
                        return true;
                    case R.id.nav_info :
                        mMainNav.setItemBackgroundResource(R.color.colorWhite);
                        setFragment(infoFragment);
                        return true;

                    case R.id.nav_gps :
                        mMainNav.setItemBackgroundResource(R.color.colorWhite);
                        setFragment(gpsFragment);
                        return true;

                    case R.id.nav_settings :
                        mMainNav.setItemBackgroundResource(R.color.colorWhite);
                        setFragment(settingsFragment);
                        return true;
                        default:
                            return false;
                }
            }
        });



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void setFragment (Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        firstBurgerFragment = new FirstBurgerFragment();
        secondBurgerFragment = new SecondBurgerFragment();
        thirdBurgerFragment = new ThirdBurgerFragment();
        surveyBurgerFragment = new SurveyBurgerFragment();


        if (id == R.id.nav_first_layout) { //This is the code for the Hamburger Menu
            setFragment(firstBurgerFragment);
        } else if (id == R.id.nav_third_layout) {
          setFragment(thirdBurgerFragment);
        } else if (id == R.id.nav_share) {
            setFragment(surveyBurgerFragment);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
