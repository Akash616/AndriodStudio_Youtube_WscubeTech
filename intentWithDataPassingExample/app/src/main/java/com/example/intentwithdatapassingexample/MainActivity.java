package com.example.intentwithdatapassingexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnNext;

        btnNext = findViewById(R.id.btnNext);

        Intent iNext;
        iNext = new Intent(getApplicationContext(), SecondActivity.class);
        //Bundle(Data) Passing
        iNext.putExtra("title", "HomeScreen"); //(Key, value)
        iNext.putExtra("StudentName", "Akash");
        iNext.putExtra("Roll No", 10);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//              Intent iNext;
//              iNext = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(iNext);
            }
        });

    }
}