package com.test.login.login.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.login.login.dao.UserMapper;
import com.test.login.login.service.UserService;

@Service
public class UserServiceimpl implements UserService{
	@Autowired
	public UserMapper mapper;
	@Override
	public int getUserCount(String username) {
		// TODO Auto-generated method stub
		return mapper.getUserCount(username);
	}
	/**
	 * 根据用户名查询密码
	 */
	@Override
	public int getPassCount(String username,String pass) {
		return mapper.getPassCount(username,pass);
	}

}
