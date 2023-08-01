package com.example.listexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> arrNames = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        listView =  findViewById(R.id.listView);
        arrNames.add("Ram");
        arrNames.add("Sita");
        arrNames.add("Laxman");
        arrNames.add("Bharat");
        arrNames.add("Shatrughan");
        arrNames.add("Hanuman");
        arrNames.add("Ram");
        arrNames.add("Sita");
        arrNames.add("Laxman");
        arrNames.add("Bharat");
        arrNames.add("Shatrughan");
        arrNames.add("Hanuman");
        arrNames.add("Ram");
        arrNames.add("Sita");
        arrNames.add("Laxman");
        arrNames.add("Bharat");
        arrNames.add("Shatrughan");
        arrNames.add("Hanuman");
        arrNames.add("Ram");
        arrNames.add("Sita");
        arrNames.add("Laxman");
        arrNames.add("Bharat");
        arrNames.add("Shatrughan");
        arrNames.add("Hanuman");
        arrNames.add("Ram");
        arrNames.add("Sita");
        arrNames.add("Laxman");
        arrNames.add("Bharat");
        arrNames.add("Shatrughan");
        arrNames.add("Hanuman");
        arrNames.add("Ram");
        arrNames.add("Sita");
        arrNames.add("Laxman");
        arrNames.add("Bharat");
        arrNames.add("Shatrughan");
        arrNames.add("Hanuman");
        arrNames.add("Ram");
        arrNames.add("Sita");
        arrNames.add("Laxman");
        arrNames.add("Bharat");
        arrNames.add("Shatrughan");
        arrNames.add("Hanuman");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, arrNames);
        listView.setAdapter(adapter);

        //List ka item pai click lagana hai.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Toast.makeText(SecondActivity.this, "Clicked First Item", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}