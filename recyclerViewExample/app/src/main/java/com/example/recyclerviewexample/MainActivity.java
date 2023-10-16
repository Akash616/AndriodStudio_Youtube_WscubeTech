package com.example.recyclerviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<ContactModel> arrContacts = new ArrayList<>();
    RecyclerView recyclerContact;
    FloatingActionButton btnOpenDialog;
    RecyclerContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerContact = findViewById(R.id.recyclerContact);
        btnOpenDialog = findViewById(R.id.btnOpenDialog);

        btnOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Custom Dialog Open at Runtime
                //Custom Dialog ka leya custom layout chahiya - add_update_lay.xml
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_update_lay);

                EditText edtName = dialog.findViewById(R.id.edtName);
                EditText edtNumber = dialog.findViewById(R.id.edtNumber);
                Button btnAction = dialog.findViewById(R.id.btnAction);

                btnAction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = "", number = "";
                        if (!edtName.getText().toString().equals("")) {
                            name = edtName.getText().toString();
                        } else {
                            Toast.makeText(MainActivity.this, "Please Enter Contact Name", Toast.LENGTH_SHORT).show();
                        }
                        if (!edtNumber.getText().toString().equals("")) {
                            number = edtNumber.getText().toString();
                        } else {
                            Toast.makeText(MainActivity.this, "Please Enter Contact Number", Toast.LENGTH_SHORT).show();

                        }

                        arrContacts.add(new ContactModel(R.drawable.i, name, number));
                        adapter.notifyItemInserted(arrContacts.size() - 1);
                        recyclerContact.scrollToPosition(arrContacts.size() - 1);

                        dialog.dismiss();

                    }
                });

                dialog.show();

            }
        });

        //Layout Manager
        recyclerContact.setLayoutManager(new LinearLayoutManager(this));

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
        adapter = new RecyclerContactAdapter(MainActivity.this, arrContacts);
        recyclerContact.setAdapter(adapter);

    }
}