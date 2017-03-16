package com.test.login.login.dao;

public interface UserMapper {

	int getUserCount(String username);
	//根据用户名查询密码
	int getPassCount(String username,String pass);

}
