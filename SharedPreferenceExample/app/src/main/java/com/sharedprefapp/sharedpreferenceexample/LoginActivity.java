package com.sharedprefapp.sharedpreferenceexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Code for verification
                // User name and password is correct

                //SharedPreference call
                SharedPreferences pref = getSharedPreferences("login", MODE_PRIVATE);
                //insert value - Editor
                SharedPreferences.Editor editor = pref.edit();
                editor.putBoolean("flag", true);
                editor.apply(); //commit

                Intent iHome = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(iHome);

            }
        });

    }
}