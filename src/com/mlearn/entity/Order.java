package com.mlearn.entity;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {

    private Integer id;

    private String ordernum;

    private Integer buyerId;

    private Date createDate;

    private Double totalPrice;

    private Integer state;


    public Order() {
        super();
    }

    public Order(Integer id, String ordernum, Integer buyerId, Date createDate, Double totalPrice, Integer state) {
        super();
        this.id = id;
        this.ordernum = ordernum;
        this.buyerId = buyerId;
        this.createDate = createDate;
        this.totalPrice = totalPrice;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum;
    }

    public Integer getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
