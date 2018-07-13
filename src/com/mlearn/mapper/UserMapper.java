package com.mlearn.mapper;

import com.mlearn.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {


    List<User> findAll();
//
//    void addUser(User user);
//
//    void updateUser(User user);

    void deleteUser(Integer id);

    User selectUser(Integer id);

    void updateUserLock(@Param("id") Integer id, @Param("lock") Integer lock);
}
