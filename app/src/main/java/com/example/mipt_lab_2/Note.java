package com.example.mipt_lab_2;

import android.util.Log;

public class Note {
    String title;
    String body;

    Note(String title, String body) {
        Log.i("Note","Instantiated note with title: " + title + " body:" + body);
        this.title = title;
        this.body = body;
    }
}
