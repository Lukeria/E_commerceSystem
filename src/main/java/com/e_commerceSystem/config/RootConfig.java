package com.e_commerceSystem.config;

import com.e_commerceSystem.entities.Authority;
import com.e_commerceSystem.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

@Configuration
@PropertySource("classpath:hibernate.properties")
@EnableTransactionManagement
public class RootConfig {

    @Autowired
    private Environment environment;

    @Bean
    public LocalSessionFactoryBean getSessionFactory(){

        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();

        Properties properties = new Properties();
        // Setting JDBC properties
        properties.put(org.hibernate.cfg.Environment.DRIVER, environment.getProperty("mysql.driver"));
        properties.put(org.hibernate.cfg.Environment.URL, environment.getProperty("mysql.jdbcUrl"));
        properties.put(org.hibernate.cfg.Environment.USER, environment.getProperty("mysql.username"));
        properties.put(org.hibernate.cfg.Environment.PASS, environment.getProperty("mysql.password"));

        // Setting Hibernate properties
        properties.put(org.hibernate.cfg.Environment.SHOW_SQL, environment.getProperty("hibernate.show_sql"));
        properties.put(org.hibernate.cfg.Environment.HBM2DDL_AUTO, environment.getProperty("hibernate.hbm2ddl.auto"));

        // Setting C3P0 properties
        properties.put(org.hibernate.cfg.Environment.C3P0_MIN_SIZE, environment.getProperty("hibernate.c3p0.min_size"));
        properties.put(org.hibernate.cfg.Environment.C3P0_MAX_SIZE, environment.getProperty("hibernate.c3p0.max_size"));
        properties.put(org.hibernate.cfg.Environment.C3P0_ACQUIRE_INCREMENT, environment.getProperty("hibernate.c3p0.acquire_increment"));
        properties.put(org.hibernate.cfg.Environment.C3P0_TIMEOUT, environment.getProperty("hibernate.c3p0.timeout"));
        properties.put(org.hibernate.cfg.Environment.C3P0_MAX_STATEMENTS, environment.getProperty("hibernate.c3p0.max_statements"));

        sessionFactoryBean.setHibernateProperties(properties);
        sessionFactoryBean.setAnnotatedClasses(User.class, Authority.class);

        return sessionFactoryBean;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager() {

        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        return transactionManager;
    }
}
