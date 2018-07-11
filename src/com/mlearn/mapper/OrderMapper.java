package com.mlearn.mapper;

import com.mlearn.entity.Order;
import com.mlearn.entity.OrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    List<Order> findAll();

    void updateState(@Param("id") Integer id, @Param("state") Integer state);

    List<OrderItem> selectByOrderNumber(Integer orderNumber);

    List<Order> findBySate(@Param("state") Integer state);
}
