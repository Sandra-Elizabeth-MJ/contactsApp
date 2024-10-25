package com.upn.contactsapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.upn.contactsapp.entities.Contact;

import java.util.List;
import java.util.UUID;

public class FirebaseActivity extends AppCompatActivity {
    EditText etName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);

        Button btn = findViewById(R.id.btnCreateOnFirebase);
        etName = findViewById(R.id.etNameF);

        btn.setOnClickListener(v -> {
            // Write a message to the database
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("N00282096");
            DatabaseReference table = myRef.child(" contacts");
            String name = etName.getText().toString();


             Contact c1 = new Contact(name, "12345678");
             c1.uuid = UUID.randomUUID().toString();
//            Contact c2 = new Contact("Miguel", "123456");
//            c2.uuid = UUID.randomUUID().toString();
//
//            myRef.child(c1.uuid).setValue(c1);
//            myRef.child(c2.uuid).setValue(c2);
            //table.setValue(c1);
            table.child(c1.uuid).setValue(c1);
            etName.setText("");

        });


    }
}