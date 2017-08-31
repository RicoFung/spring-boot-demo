package com.rico.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import com.rico.entity2.User;

import chok.devwork.springboot.BaseDao;

@Component
public class UserDao extends BaseDao<User, Long>
{
//	指定装配哪个SqlSessionTemplate
//	方式一
//	@Autowired
//	@Qualifier("secondSqlSessionTemplate")
//	方式二
	@Resource(name = "secondSqlSessionTemplate")
	private SqlSession sqlSession;

	@Override
	protected Class<User> getEntityClass()
	{
		return User.class;
	}

	@Override
	protected SqlSession getSqlSession()
	{
		return sqlSession;
	}
	
}
