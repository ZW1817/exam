package com.kaifamiao.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.kaifamiao")
@Import({MybatisConfig.class,JDBCConfig.class})
public class SpringConfig {


}
