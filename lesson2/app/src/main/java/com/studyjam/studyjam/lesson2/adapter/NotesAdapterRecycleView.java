package com.studyjam.studyjam.lesson2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
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
public class NotesAdapterRecycleView extends RecyclerView.Adapter<NotesAdapterRecycleView.ViewHolder> {

    List<Note> notesList;

    public NotesAdapterRecycleView(List<Note> notesList) {
        this.notesList = notesList;
    }

    @Override
    public NotesAdapterRecycleView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_notes_row, parent, false);

        ViewHolder vh = new ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Note note = getItem(position);

        holder.tvTitle.setText(note.getTitle());
        holder.tvDescription.setText(note.getDescription());
        holder.tvCreatedAt.setText(note.getDate().toString());
    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }

    public Note getItem(int position) {
        return notesList.get(position);
    }

    /*List<Note> notesList;

        public NotesAdapterRecycleView(List<Note> notesList) {
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
    */
    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        TextView tvDescription;
        TextView tvCreatedAt;

        public ViewHolder(View view) {
            super(view);
            tvTitle = (TextView)view.findViewById(R.id.tvTitle);
            tvDescription = (TextView)view.findViewById(R.id.tvDescription);
            tvCreatedAt = (TextView)view.findViewById(R.id.tvCreatedAt);
        }

    }

}
