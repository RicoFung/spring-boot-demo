package com.demo.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.app.dao.ClientCategoryDao;
import com.demo.app.dao.UserDao;
import com.demo.app.entity.Category;
import com.demo.app.entity2.User;

import chok.devwork.springboot.BaseDao;
import chok.devwork.springboot.BaseService;

@Service
public class ClientCategoryService extends BaseService<Category, Long>
{
	@Autowired
	private ClientCategoryDao dao;
	@Autowired
	private UserDao userDao;

	@Override
	public BaseDao<Category, Long> getEntityDao()
	{
		return dao;
	}
	
	public void addDone()
	{
		User u = new User();
		u.set("tc_code", "HelloUser3");
		userDao.add(u);;
		
		Category c = new Category();
		c.setName("Hello3");
		c.setSort("testtest");// 故意写错数据类型，用以测试RollBack
		dao.add(c);
	}
}
