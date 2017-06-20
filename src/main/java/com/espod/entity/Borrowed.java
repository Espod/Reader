package com.espod.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Borrowed {

    @Id
    //设置为自动增长策略
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String userID;

    private String isbn;

    private Date borrowedDate;

    public Borrowed(String userID, String isbn, Date brrowedDate) {
        this.userID = userID;
        this.isbn = isbn;
        this.borrowedDate = brrowedDate;
    }

    public Borrowed() {
    }

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

    public Date getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(Date borrowedDate) {
        this.borrowedDate = borrowedDate;
    }
}
