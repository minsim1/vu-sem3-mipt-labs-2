package com.example.mipt_lab_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class NoteAdapter extends ArrayAdapter<Note> {

    public NoteAdapter(Context context, List<Note> notes) {
        super(context, 0, notes);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        Note note = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.note_item, parent, false);
        }

        TextView title = convertView.findViewById(R.id.noteTitle);
        TextView body = convertView.findViewById(R.id.noteBody);

        if (note != null) {
            title.setText(note.title);
            body.setText(note.body);
        }

        return convertView;
    }
}
