package com.mlearn.service;

import com.mlearn.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderService {


    List<Order> findAll();

    void delivery(Integer id);
}
