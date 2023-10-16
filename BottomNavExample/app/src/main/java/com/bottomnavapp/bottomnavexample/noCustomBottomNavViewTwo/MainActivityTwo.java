package com.bottomnavapp.bottomnavexample.noCustomBottomNavViewTwo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.bottomnavapp.bottomnavexample.R;
import com.bottomnavapp.bottomnavexample.noCustomBottomNavViewOne.MyProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivityTwo extends AppCompatActivity {

    BottomNavigationView bNavView_Two;
    FrameLayout frameLayout_Two;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_two);

        frameLayout_Two = findViewById(R.id.frameLayout_Two);
        bNavView_Two = findViewById(R.id.bNavView_Two);

        //jasa hi app open ho by default, My profile item selected aya.
        bNavView_Two.setSelectedItemId(R.id.nav_Person_Two);
        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout_Two, new MyProfileFragment()).commit();

        bNavView_Two.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.nav_Home_two) {
                    loadFragment(new HomeTwoFragment());
                } else if (id == R.id.nav_Person_Two) {
                    loadFragment(new MyProfileTwoFragment());
                } else if (id == R.id.nav_Search_Two) {
                    loadFragment(new SearchTwoFragment());
                } else { //Settings
                    loadFragment(new SettingsTwoFragment());
                }
                return true;
            }
        });
    }

    public void loadFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frameLayout_Two, fragment);
        ft.commit();
    }

}