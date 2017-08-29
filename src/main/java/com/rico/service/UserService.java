package com.rico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rico.dao.UserDao;

@Service
public class UserService
{
	@Autowired
	private UserDao dao;

	public List query()
	{
		return dao.query();
	}
}
