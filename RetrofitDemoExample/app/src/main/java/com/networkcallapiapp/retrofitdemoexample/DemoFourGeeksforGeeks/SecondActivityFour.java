package com.networkcallapiapp.retrofitdemoexample.DemoFourGeeksforGeeks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.networkcallapiapp.retrofitdemoexample.R;

public class SecondActivityFour extends AppCompatActivity {

    TextView idTvResponseTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_four);

        idTvResponseTwo = findViewById(R.id.idTvResponseTwo);

        Bundle bundle = getIntent().getExtras();

        if(bundle!=null){
            String data = bundle.getString("Data");
            String data2 = bundle.getString("Data2");
            idTvResponseTwo.setText(data+"\nNAME : "+data2);
        }

    }
}