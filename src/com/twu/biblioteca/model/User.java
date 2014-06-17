package com.twu.biblioteca.model;

public class User {

    private String number;
    private String password;
    private String name;
    private String email;
    private String phone;

    public User(String number, String password, String name, String email, String phone) {
        this.number = number;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getNumber() {
        return number;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return getNumber()+" | "+
                getName()+" | "+ getEmail()+" | "+ getPhone()+"\n";
    }

}
