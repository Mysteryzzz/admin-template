package com.mlearn.mapper;

import com.mlearn.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    List<Book> findAll();

    void deleteById(@Param("id") Integer id);

    Integer findBookInOrder(Integer id);

    void update(Book book);
}
