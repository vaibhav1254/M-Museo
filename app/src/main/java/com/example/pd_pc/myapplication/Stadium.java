package com.example.pd_pc.myapplication;

/**
 * Created by Pd-PC on 8/12/2017.
 */

class Stadium {

    private final String title;
    private final String description;
    private final double contact;
    private final String mail;


    public Stadium(String title, String description, double contact, String mail) {
        this.title = title;
        this.description = description;
        this.contact = contact;
        this.mail = mail;
    }

    public String getTitle() {
        return title;

    }

    public String getDescription() {
        return description;

    }

    public double  getContact() {
        return contact;

    }

    public String getMail() {
        return mail;

    }
}



