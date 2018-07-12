package com.mlearn.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mlearn.entity.Book;
import com.mlearn.service.BookService;
import com.mlearn.vo.ResultUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

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
        resultUtil.setCode(200);
        resultUtil.setMsg("success");

        System.out.println(request.getParameter("file"));
        String sqlPath;
        String localPath="D:\\File\\";
        String filename=null;
        if(!book.getFile().isEmpty()){
            //生成uuid作为文件名称
            String uuid = UUID.randomUUID().toString().replaceAll("-","");
            //获得文件类型（可以判断如果不是图片，禁止上传）
            String contentType= book.getFile().getContentType();
            //获得文件后缀名
            String suffixName=contentType.substring(contentType.indexOf("/")+1);
            //得到 文件名
            filename=uuid+"."+suffixName;
            System.out.println(filename);
            //文件保存路径
            try {
                book.getFile().transferTo(new File(localPath+filename));
            } catch (IOException e) {
                e.printStackTrace();
                resultUtil.setCode(100);
                resultUtil.setMsg(e.getMessage());
            }
        }
        //把图片的相对路径保存至数据库
        sqlPath = "/images/"+filename;
        System.out.println(sqlPath);
        book.setImg(sqlPath);
        try {
            bookService.add(book);
        } catch (Exception e) {
            e.printStackTrace();
            resultUtil.setCode(100);
            resultUtil.setMsg(e.getMessage());
        }
        return resultUtil;
    }


}
