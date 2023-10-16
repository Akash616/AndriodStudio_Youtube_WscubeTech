package com.toolbaroractionbarorappbar.customtoolbarexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);

        //Step 1
        setSupportActionBar(toolbar); //androidx.appcompat.widget.Toolbar
        //setActionBar(toolbar); //android.widget

        //Step 2 By default toolbar options
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true); //set arrow/back button
            getSupportActionBar().setTitle("My Toolbar"); //now it become high priority
        }

        //toolbar.setTitle("My Toolbar"); problem does not show - bec. of priority
        toolbar.setSubtitle("Sub Title");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.opt_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.opt_new) {
            Toast.makeText(this, "Created new file.", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.opt_open) {
            Toast.makeText(this, "File Open.", Toast.LENGTH_SHORT).show();
        } else if (itemId == android.R.id.home) {
            //Back(<-) button comes under option menu
            super.onBackPressed();
        } else {
            Toast.makeText(this, "File Saved.", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
}