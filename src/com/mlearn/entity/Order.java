package com.mlearn.entity;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {

    private Integer id;

    private String ordernum;

    private Integer buyerId;

    private Date createdate;

    private Double totalprice;

    private Integer state;


    public Order() {
        super();
    }

    public Order(Integer id, String ordernum, Integer buyerId, Date createdate, Double totalprice, Integer state) {
        super();
        this.id = id;
        this.ordernum = ordernum;
        this.buyerId = buyerId;
        this.createdate = createdate;
        this.totalprice = totalprice;
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

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Double totalprice) {
        this.totalprice = totalprice;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
