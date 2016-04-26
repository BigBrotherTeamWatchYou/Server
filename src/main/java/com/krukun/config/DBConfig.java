package com.krukun.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

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
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(env.getRequiredProperty("db.entity.package"));
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setJpaProperties(getHibernateProperties());
        return em;
    }

    @Bean
    public DataSource dataSource() {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(env.getRequiredProperty("db.url"));
        basicDataSource.setDriverClassName(env.getRequiredProperty("db.driver"));
        basicDataSource.setUsername(env.getRequiredProperty("db.username"));
        basicDataSource.setPassword(env.getRequiredProperty("db.password"));

        basicDataSource.setInitialSize(Integer.valueOf(env.getRequiredProperty("db.initialSize")));
        basicDataSource.setMinIdle(Integer.valueOf(env.getRequiredProperty("db.minIdle")));
        basicDataSource.setMaxIdle(Integer.valueOf(env.getRequiredProperty("db.maxIdle")));
        basicDataSource.setTimeBetweenEvictionRunsMillis(Long.valueOf(env.getRequiredProperty("db.timeBetweenEvictionRunMillis")));
        basicDataSource.setMinEvictableIdleTimeMillis(Long.valueOf(env.getRequiredProperty("db.minEvictableIdleTimeMillis")));
        basicDataSource.setTestOnBorrow(Boolean.valueOf(env.getRequiredProperty("db.testOnBorrow")));
        basicDataSource.setValidationQuery(env.getProperty("db.validationQuery"));

        return basicDataSource;
    }
    @Bean
    public PlatformTransactionManager transactionManager(){
        JpaTransactionManager manager = new JpaTransactionManager();
        manager.setEntityManagerFactory(entityManagerFactory().getObject());
        return manager;
    }
    public Properties getHibernateProperties() {

        try {
            Properties properties = new Properties();
            InputStream stream = getClass().getClassLoader().getResourceAsStream("hibernate.properties");
            properties.load(stream);
            return properties;
        } catch (IOException e) {
            throw new IllegalArgumentException("Can't find 'hibernate.properties'",e);
        }
    }
}
