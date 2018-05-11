package com.example.jeslin.ida;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.jeslin.ida.AdaptersAndClasses.OnFragmentInteractionListener;
import com.example.jeslin.ida.ViewPages.ContactView;

public class HomePage extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,OnFragmentInteractionListener {
    MenuItem menuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Fragment HomeFragment=Home.newInstance();

        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.maincontainer,HomeFragment);
        ft.commit();

    }
    public void exec_members(View v)
    {
        Fragment execmem=Execmember.newInstance();
        replacefrag(execmem);
    }

    public void newsclick(View v)
    {
        Fragment newsfrag=NewsandEvents.newInstance();
        replacefrag(newsfrag);
    }


    public void notification_click(View v)
    {
        Intent intent=new Intent(getApplicationContext(),NotificationList.class);
        startActivity(intent);
    }

    private void replacefrag(Fragment fragment){
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.addToBackStack(null);
        ft.replace(R.id.maincontainer,fragment);
        ft.commit();
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
//        getMenuInflater().inflate(R.menu.menu, menu);
////         Retrieve the SearchView and plug it into SearchManager
//        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
//        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
//        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));


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

        if (id == R.id.exe_members) {

//            menuItem.setVisible(true);
            Fragment Exememberfrag=Execmember.newInstance();
            replacefrag(Exememberfrag);
            // Handle the camera action
        } else if (id == R.id.members) {

        } else if (id == R.id.profile) {

            Intent intent=new Intent(getApplicationContext(),Profile.class);
            startActivity(intent);

        } else if (id == R.id.events) {
            Fragment NewsFragment=NewsandEvents.newInstance();
            replacefrag(NewsFragment);

        } else if (id == R.id.gallery) {

        } else if (id == R.id.notification) {
            Intent intent=new Intent(getApplicationContext(),NotificationList.class);
            startActivity(intent);

        }else if (id == R.id.contacts) {
            Intent intent=new Intent(getApplicationContext(),ContactView.class);
            startActivity(intent);

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(String str) {
        setTitle(str);
    }
}
