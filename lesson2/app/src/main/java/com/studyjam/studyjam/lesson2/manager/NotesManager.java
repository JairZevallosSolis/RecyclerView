package com.studyjam.studyjam.lesson2.manager;

import com.studyjam.studyjam.lesson2.model.Note;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by PedroCarrillo on 3/16/16.
 */
public class NotesManager {

    private List<Note> notesList;

    private static NotesManager ourInstance = new NotesManager();

    public static NotesManager getInstance() {
        return ourInstance;
    }

    private NotesManager() {
        notesList = new ArrayList<>();
        notesList.add(new Note("Study Jams Sabado 19 de marzo", "Llegar 9 am o sino no entro :(", new Date()));
        notesList.add(new Note("Study Jams", "Tarea de Android", new Date()));
        notesList.add(new Note("Study Jams como hacer un listview", "Wow, such listview", new Date()));
        notesList.add(new Note("Esto es una nota de prueba", "YEAHHH", new Date()));
        notesList.add(new Note("Study Jams como hacer un listview", "This is a big description because I would like to show everyone how this row is not particularly the same height as the other rows and this is why this is a big description blablablabla who is reading so far? why would you do something like that?? ok ok ok ok", new Date()));
    }

    public List<Note> getNotes() {
        return notesList;
    }

    public void addNote(Note note) {
        notesList.add(note);
    }

    public void removeNote(Note note) {
        notesList.remove(note);
    }

    public void removeNoteByPosition(int position) {
        notesList.remove(position);
    }

}
