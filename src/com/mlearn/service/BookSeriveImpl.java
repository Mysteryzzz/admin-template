package com.mlearn.service;

import com.mlearn.entity.Book;
import com.mlearn.mapper.BookMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookSeriveImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    private Logger logger = Logger.getLogger(this.getClass());


    @Override
    public List<Book> findAll() {
        List<Book> books = null;

        try {
            books = bookMapper.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("not found");
        }
        return books;
    }


    @Override
    public void deleteById(Integer id) {
        try {
            Integer count = bookMapper.findBookInOrder(id);
            if (count == 0){
                bookMapper.deleteById(id);
            }
            else {
                throw new RuntimeException("The book was found in orders");
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Can not delete");
        }
    }

    @Override
    public void update(Book book) {
        try {
            bookMapper.update(book);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Can not update");
        }
    }

    @Override
    public void add(Book book) {
        try {
            bookMapper.add(book);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Can not add");
        }

        logger.info(book);
    }
}
