package com.rico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rico.dao.ClientCategoryDao;

@Service
public class ClientCategoryService
{
	@Autowired
	private ClientCategoryDao dao;

	public List query()
	{
		return dao.query();
	}
}
