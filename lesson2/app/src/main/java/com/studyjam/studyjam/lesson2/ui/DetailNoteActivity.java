package com.studyjam.studyjam.lesson2.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.studyjam.studyjam.lesson2.R;
import com.studyjam.studyjam.lesson2.manager.NotesManager;
import com.studyjam.studyjam.lesson2.model.Note;

import java.util.Date;

/**
 * Created by Pablo Johnson on 3/18/16.
 */
public class DetailNoteActivity extends AppCompatActivity {

    private TextView noteTitle;
    private TextView noteDescription;
    private TextView noteDate;
    public int posicion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_note);
        if (getIntent() != null) {
            noteTitle = (TextView) findViewById(R.id.noteTitle);
            noteDescription = (TextView) findViewById(R.id.noteDescription);
            noteDate = (TextView) findViewById(R.id.noteDate);

            noteTitle.setText(getIntent().getStringExtra(NotesActivity.TITLE));
            noteDescription.setText(getIntent().getStringExtra(NotesActivity.DESCRIPTION));
            noteDate.setText(getIntent().getStringExtra(NotesActivity.DATE));
            posicion = getIntent().getIntExtra(NotesActivity.POSICION,0);
            Log.e("DETAIL POS", posicion + "");
        }
    }

    private void deleteNote() {
        NotesManager.getInstance().removeNoteByPosition(posicion);
        Toast.makeText(this, R.string.delete, Toast.LENGTH_SHORT).show();
        setResult(10);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.deleteNote:
                //String noteTitle2 = noteTitle.getText().toString();
                //String noteDescription2 = noteDescription.getText().toString();
                //Date date = (Date) noteDate.getText();
                //Note note = new Note(noteTitle2, noteDescription2, date);
                deleteNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
