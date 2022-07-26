package com.kaifamiao.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;


@PropertySource("classpath:db.properties")
public class JDBCConfig {

    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password ;

    @Bean(name = "dataSource")
    public DataSource createDataSource(){
        DruidDataSource pool = new DruidDataSource();

        pool.setDriverClassName(driver);
        pool.setUrl(url);
        pool.setUsername(username);
        pool.setPassword(password);

        return pool;
    }

    @Bean("transactionManager")
    public DataSourceTransactionManager creatTM(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    };
}
