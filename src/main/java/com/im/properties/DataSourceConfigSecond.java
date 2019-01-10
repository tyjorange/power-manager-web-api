package com.im.properties;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
@MapperScan(basePackages = "com.im.mapper.second", sqlSessionTemplateRef = "secondSqlSessionTemplate")
public class DataSourceConfigSecond {
    @Bean(name = "secondDataSource", destroyMethod = "close", initMethod = "init")
    @ConfigurationProperties(prefix = "spring.datasource.second")
    public DruidDataSource setDataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("123456");
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/power_manager_user?useSSL=false");
        druidDataSource.setInitialSize(1);
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
        properties.put("druid.stat.aop-patterns", "com.im.mapper.*");
        druidDataSource.setConnectProperties(properties);
        druidDataSource.setFilters("stat,wall,log4j");
        return druidDataSource;
    }

    @Bean(name = "secondTransactionManager")
    public DataSourceTransactionManager setTransactionManager(@Qualifier("secondDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "secondSqlSessionFactory")
    public SqlSessionFactory setSqlSessionFactory(@Qualifier("secondDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/second/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "secondSqlSessionTemplate")
    public SqlSessionTemplate setSqlSessionTemplate(@Qualifier("secondSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
