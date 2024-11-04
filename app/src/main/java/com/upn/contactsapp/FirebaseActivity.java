package com.upn.contactsapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.upn.contactsapp.entities.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FirebaseActivity extends AppCompatActivity {

    Button btn;
    Contact contact;
    EditText etName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);

        btn = findViewById(R.id.btnCreateOnFirebase);
        etName = findViewById(R.id.etName);

        contact.getName("a", 2);

        btn.setOnClickListener(v -> {
            printName();
        });
    }

    private void printName() {
        String name = etName.getText().toString();
        String personaEncontrada = buscarPersona(name);
        if(personaEncontrada != null) {
            Log.i("PERSONA", personaEncontrada);
        } else {
            Log.i("PERSONA", "No se encontro la persona");
        }
    }

    private String buscarPersona(String name) {
        List<String> personas = List.of("Juan", "Pedro", "Maria", "Jose");

        return personas.stream().filter(p -> p.equals(name)).findFirst().orElse(null);

    }

}