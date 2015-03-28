package com.hackwestern.anywhere;

/**
 * Created by Frieda on 2015-03-28.
 */
public class Message {
    private String URI; // thumbnail URI
    private String text; // the message
    private boolean self; // if the message was sent by the user

    public Message (String URI, String text, boolean self) {
        this.URI = URI;
        this.text = text;
        this.self = self;
    }

    public String getURI() {
        return URI;
    }

    public String getText() {
        return text;
    }

    public boolean getSelf() {
        return self;
    }
}
