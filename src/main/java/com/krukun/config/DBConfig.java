package com.krukun.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;

/**
 * Created by Eugeniy Krukun on 25.04.2016.
 */
@Configuration
@EnableJpaRepositories("com.krukun.repository")
@EnableTransactionManagement
@PropertySource("classpath:db.properties")
@ComponentScan("com.krukun")
public class DBConfig {
    @Resource
    public Environment env;
}
