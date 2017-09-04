package com.demo.app.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import com.demo.app.entity.Category;

import chok.devwork.springboot.BaseDao;

@Component
public class ClientCategoryDao extends BaseDao<Category, Long>
{
//	指定装配哪个SqlSessionTemplate
//	方式一
//	@Autowired
//	@Qualifier("firstSqlSessionTemplate")
//	方式二
	@Resource(name = "firstSqlSessionTemplate")
	private SqlSession sqlSession;

	@Override
	protected Class<Category> getEntityClass()
	{
		return Category.class;
	}

	@Override
	protected SqlSession getSqlSession()
	{
		return sqlSession;
	}

}
