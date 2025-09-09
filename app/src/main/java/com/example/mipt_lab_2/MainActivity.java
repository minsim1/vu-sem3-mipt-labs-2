package com.example.mipt_lab_2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Integer numOfNotes = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("MainActivity","Called onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialToolbar toolbar = findViewById(R.id.mainToolBar);
        setSupportActionBar(toolbar);

        ListView listView = findViewById(R.id.notesList);

        NotesDB notesDataBase = new NotesDB(this);
        ArrayList<Note> notes = notesDataBase.getAllNotes();

        this.numOfNotes = notes.toArray().length;

        NoteAdapter adapter = new NoteAdapter(this, notes);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.i("MainActivity","Called onCreateOptionsMenu");
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.i("MainActivity","Called onOptionsItemSelected");
        int id = item.getItemId();
        if (id == R.id.menu_add_note) {
            Intent intent = new Intent(this, AddNoteActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.menu_delete_note) {
            if(this.numOfNotes <= 0){
                String errorMessage = getString(R.string.no_notes_error);
                Toast.makeText(this,errorMessage,Toast.LENGTH_SHORT).show();
                return true;
            }

            Intent intent = new Intent(this, DeleteNoteActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}