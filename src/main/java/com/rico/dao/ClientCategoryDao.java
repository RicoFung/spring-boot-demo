package com.rico.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

@Component
public class ClientCategoryDao
{
	private final SqlSession sqlSession;

	public ClientCategoryDao(SqlSession sqlSession) 
	{
		this.sqlSession = sqlSession;
	}
	
	public List query()
	{
		return this.sqlSession.selectList("com.rico.entity.Category.query");
	}

}
