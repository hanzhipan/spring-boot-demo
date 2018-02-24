package com.springbootdemo.controller;

import com.springbootdemo.dao.mapper.UserMapper;
import com.springbootdemo.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@Autowired
	private UserMapper userMapper;

	@RequestMapping("/show")
	public String show(){
		return "Hello World";		
	}

	@RequestMapping("/getuser")
	public User getUser(@RequestParam String phone) {
		User user = userMapper.findUserByPhone(phone);
		return user;
	}

	@RequestMapping("/insertuser")
	public int insertUser(@RequestParam String name, @RequestParam String phone) {
		int cnt = userMapper.insert(name, phone);
		return cnt;
	}
}
