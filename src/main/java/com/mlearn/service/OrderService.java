package com.mlearn.service;

import com.mlearn.entity.Order;
import com.mlearn.entity.OrderItem;

import java.util.List;

public interface OrderService {


    List<Order> findAll();

    void delivery(Integer id);

    List<OrderItem> selectByOrderNumber(String orderNumber);

    List<Order> findSateList(Integer state);
}
