package com.studyjam.studyjam.lesson2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.studyjam.studyjam.lesson2.R;
import com.studyjam.studyjam.lesson2.model.Note;

import java.util.List;

/**
 * Created by PedroCarrillo on 3/16/16.
 */
public class NotesAdapter extends BaseAdapter {

    List<Note> notesList;

    public NotesAdapter(List<Note> notesList) {
        this.notesList = notesList;
    }

    @Override
    public int getCount() {
        return notesList.size();
    }

    @Override
    public Note getItem(int position) {
        return notesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder noteViewHolder;
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.layout_notes_row, parent, false);
            noteViewHolder = new ViewHolder(convertView);
            convertView.setTag(noteViewHolder);
        } else {
            noteViewHolder = (ViewHolder) convertView.getTag();
        }
        Note note = getItem(position);
        noteViewHolder.tvTitle.setText(note.getTitle());
        noteViewHolder.tvDescription.setText(note.getDescription());
        noteViewHolder.tvCreatedAt.setText(note.getDate().toString());
        return convertView;
    }

    public class ViewHolder {

        TextView tvTitle;
        TextView tvDescription;
        TextView tvCreatedAt;

        public ViewHolder(View view) {
            tvTitle = (TextView)view.findViewById(R.id.tvTitle);
            tvDescription = (TextView)view.findViewById(R.id.tvDescription);
            tvCreatedAt = (TextView)view.findViewById(R.id.tvCreatedAt);
        }

    }

}
