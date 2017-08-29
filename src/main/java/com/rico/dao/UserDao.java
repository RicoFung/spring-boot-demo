package com.rico.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

@Component
public class UserDao
{
//	指定装配哪个SqlSessionTemplate
//	方式一
	@Resource(name = "secondSqlSessionTemplate")
//	方式二
//	@Autowired
//	@Qualifier("secondSqlSessionTemplate")
	private SqlSession sqlSession;
	
	public List query()
	{
		return this.sqlSession.selectList("com.rico.entity2.User.query");
	}

}
