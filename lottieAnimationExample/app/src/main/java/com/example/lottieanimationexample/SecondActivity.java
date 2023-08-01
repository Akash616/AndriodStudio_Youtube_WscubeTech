package com.example.lottieanimationexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;

public class SecondActivity extends AppCompatActivity {

    Button btnPlay;
    LottieAnimationView laView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        /* Java ka through animation set karna
           button click, onCreate, event pai karna hai.
          laView =  findViewById(R.id.lottieAnimationID);
          laView.setAnimation(R.raw.lottie);
          laView.playAnimation();
          laView.loop(true);
          */
        btnPlay =  findViewById(R.id.btnPlay);
        laView = findViewById(R.id.lottieShop);
        laView.setAnimation(R.raw.lottie1);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                laView.playAnimation();
                laView.loop(true);
            }
        });

    }
}