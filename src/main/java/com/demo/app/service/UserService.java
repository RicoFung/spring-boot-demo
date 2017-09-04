package com.demo.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.app.dao.UserDao;
import com.demo.app.entity2.User;

import chok.devwork.springboot.BaseDao;
import chok.devwork.springboot.BaseService;

@Service
public class UserService extends BaseService<User, Long>
{
	@Autowired
	private UserDao dao;

	@Override
	public BaseDao<User, Long> getEntityDao()
	{
		return dao;
	}

}
