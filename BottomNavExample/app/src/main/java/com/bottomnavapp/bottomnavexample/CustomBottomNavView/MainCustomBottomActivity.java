package com.bottomnavapp.bottomnavexample.CustomBottomNavView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bottomnavapp.bottomnavexample.R;
import com.bottomnavapp.bottomnavexample.noCustomBottomNavViewTwo.SettingsTwoFragment;

public class MainCustomBottomActivity extends AppCompatActivity {

    LinearLayout ll_home, ll_setting, ll_customBottomNav;
    ImageView img_one;
    SearchView searchview_one;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_custom_bottom);

        ll_home = findViewById(R.id.ll_home);
        ll_setting = findViewById(R.id.ll_setting);
        searchview_one = findViewById(R.id.searchview_one);
        ll_customBottomNav = findViewById(R.id.ll_customBottomNav);
        img_one = findViewById(R.id.img_one);

        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout_custom, new SettingsTwoFragment()).commit();

        ll_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new HomeCustomFragment());
            }
        });

        ll_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new SettingCustomFragment());
            }
        });

    }

    private void loadFragment(Fragment fragment) {

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frameLayout_custom, fragment);
        ft.commit();

    }


    public void fabIconClicked(View view) {
        Toast.makeText(this, "Floating Action Button Clicked..", Toast.LENGTH_SHORT).show();
        searchview_one.requestFocus();
    }
}