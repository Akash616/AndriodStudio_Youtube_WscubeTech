package com.sharedprefapp.sharedpreferenceexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Splash screen ka upar ak handler lagana hota hai.
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //shared pref. hamasa system call hota hai - getSharedPreferences()
                //name ka undar key-value store hori hai
                //MODE_PRIVATE - koi or app data read nahi kar paya gi.
                SharedPreferences pref = getSharedPreferences("login", MODE_PRIVATE);
                //values get karni hai
                // false - default value (for first time app open)
                Boolean check = pref.getBoolean("flag", false);

                Intent iNext;
                if(check){ //for True (User is Logged In)
                    iNext = new Intent(MainActivity.this, HomeActivity.class);
                }else { //for false (either First Time or user is Logged out)
                    iNext = new Intent(MainActivity.this, LoginActivity.class);
                }

                startActivity(iNext);

            }
        }, 3000);

    }
}