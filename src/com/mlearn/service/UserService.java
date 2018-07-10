package com.mlearn.service;

import com.mlearn.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

//    void addUser(User user);


    void deleteUser(Integer id);
//
//    void updateUser(User user);


    User selectUser(Integer id);

    void unlockUser(Integer id);

    void lockUser(Integer id);
}
