package com.example.listexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
//ListView listView;
Spinner spinner;
AutoCompleteTextView actxtView;
Button btnNext;

int[] arrNo =  new int[]{1,2,3,4,5,6}; //Array - static
//ArrayList<String> arrNames = new ArrayList<>(); //ArrayList initialized - dynamic
ArrayList<String> arrIds =  new ArrayList<>(); //for Spinner
ArrayList<String> arrLanguages = new ArrayList<>(); // for AutoCompleteTextView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ListView
//        listView =  findViewById(R.id.listView);
        //Spinner
        spinner =  findViewById(R.id.spinner);
        //AutoCompleteTextView
        actxtView =  findViewById(R.id.actxtView);
        //Button
        btnNext = findViewById(R.id.btnNext);

//        arrNames.add("Ram");
//        arrNames.add("Sita");
//        arrNames.add("Laxman");
//        arrNames.add("Bharat");
//        arrNames.add("Shatrughan");
//        arrNames.add("Hanuman");
//        arrNames.add("Ram");
//        arrNames.add("Sita");
//        arrNames.add("Laxman");
//        arrNames.add("Bharat");
//        arrNames.add("Shatrughan");
//        arrNames.add("Hanuman");
//        arrNames.add("Ram");
//        arrNames.add("Sita");
//        arrNames.add("Laxman");
//        arrNames.add("Bharat");
//        arrNames.add("Shatrughan");
//        arrNames.add("Hanuman");
//        arrNames.add("Ram");
//        arrNames.add("Sita");
//        arrNames.add("Laxman");
//        arrNames.add("Bharat");
//        arrNames.add("Shatrughan");
//        arrNames.add("Hanuman");
//        arrNames.add("Ram");
//        arrNames.add("Sita");
//        arrNames.add("Laxman");
//        arrNames.add("Bharat");
//        arrNames.add("Shatrughan");
//        arrNames.add("Hanuman");
//        arrNames.add("Ram");
//        arrNames.add("Sita");
//        arrNames.add("Laxman");
//        arrNames.add("Bharat");
//        arrNames.add("Shatrughan");
//        arrNames.add("Hanuman");
//        arrNames.add("Ram");
//        arrNames.add("Sita");
//        arrNames.add("Laxman");
//        arrNames.add("Bharat");
//        arrNames.add("Shatrughan");
//        arrNames.add("Hanuman");
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, arrNames);
//        listView.setAdapter(adapter);
//
//        //List ka item pai click lagana hai.
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                if(position==0){
//                    Toast.makeText(MainActivity.this, "Clicked First Item", Toast.LENGTH_SHORT);
//                }
//            }
//        });

        //Spinner
        arrIds.add("Aadhar Card");
        arrIds.add("Pan Card");
        arrIds.add("Voter ID Card");
        arrIds.add("Driving License Card");
        arrIds.add("Ration Card");
        arrIds.add("Xth Score Card");
        arrIds.add("XIIth Score Card");

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, arrIds);
        spinner.setAdapter(spinnerAdapter);

        //AutoCompleteTextView
        arrLanguages.add("C");
        arrLanguages.add("C++");
        arrLanguages.add("Java");
        arrLanguages.add("PHP");
        arrLanguages.add("C#");
        arrLanguages.add("Kotlin");
        arrLanguages.add("Dart");

        ArrayAdapter<String> actvAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrLanguages);
        actxtView.setAdapter(actvAdapter);
        actxtView.setThreshold(1);// 1 letter ka baad show karega data

        //Button
        Intent iNext = new Intent(getApplicationContext(), SecondActivity.class);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(iNext);
            }
        });

    }
}