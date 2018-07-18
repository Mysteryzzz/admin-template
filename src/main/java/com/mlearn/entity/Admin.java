package com.mlearn.entity;

import java.io.Serializable;

/**
 * @author rezero
 */
public class Admin implements Serializable {

    Integer id;
    String email;
    String password;
    String salt;

    public Admin() {
        super();
    }

    public Admin(Integer id, String email, String password, String salt) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.salt = salt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
