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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;


    private Logger logger = Logger.getLogger(this.getClass());

    private static final int RETRY = 3;
    private static final int PAGESIZE = 3;

    @ResponseBody
    @RequestMapping(value = "/order/info", method = RequestMethod.GET)
    public ResultUtil info(@RequestParam(value = "ordernum" , required = true) Integer orderNumber){
        ResultUtil resultUtil = new ResultUtil();

        logger.info("the different param in the same route");

        List<OrderItem> orderItems = orderService.selectByOrderNumber(orderNumber);
        resultUtil.setCode(1);
        resultUtil.setMsg(orderItems);

        return resultUtil;
    }




    @ResponseBody
    @RequestMapping(value = "/order", method = RequestMethod.PUT)
    public ResultUtil delivery(@RequestBody Map map){

        orderService.delivery(Integer.parseInt((String) map.get("id")));

        ResultUtil resultUtil = new ResultUtil(200, "success");

        return resultUtil;
    }

    @ResponseBody
    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public PageInfo state(
            @RequestParam(value = "state" , required = true) Integer state
            , @RequestParam(value = "pageNumber" , required = false, defaultValue = "1") Integer pageNumber){


        List<Order> orders = null;

        PageHelper.startPage(pageNumber, PAGESIZE);

        if (state < RETRY){
            orders = orderService.findSateList(state);
        }
        else {
            orders = orderService.findAll();
        }

        PageInfo pageInfo = new PageInfo(orders);

        return pageInfo;
    }















}
