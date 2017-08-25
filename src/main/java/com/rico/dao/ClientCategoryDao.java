package com.rico.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientCategoryDao
{
	@Autowired
	private SqlSession sqlSession;
	
	public List query()
	{
		return this.sqlSession.selectList("com.rico.entity.Category.query");
	}

}
