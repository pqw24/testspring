package com.test.login.login.dao;

public interface UserMapper {

	int getUserCount(String username);
	//�����û�����ѯ����
	int getPassCount(String username,String pass);

}
