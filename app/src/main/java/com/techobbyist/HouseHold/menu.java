package com.techobbyist.HouseHold;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import static com.techobbyist.HouseHold.R.id.container;

public class  menu extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private static final String TAG = "MainActivity";

    private SectionsPageAdapter mSectionsPageAdapter;
    private Tab1Fragment fragment1;
    private Tab2Fragment fragment2;
    private Tab3Fragment fragment3;


    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Log.d(TAG, "onCreate: Starting.");

        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    private void setupViewPager(ViewPager viewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());

        fragment1 = new Tab1Fragment();
        fragment2 = new Tab2Fragment();

        fragment3 = new Tab3Fragment();


        adapter.addFragment(fragment1, "Shopping");
        adapter.addFragment(fragment2, "Tasks");
        adapter.addFragment(fragment3, "People");
        viewPager.setAdapter(adapter);
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
        getMenuInflater().inflate(R.menu.menu, menu);
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
            startActivity(new Intent(menu.this,LogoutActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

   @SuppressWarnings("StatementWithEmptyBody")

   public void onTabsClick(View view) {
       fragment2.onTabsClick(view);
}

   public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.People) {
            startActivity(new Intent(this,menu.class));
        } else if (id == R.id.ShoppingList) {
            startActivity(new Intent(this,menu.class));

        } else if (id == R.id.TasksList) {
            startActivity(new Intent(this,menu.class));

        } else if (id == R.id.Settings) {
            startActivity(new Intent(menu.this,LogoutActivity.class));

        } else if (id == R.id.Schedule) {
            openCalendar();

        } else if (id == R.id.help) {
            startActivity(new Intent(menu.this,gethelp.class));
        } else if (id == R.id.contact) {
            startActivity(new Intent(menu.this,contactus.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void openCalendar(){
        Intent opencalendarmap = getPackageManager().getLaunchIntentForPackage("com.android.calendar");
        startActivity(opencalendarmap);
    }
}