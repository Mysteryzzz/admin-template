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
        return bookMapper.findAll();
    }


    @Override
    public void deleteById(Integer id) {
        try {
            Integer count = bookMapper.findBookInOrder(id);
            if (count == 0){
                bookMapper.deleteById(id);
            }
            else {
                throw new Exception("The book was found in orders");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Book book) {
        bookMapper.update(book);
    }

    @Override
    public void add(Book book) {
        bookMapper.add(book);


        logger.info(book);
    }
}
