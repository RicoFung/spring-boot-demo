package com.rico.datasource;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class FirstDataSourceConfig 
{
    @Value("${first.datasource.url}")
    private String url;
    @Value("${first.datasource.username}")
    private String user;
    @Value("${first.datasource.password}")
    private String password;
    @Value("${first.datasource.driver-class-name}")
    private String driverClass;
    @Value("${first.datasource.initialSize}")
    private int initialSize;
    @Value("${first.datasource.maxActive}")
    private int maxActive;
    @Value("${first.datasource.minIdle}")
    private int minIdle;
    @Value("${first.datasource.maxWait}")
    private int maxWait;
    @Value("${first.datasource.mapper-location}")
    private String mapperLocation;
 
    @Bean(name = "firstDataSource")
    @Primary
    public DataSource firstDataSource() 
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
 
    @Bean(name = "firstTransactionManager")
    public DataSourceTransactionManager firstTransactionManager() 
    {
        return new DataSourceTransactionManager(firstDataSource());
    }
 
    @Bean(name = "firstSqlSessionFactory")
    public SqlSessionFactory firstSqlSessionFactory(@Qualifier("firstDataSource") DataSource firstDataSource) throws Exception 
    {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(firstDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocation));
        return sessionFactory.getObject();
    }

	@Bean(name = "firstSqlSessionTemplate")
	@Primary
	public SqlSessionTemplate firstSqlSessionTemplate(@Qualifier("firstSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception 
	{
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}