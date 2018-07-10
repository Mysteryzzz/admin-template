package com.mlearn.mapper;

import com.mlearn.entity.Book;

import java.util.List;

public interface BookMapper {
    List<Book> findAll();
}
