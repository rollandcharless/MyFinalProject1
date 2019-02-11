package com.ignacio.lorenz.prrcmobile;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_side_bar);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new AllDocument()).commit();
            navigationView.setCheckedItem(R.id.nav_AllDocu);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_AllDocu:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AllDocument()).commit();
                break;

            case R.id.nav_MyDocu:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new MyDocument()).commit();
                break;

            case R.id.nav_InTran:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new InTransit()).commit();
                break;

            case R.id.nav_Archive:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Archive()).commit();
                break;

            case R.id.nav_ManUse:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ManageUser()).commit();
                break;

            case R.id.nav_About:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new About()).commit();
                break;

            case R.id.nav_Logout:
                Toast.makeText(this, "Logged out!", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this, Login.class);
                startActivity(i);
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}






