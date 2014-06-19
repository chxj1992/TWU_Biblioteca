package com.twu.biblioteca.model;

public abstract class Item {

    public abstract String getName();

    public abstract Integer getNumber();

    public abstract void setNumber(Integer number);

    public boolean isAvailable() {
        return !getNumber().equals(0);
    }

}
