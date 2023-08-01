package com.example.recyclerviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ArrayList<ContactModel> arrContacts = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView =  findViewById(R.id.recyclerContact);

        //Layout Manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        /*Data Set
        ContactModel model =  new ContactModel(R.drawable.a, "Akash", "8077142867");
        arrContacts.add(model); */
        //Data Set
        arrContacts.add(new ContactModel(R.drawable.a, "Akash", "8077142867"));
        arrContacts.add(new ContactModel(R.drawable.b, "Ramesh", "9077142867"));
        arrContacts.add(new ContactModel(R.drawable.c, "Sita", "1077142867"));
        arrContacts.add(new ContactModel(R.drawable.d, "Rohan", "2077142867"));
        arrContacts.add(new ContactModel(R.drawable.e, "Siva", "3077142867"));
        arrContacts.add(new ContactModel(R.drawable.f, "Laxman", "4077142867"));
        arrContacts.add(new ContactModel(R.drawable.g, "Rohit", "5077142867"));
        arrContacts.add(new ContactModel(R.drawable.h, "Aman", "6077142867"));
        arrContacts.add(new ContactModel(R.drawable.i, "Simran", "7077142867"));
        arrContacts.add(new ContactModel(R.drawable.j, "Radha", "0077142867"));
        arrContacts.add(new ContactModel(R.drawable.a, "Akash", "8077142867"));
        arrContacts.add(new ContactModel(R.drawable.b, "Ramesh", "9077142867"));
        arrContacts.add(new ContactModel(R.drawable.c, "Sita", "1077142867"));
        arrContacts.add(new ContactModel(R.drawable.d, "Rohan", "2077142867"));
        arrContacts.add(new ContactModel(R.drawable.e, "Siva", "3077142867"));
        arrContacts.add(new ContactModel(R.drawable.f, "Laxman", "4077142867"));
        arrContacts.add(new ContactModel(R.drawable.g, "Rohit", "5077142867"));
        arrContacts.add(new ContactModel(R.drawable.h, "Aman", "6077142867"));
        arrContacts.add(new ContactModel(R.drawable.i, "Simran", "7077142867"));
        arrContacts.add(new ContactModel(R.drawable.j, "Radha", "0077142867"));

        //set on RecyclerView
        RecyclerContactAdapter adapter =  new RecyclerContactAdapter(this, arrContacts);
        recyclerView.setAdapter(adapter);

    }
}