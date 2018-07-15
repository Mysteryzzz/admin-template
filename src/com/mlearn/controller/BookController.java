package com.mlearn.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mlearn.entity.Book;
import com.mlearn.service.BookService;
import com.mlearn.util.QiniuUtil;
import com.mlearn.vo.ResultUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.UUID;


import com.mlearn.util.FileUtil;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class BookController {

    private static final int PAGESIZE = 10;
    @Autowired
    private BookService bookService;

    private Logger logger = Logger.getLogger(this.getClass());

    @ResponseBody
    @RequestMapping("/book")
    public PageInfo list(@RequestParam(value = "pageNumber", required = false, defaultValue = "1") Integer pageNum) {

        PageHelper.startPage(pageNum, PAGESIZE);

        List<Book> books = bookService.findAll();

        PageInfo pageInfo = new PageInfo(books);

        return pageInfo;
    }


    @ResponseBody
    @RequestMapping("/book/delete")
    public ResultUtil delete(@RequestParam(value = "id", required = true) Integer id) {

        logger.info(id);

        ResultUtil resultUtil = new ResultUtil();

        try {
            bookService.deleteById(id);
            resultUtil.setCode(200);
            resultUtil.setMsg("success");
        } catch (Exception e) {
            e.printStackTrace();
            resultUtil.setCode(100);
            resultUtil.setMsg(e.getMessage());
        }

        return resultUtil;
    }

    @ResponseBody
    @RequestMapping("/book/update")
    public ResultUtil update(Book book) {
        ResultUtil resultUtil = new ResultUtil();
        book.setImg(FileUtil.saveFileReturnPath(book.getFile(), "images"));
        try {
            bookService.update(book);
            resultUtil.setCode(200);
            resultUtil.setMsg("success");
        } catch (Exception e) {
            e.printStackTrace();
            resultUtil.setCode(100);
            resultUtil.setMsg(e.getMessage());
        }

        return resultUtil;
    }



    @ResponseBody
    @RequestMapping("/book/add")
    public ResultUtil add(Book book, HttpServletRequest request) {
        logger.info(book);
        ResultUtil resultUtil = new ResultUtil();

        try {
            String fileName = UUID.randomUUID().toString();

            String path = QiniuUtil.fileUpload(book.getFile().getInputStream(), fileName);

            book.setImg(path);
            bookService.add(book);
            resultUtil.setCode(200);
            resultUtil.setMsg("success");
        } catch (Exception e) {
            e.printStackTrace();
            resultUtil.setCode(100);
            resultUtil.setMsg(e.getMessage());
        }
        logger.info(resultUtil);
        return resultUtil;
    }



//    @ResponseBody
//    @RequestMapping("/book/add2")
//    public ResultUtil add2(Book book, HttpServletRequest request) {
//        logger.info(book);
//        ResultUtil resultUtil = new ResultUtil();
//
//        try {
//            book.setImg(FileUtil.saveFileReturnPath(book.getFile(), "images"));
//            bookService.add(book);
//            resultUtil.setCode(200);
//            resultUtil.setMsg("success");
//        } catch (Exception e) {
//            e.printStackTrace();
//            resultUtil.setCode(100);
//            resultUtil.setMsg(e.getMessage());
//        }
//
//        return resultUtil;
//    }

}
