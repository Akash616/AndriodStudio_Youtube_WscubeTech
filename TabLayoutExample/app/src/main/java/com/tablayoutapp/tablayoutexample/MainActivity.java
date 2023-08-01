package com.tablayoutapp.tablayoutexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout_one;
    ViewPager viewPager_one;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout_one = findViewById(R.id.tabLayout_one);
        viewPager_one = findViewById(R.id.viewPager_one);

        ViewPagerMessengerAdapter adapter = new ViewPagerMessengerAdapter(getSupportFragmentManager());
        //FragmentManager apko Activity Class mai hi milaga.
        viewPager_one.setAdapter(adapter);

        //TabLayout or ViewPager ko Synchronize karna ka liya
        tabLayout_one.setupWithViewPager(viewPager_one);

    }
}