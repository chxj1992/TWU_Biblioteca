package com.twu.biblioteca.service;

/**
 * Created by xjchen on 6/17/14.
 */
public abstract class StorageService {
    public abstract void list();

    abstract void checkout();

    abstract void returns();

    public void processInput(String option) {
        switch (option) {
            case "1":
                checkout();
                break;
            default:
                returns();
                break;
        }
    }
}
