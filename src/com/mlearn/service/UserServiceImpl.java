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
        List<User> users = null;
        try {
            users = userMapper.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Not found");
        }
        return users;
    }


    @Override
    public void lockUser(Integer id) {

        try {
            userMapper.updateUserLock(id, 3);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("lock failed");
        }
    }

    @Override
    public void deleteUser(Integer id) {

        try {
            userMapper.deleteUser(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("delete failed");
        }


    }

    @Override
    public User selectUser(Integer id) {

        User user = null;
        try {
            user = userMapper.selectUser(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("not found.");
        }

        return user;
    }

    @Override
    public void unlockUser(Integer id) {

        try {
            userMapper.updateUserLock(id, 0);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("unlock failed");
        }

    }
}
