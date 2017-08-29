package com.rico.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

@Component
public class UserDao
{
	@Resource(name = "secondSqlSessionTemplate")
	private SqlSession sqlSession;
	
	public List query()
	{
		return this.sqlSession.selectList("com.rico.entity2.User.query");
	}

}
