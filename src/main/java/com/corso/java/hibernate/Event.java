package com.corso.java.hibernate;



/*
*uno studente può avere 1 dipartimenti
*un dipartimento può avere n studente
*
*
*
*
*
* */
import java.util.Date;

public class Event {

    private Long id;
    private Date date;
    private String title;
    private String description;

    public Event(){}

    public Event(Long id, Date date, String title, String description) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.description = description;
    }

    public Event(String un_evento_seguente, String s, Date date) {
        this.title = un_evento_seguente;
        this.description = s;
        this.date = date;
    }

    /*****************Getters & setters
     *
     *
     */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
}
