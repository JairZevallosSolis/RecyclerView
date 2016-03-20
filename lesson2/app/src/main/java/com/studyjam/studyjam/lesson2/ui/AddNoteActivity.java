package com.studyjam.studyjam.lesson2.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.studyjam.studyjam.lesson2.R;
import com.studyjam.studyjam.lesson2.manager.NotesManager;
import com.studyjam.studyjam.lesson2.model.Note;

import java.util.Date;

public class AddNoteActivity extends AppCompatActivity {

    private EditText noteTitleView;
    private EditText noteDescriptionView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        noteTitleView = (EditText) findViewById(R.id.noteTitleField);
        noteDescriptionView = (EditText) findViewById(R.id.noteDescriptionField);
    }

    private void addNote(Note note) {
        NotesManager.getInstance().addNote(note);
        Toast.makeText(this, R.string.noteAdded, Toast.LENGTH_SHORT).show();
        setResult(50);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_note_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.addNote:
                String noteTitle = noteTitleView.getText().toString();
                String noteDescription = noteDescriptionView.getText().toString();
                Note note = new Note(noteTitle, noteDescription, new Date());
                addNote(note);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
