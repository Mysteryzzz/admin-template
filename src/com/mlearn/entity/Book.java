package com.mlearn.entity;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

public class Book implements Serializable {

    private Integer id;
    private String bookname;
    private Double price;
    private String img;
    private Integer stock;
    private MultipartFile file;


    public Book() {
        super();
    }


    public Book(Integer id, String bookname, Double price, String img, Integer stock, MultipartFile file) {
        this.id = id;
        this.bookname = bookname;
        this.price = price;
        this.img = img;
        this.stock = stock;
        this.file = file;
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

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookname='" + bookname + '\'' +
                ", price=" + price +
                ", img='" + img + '\'' +
                ", stock=" + stock +
                ", file=" + file +
                '}';
    }
}
