package com.mlearn.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mlearn.entity.Book;
import com.mlearn.service.BookService;
import com.mlearn.vo.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BookController {

    private static final int PAGESIZE = 1;

    @Autowired
    private BookService bookService;


    @ResponseBody
    @RequestMapping("/book")
    public ResultUtil list(@RequestParam(required = false, defaultValue = "1") Integer pageNum){

        PageHelper.startPage(pageNum, PAGESIZE);

        List<Book> books =bookService.findAll();

        PageInfo pageInfo = new PageInfo(books);

        ResultUtil resultUtil = new ResultUtil(200, pageInfo);

        return resultUtil;
    }





}
