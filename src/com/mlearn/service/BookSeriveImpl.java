package com.mlearn.service;

import com.mlearn.entity.Book;
import com.mlearn.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookSeriveImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;


    @Override
    public List<Book> findAll() {
        return bookMapper.findAll();
    }
}
