package com.mlearn.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mlearn.entity.Order;
import com.mlearn.entity.OrderItem;
import com.mlearn.service.OrderService;
import com.mlearn.vo.ResultUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;


    private Logger logger = Logger.getLogger(this.getClass());

    @ResponseBody
    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public PageInfo list(@RequestParam(value = "pageNumber" , required = false, defaultValue = "1") Integer pageNumber){

        Integer pageSize = 10;

        PageHelper.startPage(pageNumber, pageSize);

        List<Order> orders = orderService.findAll();

        PageInfo pageInfo = new PageInfo(orders);

        return pageInfo;
    }

    @ResponseBody
    @RequestMapping(value = "/order/info", method = RequestMethod.GET)
    public ResultUtil info(@RequestParam(value = "ordernum" , required = true) Integer orderNumber){
        ResultUtil resultUtil = new ResultUtil();

        logger.info("the different param in the same route");

        List<OrderItem> orderItems = orderService.selectByOrderNumber(orderNumber);


        return resultUtil;
    }




    @ResponseBody
    @RequestMapping(value = "/order", method = RequestMethod.PUT)
    private ResultUtil delivery(@RequestBody Map map){

        orderService.delivery(Integer.parseInt((String) map.get("id")));

        ResultUtil resultUtil = new ResultUtil(200, "success");

        return resultUtil;
    }










}
