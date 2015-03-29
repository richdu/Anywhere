package com.hackwestern.anywhere;

import android.media.Image;

/**
 * Created by Frieda on 2015-03-28.
 */
public class Contact {
    private String name;
    private String photo;

    public Contact (String name, String photo) {
        this.name = name;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }
}
