package com.rico.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rico.dao.UserDao;
import com.rico.entity2.User;

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
