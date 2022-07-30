package com.kaifamiao.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.kaifamiao")
@Import({MybatisConfig.class,JDBCConfig.class})
@EnableTransactionManagement
public class SpringConfig {


}
