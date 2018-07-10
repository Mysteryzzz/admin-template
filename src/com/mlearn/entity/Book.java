package com.mlearn.entity;

import java.io.Serializable;

public class Book implements Serializable {

    Integer id;
    String bookname;
    Double price;
    String img;
    Integer stock;


    public Book() {
        super();
    }

    public Book(Integer id, String bookname, Double price, String img, Integer stock) {
        super();
        this.id = id;
        this.bookname = bookname;
        this.price = price;
        this.img = img;
        this.stock = stock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
