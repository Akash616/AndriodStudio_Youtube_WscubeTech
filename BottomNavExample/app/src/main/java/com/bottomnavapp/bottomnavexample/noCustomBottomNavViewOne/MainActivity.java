package com.bottomnavapp.bottomnavexample.noCustomBottomNavViewOne;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.bottomnavapp.bottomnavexample.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bNavView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bNavView = findViewById(R.id.bNavView_one);

        //Select karna - jab apka pass limited option hai.
        //click karna - jab unlimited option hai.
//        bNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override       -> Deprecated
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                return false;
//            }
//        });
        bNavView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //MenuItem -> id
                int id = item.getItemId();

                if (id==R.id.nav_Home){

                    //Load Fragment in FrameLayout
//                    FragmentManager fm = getSupportFragmentManager();
//                    FragmentTransaction ft = fm.beginTransaction();
//                    ft.add(R.id.nav_Home, new HomeFragment());
//                    ft.commit();
                    loadFrag(new HomeFragment(), false);

                } else if (id==R.id.nav_Search) {

                    loadFrag(new SearchFragment(), false);

                } else if (id==R.id.nav_Utilities) {

                    loadFrag(new UtilitiesFragment(), false);

                } else if (id==R.id.nav_Contact) {

                    loadFrag(new ContactUsFragment(), false);

                }else { //profile

                    loadFrag(new MyProfileFragment(), true);

                }

                return true;
            }
        });

        //jasa hi app open ho by default, My profile item selected aya.
        bNavView.setSelectedItemId(R.id.nav_Profile);

    }

    public  void loadFrag(Fragment fragment, boolean flag){
        //Load Fragment in FrameLayout
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        if(flag)
            ft.add(R.id.frameLayout_demo, fragment); //.add() -> overlapping
        else
            ft.replace(R.id.frameLayout_demo, fragment);

        ft.commit();
    }

}