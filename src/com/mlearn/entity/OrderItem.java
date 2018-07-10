package com.mlearn.entity;

import java.io.Serializable;

public class OrderItem implements Serializable {

    Integer id;

    Order order;

    Book book;

    Integer num;

    public OrderItem() {
        super();
    }

    public OrderItem(Integer id, Order order, Book book, Integer num) {
        super();
        this.id = id;
        this.order = order;
        this.book = book;
        this.num = num;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
