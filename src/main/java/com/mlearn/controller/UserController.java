package com.mlearn.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mlearn.entity.User;
import com.mlearn.service.UserService;
import com.mlearn.vo.ResultUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    private static Logger logger = Logger.getLogger(UserController.class);

    @ResponseBody
    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    private PageInfo list(@RequestParam(value = "pageNumber" , required = false, defaultValue = "1") Integer pageNumber){
        Integer pageSize = 10;

        PageHelper.startPage(pageNumber, pageSize);

        List<User> users = userService.findAll();

        PageInfo pageInfo = new PageInfo(users);

        return pageInfo;
    }



//
//    @ResponseBody
//    @RequestMapping(value = "/user", method = RequestMethod.POST)
//    private ResultUtil add(User user){
//
//        logger.info(user);
//
//        try {
//            userService.addUser(user);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        ResultUtil resultUtil = new ResultUtil(200, "success");
//
//        return resultUtil;
//    }

    @ResponseBody
    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    private ResultUtil delete(@RequestBody Map map){
        logger.info(map.get(map.get("id")));
        userService.deleteUser(Integer.parseInt((String) map.get("id")));

        ResultUtil resultUtil = new ResultUtil(200, "success");

        return resultUtil;
    }

//    @ResponseBody
//    @RequestMapping(value = "/user", method = RequestMethod.PUT)
//    private ResultUtil update(@RequestBody User user){
//        logger.info(user);
//        userService.updateUser(user);
//        ResultUtil resultUtil = new ResultUtil(200, "success");
//
//        return resultUtil;
//    }



    @ResponseBody
    @RequestMapping(value = "/unlock/user", method = RequestMethod.GET)
    private ResultUtil unlock(@RequestParam(value = "id", required = true) Integer id){

        logger.info(id.toString());

        ResultUtil resultUtil = new ResultUtil(200, "success");

        userService.unlockUser(id);

        return resultUtil;
    }

    @ResponseBody
    @RequestMapping(value = "/lock/user", method = RequestMethod.GET)
    private ResultUtil lock(@RequestParam(value = "id", required = true) Integer id){

        logger.info(id.toString());

        ResultUtil resultUtil = new ResultUtil(200, "success");

        userService.lockUser(id);

        return resultUtil;
    }


    @ResponseBody
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    private ResultUtil select(@PathVariable(value = "id", required = true) Integer id){

        userService.selectUser(id);

        ResultUtil resultUtil = new ResultUtil(200, "success");

        return resultUtil;
    }

}
