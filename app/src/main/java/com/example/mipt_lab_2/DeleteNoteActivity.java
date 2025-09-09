package com.example.mipt_lab_2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class DeleteNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_delete_note);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button goBackButton = findViewById(R.id.goBackButton);
        Button deleteButton = findViewById(R.id.deleteButton);

        Spinner noteSelectSpinner = findViewById(R.id.noteSelectSpinner);

        NotesDB notesDataBase = new NotesDB(this);

        ArrayList<String> titles = new ArrayList<>();
        for (Note note : notesDataBase.getAllNotes()) {
            titles.add(note.title);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                titles
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        noteSelectSpinner.setAdapter(adapter);

        goBackButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

        deleteButton.setOnClickListener(v -> {
            String selectedTitle = noteSelectSpinner.getSelectedItem().toString();
            notesDataBase.deleteNoteByTitle(selectedTitle);
            String successMessage = getString(R.string.delete_success_message);
            Toast.makeText(this,successMessage, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
    }
}