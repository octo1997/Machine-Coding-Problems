package com.entities;

public class Door {
    private boolean isOpen = false;

    public void open(){
        isOpen = true;
    }

    public void close(){
        isOpen = false;
    }
}
