package com.mlearn.controller;


import com.mlearn.entity.Admin;
import com.mlearn.entity.OrderItem;
import com.mlearn.service.AdminService;
import com.mlearn.service.OrderService;
import com.mlearn.vo.ResultUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HttpServletBean;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private OrderService orderService;

    private Logger logger = Logger.getLogger(this.getClass());


    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultUtil login(Admin admin, HttpServletRequest request){

        ResultUtil resultUtil = new ResultUtil();

        try {
            if (adminService.login(admin)){
                HttpSession session = request.getSession();
                session.setAttribute("user", admin.getEmail());

                resultUtil.setCode(200);
                resultUtil.setMsg("success");
            }
            else {
                request.getSession().removeAttribute("user");
                resultUtil.setCode(300);
                resultUtil.setMsg("Please check your password or username.");
            }
        } catch (Exception e) {
            request.getSession().removeAttribute("user");
            e.printStackTrace();
            resultUtil.setCode(100);
            resultUtil.setMsg(e.getMessage());
        }

        return resultUtil;

    }

//
//    @ResponseBody
//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public ResultUtil login(Admin admin, HttpServletRequest request){
//
//        ResultUtil resultUtil = new ResultUtil();
//        List<OrderItem> itemList = orderService.selectByOrderNumber(1);
//        logger.info(itemList);
//        resultUtil.setCode(1);
//        resultUtil.setMsg(itemList);
//        return resultUtil;
//
//    }






}
