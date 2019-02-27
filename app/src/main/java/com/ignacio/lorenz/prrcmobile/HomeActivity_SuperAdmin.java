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

public class HomeActivity_SuperAdmin extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer_super_admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.side_bar_super_admin);

        Toolbar toolbar = findViewById(R.id.toolbar_super_admin);
        setSupportActionBar(toolbar);

        drawer_super_admin = findViewById(R.id.drawer_layout_super_admin);
        NavigationView navigationView = findViewById(R.id.nav_view_super_admin);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer_super_admin, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer_super_admin.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_super_admin,
                    new AllDocument()).commit();
            navigationView.setCheckedItem(R.id.nav_AllDocu_Super_Admin);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_AllDocu_Super_Admin:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_super_admin,
                        new AllDocument()).commit();
                break;

            case R.id.nav_MyDocu_Super_Admin:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_super_admin,
                        new MyDocument()).commit();
                break;

            case R.id.nav_InTran_Super_Admin:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_super_admin,
                        new InTransit()).commit();
                break;

            case R.id.nav_Archive_Super_Admin:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_super_admin,
                        new Archive()).commit();
                break;

            case R.id.nav_ScanQR_Super_Admin:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_super_admin,
                        new ScanQR()).commit();
                break;

            case R.id.nav_About_Super_Admin:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_super_admin,
                        new About()).commit();
                break;

            case R.id.nav_Logout_Super_Admin:
                Toast.makeText(this, "Logged out!", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this, Login.class);
                startActivity(i);
                break;
        }

        drawer_super_admin.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer_super_admin.isDrawerOpen(GravityCompat.START)) {
            drawer_super_admin.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}









