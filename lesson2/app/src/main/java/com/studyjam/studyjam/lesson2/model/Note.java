package com.studyjam.studyjam.lesson2.model;

import java.util.Date;

/**
 * Created by PedroCarrillo on 3/16/16.
 */
public class Note {

    public String title;
    public String description;
    public Date date;

    public Note(String title, String description, Date date) {
        this.title = title;
        this.description = description;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
