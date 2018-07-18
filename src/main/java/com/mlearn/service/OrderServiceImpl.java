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

        List<Order> orders = null;
        try {
            orders = orderMapper.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("not found");
        }

        return orders;
    }

    @Override
    public void delivery(Integer id) {

        try {
            orderMapper.updateState(id, 1);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("delivery failed");
        }

    }

    @Override
    public List<OrderItem> selectByOrderNumber(String orderNumber) {


        List<OrderItem> orderItemList = null;
        try {
            orderItemList = orderMapper.selectByOrderNumber(orderNumber);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("not found");
        }
        return orderItemList;

    }

    @Override
    public List<Order> findSateList(Integer state) {

        List<Order> orders = null;
        try {
            orders = orderMapper.findBySate(state);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("not found");
        }

        return orders;
    }
}
