package com.example.intentwithdatapassingexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // receive/fetch Data
        Intent fromAct = getIntent();
        String title = fromAct.getStringExtra("title"); //defaultValue by default= ""
        String studentName = fromAct.getStringExtra("StudentName");
        int rollNo = fromAct.getIntExtra("Roll No", 0); //no default value by default

        TextView txtStudentInfo;
        txtStudentInfo = findViewById(R.id.txtStudentInfo);

        txtStudentInfo.setText("RollNo: "+rollNo+", Name: "+studentName);

        //Toolbar - activity(screen) ka toolbar heading/title change karna hai
        //getSupportActionBar().setTitle(title);

    }
}