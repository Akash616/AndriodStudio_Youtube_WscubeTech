package com.example.bmiexample;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //this line connect .xml file
        //after executing this line we can access .xml things.

        EditText edtWeight, edtHeightFt, edtHeightIn;
        Button btnCalculate; //variable and object
        TextView txtResult;
        LinearLayout llMain;

        edtWeight = findViewById(R.id.edtWeight);
        edtHeightFt = findViewById(R.id.edtHeightFt);
        edtHeightIn = findViewById(R.id.edtHeightIn);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtResult = findViewById(R.id.txtResult);
        llMain = findViewById(R.id.llMain);

        //OnClickListener - is a Interface
        btnCalculate.setOnClickListener(new View.OnClickListener() { //new object
            @Override
            public void onClick(View v) {
                //taking values from EditText
                int wt = Integer.parseInt(edtWeight.getText().toString()); //typeCasting
                int ft = Integer.parseInt(edtHeightFt.getText().toString());
                int in = Integer.parseInt(edtHeightIn.getText().toString());

                /*BMI formula - weight/height
                * weight/square of height
                * SI unit - kg/meter square .
                * User know height in feet and inches,
                * so, First feet and inches convert in (inches), then inches convert in (centimeter),
                * and Last centimeter convert in (meter). */

                int totalIn = ft * 12 + in; /* FOR EX- height is 6(ft) 1(in)
                 6*12=72+1=73(inches)*/
                double totalCm = totalIn * 2.53; //(centimeter)
                double totalM = totalCm / 100; //(meter)

                //Now total Height stored in totalM variable.
                double bmi = wt / (totalM * totalM);

                //COMMON BMI
                if(bmi > 25){
                    txtResult.setText("You're Overweight!");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorOw)); //background color
                }else if(bmi < 18){
                    txtResult.setText("You're Underweight!");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorUw));
                }else{
                    txtResult.setText("You're Healthy!");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorH));
                }
            }
        });

    }
}