package com.test.login.login.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.login.login.dao.UserMapper;
@Repository
public class UserMapperimpl implements UserMapper {
	@Autowired  
    private SessionFactory sessionFactory = null;
	@Override
	public int getUserCount(String username) {
		Session session = sessionFactory.openSession();
		try {
			String hql="select uId from User  where username=:name ";
			Query query=session.createQuery(hql);
			query.setParameter("name", username);
			List<Integer> list = query.list();
			return list.size();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	/**
	 * 根据用户名查询密码
	 */
	@Override
	public int getPassCount(String username,String pass) {
		Session session = sessionFactory.openSession();
		try {
			String hql="select uId from User  where username=:name and passWord=:pass ";
			Query query=session.createQuery(hql);
			query.setParameter("name", username);
			query.setParameter("pass", pass);
			List<Integer> list = query.list();
			return list.size();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	
	

}
