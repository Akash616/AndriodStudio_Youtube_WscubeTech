package com.example.lottieanimationexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    LottieAnimationView laView;
    Button btnNextPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Java ka through animation set karna
           button click, onCreate, event pai karna hai.
          laView =  findViewById(R.id.lottieAnimationID);
          laView.setAnimation(R.raw.lottie);
          laView.playAnimation();
          laView.loop(true);
          */

        btnNextPage =  findViewById(R.id.btnNextPage);
        btnNextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iNext = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(iNext);
            }
        });

    }
}