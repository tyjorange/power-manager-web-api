package com.im.properties;


import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by vostor on 2018/12/29.
 */
@Configuration
@MapperScan(basePackages = "com.im.mapper.first", sqlSessionTemplateRef = "firstSqlSessionTemplate")
public class DataSourceConfigFirst {
    @Primary
    @Bean(name = "firstDataSource", destroyMethod = "close", initMethod = "init")
    @ConfigurationProperties(prefix = "spring.datasource.first")
    public DruidDataSource setDataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("123456");
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/power_manager?useSSL=false");
        druidDataSource.setInitialSize(2);
        druidDataSource.setMaxActive(20);
        druidDataSource.setMaxWait(30000);
        druidDataSource.setTimeBetweenEvictionRunsMillis(30000);
        druidDataSource.setMinEvictableIdleTimeMillis(30000);
        druidDataSource.setValidationQuery("select 1");
        druidDataSource.setTestWhileIdle(true);
        druidDataSource.setTestOnBorrow(false);
        druidDataSource.setTestOnReturn(false);
        druidDataSource.setPoolPreparedStatements(false);
        Properties properties = new Properties();
        properties.put("druid.stat.slowSqlMillis", "10000");
        properties.put("druid.stat.logSlowSql", "true");
        properties.put("druid.stat.mergeSql", "true");
        druidDataSource.setConnectProperties(properties);
        druidDataSource.setFilters("stat,wall,log4j");
        return druidDataSource;
    }

    @Primary
    @Bean(name = "firstTransactionManager")
    public DataSourceTransactionManager setTransactionManager(@Qualifier("firstDataSource") DruidDataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Primary
    @Bean(name = "firstSqlSessionFactory")
    public SqlSessionFactory setSqlSessionFactory(@Qualifier("firstDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/first/*.xml"));
        return bean.getObject();
    }

    @Primary
    @Bean(name = "firstSqlSessionTemplate")
    public SqlSessionTemplate setSqlSessionTemplate(@Qualifier("firstSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
