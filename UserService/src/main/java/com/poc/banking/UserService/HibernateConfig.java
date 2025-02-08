package com.poc.banking.UserService;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

//@Configuration
//public class HibernateConfig {
//
//    @Value("${spring.jpa.properties.hibernate.dialect}")
//    private String hibernateDialect;
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
//        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
//        factoryBean.setDataSource(dataSource);
//        factoryBean.setPackagesToScan("com.poc.banking.UserService.entity"); // Update with your entity package
//        factoryBean.setJpaProperties(hibernateProperties());
//        return factoryBean;
//    }
//
//    private Properties hibernateProperties() {
//        Properties properties = new Properties();
//        properties.setProperty("hibernate.dialect", hibernateDialect);
//        properties.setProperty("hibernate.show_sql", "true");
//        properties.setProperty("hibernate.format_sql", "true");
//        return properties;
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
//        return new JpaTransactionManager(entityManagerFactory);
//    }
//
//    @Bean
//    public EntityManager entityManager(EntityManagerFactory entityManagerFactory) {
//        return entityManagerFactory.createEntityManager();
//    }
//}
