package com.springbootdemo.service;


import com.springbootdemo.dao.mapper.UserMapper;
import com.springbootdemo.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserByUserName(String username) {
        return userMapper.findByUserName(username);
    }
}
