package com.twu.biblioteca.model;

public class User {

    private String userId;
    private String password;
    private String name;
    private String email;
    private String phone;

    public User(String userId, String password, String name, String email, String phone) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getUserId() {
        return userId;
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
        return getUserId()+" | "+
                getName()+" | "+ getEmail()+" | "+ getPhone()+"\n";
    }

}
