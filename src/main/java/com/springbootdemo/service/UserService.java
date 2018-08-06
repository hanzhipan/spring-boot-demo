package com.springbootdemo.service;

import com.springbootdemo.domain.entity.User;

public interface UserService {
    User findUserByUserName(String username);
}
