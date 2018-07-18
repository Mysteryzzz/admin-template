package com.mlearn.service;

import com.mlearn.entity.Book;

import java.util.List;

public interface BookService {

    public List<Book> findAll();

    void deleteById(Integer id);


    void update(Book book);

    void add(Book book);
}
