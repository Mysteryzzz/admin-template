package com.mlearn.service;


import com.mlearn.entity.Order;
import com.mlearn.entity.OrderItem;
import com.mlearn.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> findAll() {

        List<Order> orders = orderMapper.findAll();

        return orders;
    }

    @Override
    public void delivery(Integer id) {

        orderMapper.updateState(id, 1);

    }

    @Override
    public List<OrderItem> selectByOrderNumber(Integer orderNumber) {


        return null;
    }
}
