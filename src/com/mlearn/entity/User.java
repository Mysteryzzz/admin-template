package com.mlearn.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{

    Integer id;
    String username;
    Boolean password;
    String email;
    Integer islock;
    Date lastdate;


    public User() {
        super();
    }


    public User(Integer id, String username, Boolean password, String email, Integer islock, Date lastdate) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.islock = islock;
        this.lastdate = lastdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getPassword() {
        return password;
    }

    public void setPassword(Boolean password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIslock() {
        return islock;
    }

    public void setIslock(Integer islock) {
        this.islock = islock;
    }

    public Date getLastdate() {
        return lastdate;
    }

    public void setLastdate(Date lastdate) {
        this.lastdate = lastdate;
    }
}
