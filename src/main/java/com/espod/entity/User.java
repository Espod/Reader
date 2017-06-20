package com.espod.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    private String userID;

    private String password;

    private String name;

    private String phone;

    public User(String userID, String password, String name, String phone) {
        this.userID = userID;
        this.password = password;
        this.name = name;
        this.phone = phone;
    }

    public User() {    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
