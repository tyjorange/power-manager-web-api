package com.im.properties;

import com.alibaba.druid.pool.DruidDataSource;
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
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 数据源first
 * Created by vostor on 2018/12/29.
 */
@Configuration
//@ConfigurationProperties(prefix = "spring.datasource.first")
@MapperScan(basePackages = "com.im.mapper.first", sqlSessionTemplateRef = "firstSqlSessionTemplate")
public class DataSourceConfigFirst {
    @Value("${spring.datasource.first.username}")
    private String username;
    @Value("${spring.datasource.first.password}")
    private String password;
    @Value("${spring.datasource.first.driver-class-name}")
    private String className;
    @Value("${spring.datasource.first.url}")
    private String jdbcUrl;
    @Value("${spring.datasource.initialSize}")
    private Integer initialSize;
    @Value("${spring.datasource.maxActive}")
    private Integer maxActive;
    @Value("${spring.datasource.maxWait}")
    private Integer maxWait;
    @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
    private Integer timeBetweenEvictionRunsMillis;
    @Value("${spring.datasource.minEvictableIdleTimeMillis}")
    private Integer minEvictableIdleTimeMillis;
    @Value("${spring.datasource.minIdle}")
    private Integer minIdle;
    @Value("${spring.datasource.validationQuery}")
    private String validationQuery;
    @Value("${spring.datasource.testWhileIdle}")
    private Boolean testWhileIdle;
    @Value("${spring.datasource.testOnBorrow}")
    private Boolean testOnBorrow;
    @Value("${spring.datasource.testOnReturn}")
    private Boolean testOnReturn;
    @Value("${spring.datasource.poolPreparedStatements}")
    private Boolean poolPreparedStatements;
    @Value("${spring.datasource.filters}")
    private String filters;
    @Value("${spring.datasource.slowSqlMillis}")
    private String slowSqlMillis;
    @Value("${spring.datasource.logSlowSql}")
    private String logSlowSql;
    @Value("${spring.datasource.mergeSql}")
    private String mergeSql;

    @Primary
    @Bean(name = "firstDataSource", destroyMethod = "close", initMethod = "init")
    public DruidDataSource setDataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setDriverClassName(className);
        druidDataSource.setUrl(jdbcUrl);
        druidDataSource.setInitialSize(initialSize);
        druidDataSource.setMaxActive(maxActive);
        druidDataSource.setMaxWait(maxWait);
        druidDataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        druidDataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        druidDataSource.setMinIdle(minIdle);
        druidDataSource.setValidationQuery(validationQuery);
        druidDataSource.setTestWhileIdle(testWhileIdle);
        druidDataSource.setTestOnBorrow(testOnBorrow);
        druidDataSource.setTestOnReturn(testOnReturn);
        druidDataSource.setPoolPreparedStatements(poolPreparedStatements);
        druidDataSource.setFilters(filters);
        Properties properties = new Properties();
        properties.put("druid.stat.slowSqlMillis", slowSqlMillis);
        properties.put("druid.stat.logSlowSql", logSlowSql);
        properties.put("druid.stat.mergeSql", mergeSql);
        druidDataSource.setConnectProperties(properties);
        return druidDataSource;
    }

    @Primary
    @Bean(name = "firstTransactionManager")
    public DataSourceTransactionManager setTransactionManager(@Qualifier("firstDataSource") DataSource dataSource) {
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
