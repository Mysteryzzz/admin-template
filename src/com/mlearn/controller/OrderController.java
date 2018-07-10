package com.mlearn.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mlearn.entity.Order;
import com.mlearn.service.OrderService;
import com.mlearn.vo.ResultUtil;
import jdk.nashorn.internal.runtime.logging.DebugLogger;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;



    @ResponseBody
    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public PageInfo list(@RequestParam(value = "pageNumber" , required = false, defaultValue = "1") Integer pageNumber){

        Integer pageSize = 2;

        PageHelper.startPage(pageNumber, pageSize);

        List<Order> orders = orderService.findAll();

        PageInfo pageInfo = new PageInfo(orders);

        return pageInfo;
    }




    @ResponseBody
    @RequestMapping(value = "/order", method = RequestMethod.PUT)
    private ResultUtil delivery(@RequestBody Map map){

        orderService.delivery(Integer.parseInt((String) map.get("id")));

        ResultUtil resultUtil = new ResultUtil(200, "success");

        return resultUtil;
    }










}
