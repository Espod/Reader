package com.espod.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Borrowed {

    @Id
    private Integer id;

    private String userID;

    private String isbn;

    private Date date;

    public Borrowed(String userID, String isbn, Date date) {
        this.userID = userID;
        this.isbn = isbn;
        this.date = date;
    }

    public Borrowed() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
