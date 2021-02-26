package org.launchcode.spaday.models;

import java.time.LocalDate;

public class User {
    private static int nextId = 1;
    private final int id;
    private String userName;
    private String email;
    private String password;
    private final LocalDate date = LocalDate.now();

    public User(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.id = nextId;
        nextId++;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return this.id;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "userName= " + this.userName + '\n' + "email=" + this.email;
    }
}
