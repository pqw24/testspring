package com.test.login.login.service;

public interface UserService {

	int getUserCount(String username);
	//�����û�����ѯ����
	int getPassCount(String username,String pass);

}
