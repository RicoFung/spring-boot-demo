package com.rico.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rico.dao.ClientCategoryDao;
import com.rico.entity.Category;

import chok.devwork.springboot.BaseDao;
import chok.devwork.springboot.BaseService;

@Service
public class ClientCategoryService extends BaseService<Category, Long>
{
	@Autowired
	private ClientCategoryDao dao;

	@Override
	public BaseDao<Category, Long> getEntityDao()
	{
		return dao;
	}
}
