package com.mlearn.service;

import com.mlearn.entity.User;
import com.mlearn.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;



    @Override
    public List<User> findAll() {
        List<User> users = userMapper.findAll();
        return users;
    }

//    @Override
//    public void addUser(User user) {
//
//        userMapper.addUser(user);
//
//
//    }

//    @Override
//    public void updateUser(User user) {
//        userMapper.updateUser(user);
//    }

    @Override
    public void lockUser(Integer id) {
        userMapper.updateUserLock(id, 3);
    }

    @Override
    public void deleteUser(Integer id) {

        userMapper.deleteUser(id);


    }

    @Override
    public User selectUser(Integer id) {

        User user = userMapper.selectUser(id);


        return user;
    }

    @Override
    public void unlockUser(Integer id) {

        userMapper.updateUserLock(id, 0);

    }
}
