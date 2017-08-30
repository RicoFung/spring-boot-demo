package com.rico.datasource;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class SecondDataSourceConfig 
{
	@Value("${second.datasource.mapper-location}")
    private String mapperLocation;
    @Value("${second.datasource.url}")
    private String url;
    @Value("${second.datasource.username}")
    private String user;
    @Value("${second.datasource.password}")
    private String password;
    @Value("${second.datasource.driver-class-name}")
    private String driverClass;
    @Value("${second.datasource.initialSize}")
    private int initialSize;
    @Value("${second.datasource.maxActive}")
    private int maxActive;
    @Value("${second.datasource.minIdle}")
    private int minIdle;
    @Value("${second.datasource.maxWait}")
    private int maxWait;
 
    @Bean(name = "secondDataSource")
    public DataSource secondDataSource() 
    {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        dataSource.setInitialSize(initialSize);
        dataSource.setMaxActive(maxActive);
        dataSource.setMaxActive(maxActive);
        dataSource.setMinIdle(minIdle);
        dataSource.setMaxWait(maxWait);
        return dataSource;
    }
 
    @Bean(name = "secondTransactionManager")
    public DataSourceTransactionManager secondTransactionManager() 
    {
        return new DataSourceTransactionManager(secondDataSource());
    }
 
    @Bean(name = "secondSqlSessionFactory")
    public SqlSessionFactory secondSqlSessionFactory(@Qualifier("secondDataSource") DataSource secondDataSource) throws Exception 
    {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(secondDataSource);
		sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocation));
        return sessionFactory.getObject();
    }

	@Bean(name = "secondSqlSessionTemplate")
	public SqlSessionTemplate secondSqlSessionTemplate(@Qualifier("secondSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception 
	{
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}