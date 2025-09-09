package com.example.mipt_lab_2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_note);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button goBackButton = findViewById(R.id.goBackButton);
        Button createNoteButton = findViewById(R.id.addNoteButton);

        EditText noteTitle = findViewById(R.id.titleEditText);
        EditText noteBody = findViewById(R.id.bodyEditText);

        goBackButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

        createNoteButton.setOnClickListener(v -> {
            NotesDB notesDataBase = new NotesDB(this);

            String title = noteTitle.getText().toString().trim();
            String body = noteBody.getText().toString();

            if(title.isBlank()){
                String errorMessage = getString(R.string.no_title_error);
                Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
                return;
            }

            if(body.isBlank()){
                String errorMessage = getString(R.string.no_body_error);
                Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
                return;
            }

            if(notesDataBase.noteExists(title)){
                String errorMessage = getString(R.string.note_title_taken_error);
                Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
                return;
            }

            notesDataBase.insertNote(title, body);

            String successMessage = getString(R.string.note_created);
            Toast.makeText(this, successMessage, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

    }
}