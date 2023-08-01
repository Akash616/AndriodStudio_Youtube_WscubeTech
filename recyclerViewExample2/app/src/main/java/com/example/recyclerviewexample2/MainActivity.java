package com.example.recyclerviewexample2;

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

        //Data Set
        //Add elements Data
        /*ContactModel model = new ContactModel(R.drawable.a, "Akash", "8077142867");
        arrContacts.add(model); */
        arrContacts.add(new ContactModel(R.drawable.a, "Akash", "1077142867"));
        arrContacts.add(new ContactModel(R.drawable.b, "Ram", "2077142867"));
        arrContacts.add(new ContactModel(R.drawable.c, "Sita", "3077142867"));
        arrContacts.add(new ContactModel(R.drawable.d, "Laxman", "4077142867"));
        arrContacts.add(new ContactModel(R.drawable.e, "Bharat", "5077142867"));
        arrContacts.add(new ContactModel(R.drawable.f, "Raja", "6077142867"));
        arrContacts.add(new ContactModel(R.drawable.g, "Subham", "7077142867"));
        arrContacts.add(new ContactModel(R.drawable.h, "Smith", "8077142867"));
        arrContacts.add(new ContactModel(R.drawable.i, "Simran", "9077142867"));
        arrContacts.add(new ContactModel(R.drawable.j, "Swati", "1007142867"));
        arrContacts.add(new ContactModel(R.drawable.a, "Akash", "1077142867"));
        arrContacts.add(new ContactModel(R.drawable.b, "Ram", "2077142867"));
        arrContacts.add(new ContactModel(R.drawable.c, "Sita", "3077142867"));
        arrContacts.add(new ContactModel(R.drawable.d, "Laxman", "4077142867"));
        arrContacts.add(new ContactModel(R.drawable.e, "Bharat", "5077142867"));
        arrContacts.add(new ContactModel(R.drawable.f, "Raja", "6077142867"));
        arrContacts.add(new ContactModel(R.drawable.g, "Subham", "7077142867"));
        arrContacts.add(new ContactModel(R.drawable.h, "Smith", "8077142867"));
        arrContacts.add(new ContactModel(R.drawable.i, "Simran", "9077142867"));
        arrContacts.add(new ContactModel(R.drawable.j, "Swati", "1007142867"));

        //Custom Adapter recycler view pai set karna hai.
        RecyclerContactAdapter adapter = new RecyclerContactAdapter(this, arrContacts);
        recyclerView.setAdapter(adapter);

    }
}