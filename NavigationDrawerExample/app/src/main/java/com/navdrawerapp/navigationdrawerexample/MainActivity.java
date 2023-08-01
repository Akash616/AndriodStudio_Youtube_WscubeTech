package com.navdrawerapp.navigationdrawerexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.naigationView);
        toolbar = findViewById(R.id.toolbar);

        //Step I
        //Custom Toolbar
        setSupportActionBar(toolbar);

        //Step II
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.OpenDrawer, R.string.CloseDrawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //Step III
        //By Default one fragment load
        loadFrag(new HomeFragment(), true);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                if (id == R.id.optNotes) {
                    loadFrag(new NotesFragment(), false);
                } else if (id == R.id.optHome) {
                    loadFrag(new HomeFragment(), true);
                } else if (id == R.id.optSettings) {
                    loadFrag(new SettingsFragment(), false);
                } else { //optLogout
                    loadFrag(new LogOutFragment(), false);
                }

                //drawer Automatically close after user click any drawer items
                drawerLayout.closeDrawer(GravityCompat.START);

                return true;
            }
        });

    }

    private void loadFrag(Fragment fragment, Boolean flag) {

        //Same steps for, jo aap fragment ko framelayout pai load karna ka leya laga ta ho.
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        if(flag)
            ft.add(R.id.frameLayout_container, fragment);
        else
            ft.replace(R.id.frameLayout_container, fragment);

        ft.commit();

    }

    @Override
    public void onBackPressed() {

        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed(); //activity close/App close
        }

    }
}